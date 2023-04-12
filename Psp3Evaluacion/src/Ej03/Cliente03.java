package Ej03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Cliente03 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        Socket cliente = null;
        try {
            System.out.println("Se inicia el cliente...");
            //Se recibe el mensaje
            cliente = new Socket(host, puerto);
            DataInputStream mensajeDelServidor = new DataInputStream(cliente.getInputStream());
            System.out.println(mensajeDelServidor.read());
            DataOutputStream mensajeParaServidor = new DataOutputStream(cliente.getOutputStream());
            String mensaje = mensajeDelServidor.readUTF();
            mensajeParaServidor.writeUTF(mensaje.toLowerCase());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
