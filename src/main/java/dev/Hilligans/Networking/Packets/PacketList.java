package dev.Hilligans.Networking.Packets;

import dev.Hilligans.Networking.Packets.Play.Client.*;
import dev.Hilligans.ourcraft.ModHandler.Content.ModContent;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.Protocol;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.function.Supplier;

public class PacketList {

    public static HashMap<String, Supplier<PacketBase>> packets = new HashMap<>();

    public static void put(String name, Supplier<PacketBase> packetBaseSupplier) {
        packets.put(name,packetBaseSupplier);
    }

    public static void registerPackets() {
        put("CTeleportConfirm", CTeleportConfirm::new);
        put("CQueryBlockNBT", CQueryBlockNBT::new);
        put("CSetDifficulty", CSetDifficulty::new);
        put("CChatMessage", CChatMessage::new);
        put("CClientStatus", CClientStatus::new);
        put("CClientSettings",CClientSettings::new);
        put("CTabComplete",CTabComplete::new);
        put("CWindowConfirmation",CWindowConfirmation::new);
        put("CClickWindowButton", CClickWindowButton::new);
        put("CClickWindow", CClickWindow::new);
        put("CCloseWindow",CCloseWindow::new);
        put("CPluginMessage", CPluginMessage::new);
        put("CEditBook",CEditBook::new);
        put("CQueryEntityNBT", CQueryEntityNBT::new);
        put("CEntityInteract", CEntityInteract::new);
        put("CGenerateStructure", CGenerateStructure::new);
        put("CKeepAlive", CKeepAlive::new);
        put("CLockDifficulty", CLockDifficulty::new);
        put("CPlayerPosition", CPlayerPosition::new);
        put("CPlayerPositionAndRotation", CPlayerPositionAndRotation::new);
        put("CPlayerRotation", CPlayerRotation::new);
        put("CPlayerMovement", CPlayerMovement::new);
        put("CVehicleMovement", CVehicleMovement::new);
        put("CSteerBoat", CSteerBoat::new);
        put("CPickItem", CPickItem::new);
        put("CCraftRecipeRequest", CCraftRecipeRequest::new);
        put("CPlayerAbilities", CPlayerAbilities::new);
        put("CPlayerDigging", CPlayerDigging::new);
        put("CEntityAction", CEntityAction::new);
        put("CSteerVehicle", CSteerVehicle::new);
        put("CSetRecipeBookState", CSetRecipeBookState::new);
        put("CSetDisplayedRecipe", CSetDisplayedRecipe::new);
        put("CNameItem", CNameItem::new);
        put("CResourcePackStatus", CResourcePackStatus::new);
        put("CAdvancementTab", CAdvancementTab::new);
        put("CSelectTrade", CSelectTrade::new);
        put("CSetBeaconEffect", CSetBeaconEffect::new);
        put("CHeldItemChange", CHeldItemChange::new);
        put("CUpdateCommandBlock", CUpdateCommandBlock::new);
        put("CUpdateCommandBlockMinecart", CUpdateCommandBlockMinecart::new);
        put("CCreativeInventoryAction", CCreativeInventoryAction::new);
        put("CUpdateJigsawBlock", CUpdateJigsawBlock::new);
        put("CUpdateStructureBlock", CUpdateStructureBlock::new);
        put("CUpdateSign", CUpdateSign::new);
        put("CAnimation", CAnimation::new);
        put("CSpectate", CSpectate::new);
        put("CPlayerBlockPlacement", CPlayerBlockPlacement::new);
        put("CUseItem", CUseItem::new);
    }

    public static void putIntoProtocol(String protocolName, JSONObject jsonObject, ModContent modContent) {
        for(String name : jsonObject.keySet()) {
            int id = jsonObject.getInt(name);
            Supplier<PacketBase> packet = packets.get(name);
            if(packet != null) {
                modContent.registerPacket(protocolName,id,packet);
            } else {
                System.err.println("Missing packet " + name + " from registry");
            }
        }
    }

}
