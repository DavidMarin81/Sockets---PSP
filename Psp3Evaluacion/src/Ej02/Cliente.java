package Ej02;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;
        Socket cliente = null;
        try {
            cliente = new Socket(host, puerto);
            System.out.println("Se crea el cliente ");
            cliente.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
