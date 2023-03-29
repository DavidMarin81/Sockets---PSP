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
            servidor = new ServerSocket(port);
            clienteConectado = servidor.accept();
            //Se envia el mensaje
            System.out.println("Se envia el mensaje...");
            DataOutputStream mensaje = new DataOutputStream(clienteConectado.getOutputStream());
            mensaje.writeUTF("MENSAJE PARA EL CLIENTE");
            mensaje.close();

            System.out.println("Esperando la respuesta del cliente...");
            clienteConectado = servidor.accept();

            DataInputStream mensajeDelCliente = new DataInputStream(clienteConectado.getInputStream());
            System.out.println("Se recibe el mensaje del cliente...");
            System.out.println(mensajeDelCliente.read());

            mensajeDelCliente.close();
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
