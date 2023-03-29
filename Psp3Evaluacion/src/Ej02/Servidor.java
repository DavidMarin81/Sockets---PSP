package Ej02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int port = 6000;
        ServerSocket servidor = null;
        Socket clienteConectado = null;
        try {
            servidor = new ServerSocket(port);
            for (int i = 1; i <= 3; i++) {
                System.out.println("Esperando al cliente " + i + "  ...");
                clienteConectado = servidor.accept();
                System.out.println("Puerto Local del Socket: " + servidor.getLocalPort());
                System.out.println("Puerto remoto: " + clienteConectado.getPort());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
