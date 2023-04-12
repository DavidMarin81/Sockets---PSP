package Ej05;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente05 {
    public static void main(String[] args) throws Exception {
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12345;
        byte[] mensaje = new byte[1024];

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce una cadena:");
        String cadena = scan.nextLine();
        System.out.println("Mensaje: " + cadena);
        mensaje = cadena.getBytes();

        //Se construye el Datagram para enviar
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket socket = new DatagramSocket(34567);

        socket.send(envio);
        socket.close();
    }
}
