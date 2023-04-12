package Ej05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Servidor05 {
    public static void main(String[] args) throws Exception {
        byte[] buffer = new byte[1024];
        DatagramSocket socket = new DatagramSocket(12345);

        System.out.println("Esperando el mensaje...");
        DatagramPacket recibo = new DatagramPacket(buffer, buffer.length);
        socket.receive(recibo);

        int bytesRec = recibo.getLength();
        String paquete = new String(recibo.getData());

        System.out.println("Numero de bytes recibidos: " + bytesRec);
        System.out.println("Mensaje recibido: " + paquete.trim());

        socket.close();
    }
}
