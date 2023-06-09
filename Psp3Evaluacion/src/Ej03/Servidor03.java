package Ej03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor03 {
    public static void main(String[] args) {
        int port = 6000;
        ServerSocket servidor = null;
        Socket clienteConectado = null;
        try {
            System.out.println("Se inicia el servidor");
            servidor = new ServerSocket(port);
            clienteConectado = servidor.accept();
            //Se envia el mensaje
            System.out.println("Se envia el mensaje...");
            DataOutputStream mensaje = new DataOutputStream(clienteConectado.getOutputStream());
            mensaje.writeUTF("MENSAJE PARA EL CLIENTE");

            System.out.println("Esperando la respuesta del cliente...");
            clienteConectado = servidor.accept();

            DataInputStream mensajeDelCliente = new DataInputStream(clienteConectado.getInputStream());
            System.out.println("Se recibe el mensaje del cliente..." + mensajeDelCliente.read());

            mensaje.close();
            mensajeDelCliente.close();
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
