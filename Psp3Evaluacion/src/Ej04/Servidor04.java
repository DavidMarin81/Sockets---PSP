package Ej04;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor04 {
    public static void main(String[] args) {
        int port = 6000;
        ServerSocket servidor = null;
        Socket clienteConectado = null;
        try {
            System.out.println("Se inicia el servidor");
            servidor = new ServerSocket(port);
            clienteConectado = servidor.accept();

            //Se recibe el mensaje
            DataInputStream mensajeDelCliente = new DataInputStream(clienteConectado.getInputStream());
            int cuadrado = mensajeDelCliente.readInt();
            System.out.println("Se recibe el mensaje del cliente..." + cuadrado);

            cuadrado = cuadrado * cuadrado;

            //Se envia el mensaje
            DataOutputStream mensaje = new DataOutputStream(clienteConectado.getOutputStream());
            mensaje.writeInt(cuadrado);
            System.out.println("Se envia el numero " + cuadrado);

            mensaje.close();
            mensajeDelCliente.close();
            servidor.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
