package dev.Hilligans.Networking.Packets.Login;

import Hilligans.ClientMain;
import Hilligans.Network.PacketBase;
import Hilligans.Network.PacketData;
import Hilligans.Util.ConsoleReader;
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
