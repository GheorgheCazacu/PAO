package com.fmi.lab;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientMain {


    private final static int SERVER_PORT = 9090;
    private final static int CLIENT_PORT = 9191;


    public static void main(String[] args) {

        try {
            DatagramSocket datagramSocket = new DatagramSocket(CLIENT_PORT,
                    InetAddress.getLocalHost());


            Scanner scanner = new Scanner(System.in);
            System.out.println("introdu un mesaj:");
            String message = scanner.nextLine();

            while (!"".equals(message)) {

                DatagramPacket datagramPacket =
                        new DatagramPacket(message.getBytes(),
                        message.getBytes().length, InetAddress.getLocalHost(),
                                SERVER_PORT);

                datagramSocket.send(datagramPacket);
                System.out.println("introdu un mesaj:");
                message = scanner.nextLine();
            }




        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
