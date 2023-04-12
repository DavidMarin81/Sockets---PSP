package Ej04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String host = "localhost";
        int puerto = 6000;
        Socket cliente = null;

        try {
            System.out.println("Introduce un numero: ");
            int numero = sc.nextInt();
            //Se envia el mensaje
            cliente = new Socket(host, puerto);
            DataOutputStream mensajeParaServidor = new DataOutputStream(cliente.getOutputStream());;
            mensajeParaServidor.writeInt(numero);
            System.out.println("Se envia el numero " + numero);

            System.out.println("Esperando la respuesta del servidor...");

            //Se recibe el mensaje
            DataInputStream mensajeRecibido = new DataInputStream(cliente.getInputStream());
            System.out.println("El cuadrado de " + numero + " es " + mensajeRecibido.readInt());

            mensajeRecibido.close();
            mensajeParaServidor.close();
            cliente.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
