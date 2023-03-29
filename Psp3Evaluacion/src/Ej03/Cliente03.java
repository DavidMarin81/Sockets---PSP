package Ej03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente03 {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        Socket cliente = null;
        try {
            cliente = new Socket(host, puerto);

            //Se recibe el mensaje
            DataInputStream mensajeDelServidor = new DataInputStream(cliente.getInputStream());
            System.out.println(mensajeDelServidor.read());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
