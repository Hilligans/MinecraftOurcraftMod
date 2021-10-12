package dev.Hilligans.Networking.Packets.Login;

import dev.Hilligans.ourcraft.ClientMain;
import dev.Hilligans.ourcraft.Network.PacketBase;
import dev.Hilligans.ourcraft.Network.PacketData;
import dev.Hilligans.ourcraft.Util.ConsoleReader;
import dev.Hilligans.Main;
import dev.Hilligans.Networking.Packets.Play.Client.CSendChatMessage;
import dev.Hilligans.Networking.Packets.Play.Server.SSendChatMessage;

public class SLoginSuccess extends PacketBase {
    @Override
    public void encode(PacketData packetData) {

    }

    @Override
    public void decode(PacketData packetData) {
        Main.network.receiveProtocol = Main.modContent.protocols.get("MinecraftPlayClientBound");
        Main.network.sendProtocol = Main.modContent.protocols.get("MinecraftPlayServerBound");
        ClientMain.getClient().valid = true;
        ClientMain.getClient().renderWorld = true;
        ConsoleReader consoleReader = new ConsoleReader(new ConsoleReader.ConsoleEvent() {
            @Override
            public void invoke(String s) {
                Main.network.sendPacket(new CSendChatMessage(s));
            }
        });

    }

    @Override
    public void handle() {

    }
}
