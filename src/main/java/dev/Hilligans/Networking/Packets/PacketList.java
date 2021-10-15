package dev.Hilligans.Networking.Packets;

import dev.Hilligans.Networking.Packets.Play.Client.*;
import dev.Hilligans.Networking.Packets.Play.Server.*;
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
        //Server bound play packets
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

        //Client bound play packets
        put("SSpawnEntity", SSpawnEntity::new);
        put("SSpawnExperienceOrb", SSpawnExperienceOrb::new);
        put("SSpawnLivingEntity", SSpawnLivingEntity::new);
        put("SSpawnPainting", SSpawnPainting::new);
        put("SSpawnPlayer", SSpawnPlayer::new);
        put("SEntityAnimation", SEntityAnimation::new);
        put("SStatistics", SStatistics::new);
        put("SAcknowledgePlayerDigging", SAcknowledgePlayerDigging::new);
        put("SBlockBreakAnimation", SBlockBreakAnimation::new);
        put("SBlockEntityData", SBlockEntityData::new);
        put("SBlockAction", SBlockAction::new);
        put("SBlockChange", SBlockChange::new);
        put("SBossBar", SBossBar::new);
        put("SServerDifficulty", SServerDifficulty::new);
        put("SChatMessage", SChatMessage::new);
        put("STabComplete", STabComplete::new);
        put("SDeclareCommands", SDeclareCommands::new);
        put("SWindowConfirmation", SWindowConfirmation::new);
        put("SCloseWindow", SCloseWindow::new);
        put("SWindowItems", SWindowItems::new);
        put("SWindowProperty", SWindowProperty::new);
        put("SSetSlot", SSetSlot::new);
        put("SSetCooldown", SSetCooldown::new);
        put("SPluginMessage", SPluginMessage::new);
        put("SNamedSoundEffect", SNamedSoundEffect::new);
        put("SDisconnect", SDisconnect::new);
        put("SEntityStatus", SEntityStatus::new);
        put("SExplosion", SExplosion::new);
        put("SUnloadChunk", SUnloadChunk::new);
        put("SChangeGameState", SChangeGameState::new);
        put("SOpenHorseWindow", SOpenHorseWindow::new);
        put("SKeepAlive", SKeepAlive::new);
        put("SChunkData",SChunkData::new);
        put("SEffect", SEffect::new);
        put("SParticle", SParticle::new);
        put("SUpdateLight", SUpdateLight::new);
        put("SJoinGame", SJoinGame::new);
        put("SMapData", SMapData::new);
        put("STradeList", STradeList::new);
        put("SEntityPosition", SEntityPosition::new);
        put("SEntityPositionAndRotation", SEntityPositionAndRotation::new);
        put("SEntityRotation", SEntityRotation::new);
        put("SEntityMovement", SEntityMovement::new);
        put("SVehicleMove", SVehicleMove::new);
        put("SOpenBook", SOpenBook::new);
        put("SOpenWindow", SOpenWindow::new);
        put("SOpenSignEditor", SOpenSignEditor::new);
        put("SCraftRecipeResponse", SCraftRecipeResponse::new);
        put("SPlayerAbilities", SPlayerAbilities::new);
        put("SCombatEvent", SCombatEvent::new);
        put("SPlayerInfo", SPlayerInfo::new);
        put("SFacePlayer", SFacePlayer::new);
        put("SPlayerPositionAndLook", SPlayerPositionAndLook::new);
        put("SUnlockRecipes", SUnlockRecipes::new);
        put("SDestroyEntities", SDestroyEntities::new);
        put("SRemoveEntityEffect", SRemoveEntityEffect::new);
        put("SResourcePackSend", SResourcePackSend::new);
        put("SRespawn", SRespawn::new);
        put("SEntityHeadLock", SEntityHeadLock::new);
        put("SMultiBlockChange", SMultiBlockChange::new);
        put("SSelectAdvancementTab", SSelectAdvancementTab::new);
        put("SWorldBorder", SWorldBorder::new);
        put("SCamera", SCamera::new);
        put("SHeldItemChange", SHeldItemChange::new);
        put("SUpdateViewPosition",SUpdateViewPosition::new);
        put("SUpdateViewDistance", SUpdateViewDistance::new);
        put("SSpawnPosition", SSpawnPosition::new);
        put("SDisplayScoreboard", SDisplayScoreboard::new);
        put("SEntityMetadata",SEntityMetadata::new);
        put("SAttachEntity", SAttachEntity::new);
        put("SEntityVelocity", SEntityVelocity::new);
        put("SEntityEquipment", SEntityEquipment::new);
        put("SSetExperience", SSetExperience::new);
        put("SUpdateHealth", SUpdateHealth::new);
        put("SScoreboardObjective", SScoreboardObjective::new);
        put("SSetPassengers", SSetPassengers::new);
        put("STeams", STeams::new);
        put("SUpdateScore", SUpdateScore::new);
        put("STimeUpdate", STimeUpdate::new);
        put("STitle", STitle::new);
        put("SEntitySoundEffect", SEntitySoundEffect::new);
        put("SSoundEffect", SSoundEffect::new);
        put("SStopSound", SStopSound::new);
        put("SPlayerListHeaderAndFooter", SPlayerListHeaderAndFooter::new);
        put("SNBTQueryResponse", SNBTQueryResponse::new);
        put("SCollectItem", SCollectItem::new);
        put("SEntityTeleport" ,SEntityTeleport::new);
        put("SAdvancements", SAdvancements::new);
        put("SEntityProperties", SEntityProperties::new);
        put("SEntityEffect", SEntityEffect::new);
        put("SDeclareRecipes", SDeclareRecipes::new);
        put("STags", STags::new);

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
