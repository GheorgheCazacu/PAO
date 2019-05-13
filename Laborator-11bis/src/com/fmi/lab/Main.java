package com.fmi.lab;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {

    private final static int SERVER_PORT = 9090;
    private final static int DP_SIZE = 256;

    public static void main(String[] args) {

        try {
            DatagramSocket datagramSocket = new DatagramSocket(SERVER_PORT);
            DatagramPacket datagramPacket = new DatagramPacket(
                    new byte[DP_SIZE], DP_SIZE);

            while (true) {

                datagramSocket.receive(datagramPacket);

                System.out.println("port: " + datagramPacket.getPort());
                System.out.println("port: "
                        + new String(datagramPacket.getData(),
                        datagramPacket.getData().length));


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
