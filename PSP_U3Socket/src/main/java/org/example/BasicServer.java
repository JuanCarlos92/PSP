package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicServer {

    public static final int PORT = 4444;

    public static void main(String[] args) throws IOException {
        // Establece el puerto en el que escucha peticiones
        ServerSocket socketServidor = null;
        try {
            socketServidor = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("No puede escuchar en el puerto: " + PORT);
        }

        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        System.out.println("Escuchando: " + socketServidor);
        try {
            // Se bloquea hasta que recibe alguna petición de un cliente abriendo un socket para el cliente
            socketCliente = socketServidor.accept();
            System.out.println("Conexión aceptada: " + socketCliente);
            // Establece canal de entrada
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketCliente.getOutputStream())), true);
            // Hace eco de lo que le proporciona el cliente, hasta que recibe "Adios"
            while (true) {
                // Recibe la solicitud del cliente por el InputStream
                String str = entrada.readLine();
                // Envía a la salida estándar el mensaje del cliente
                System.out.println("Cliente: " + str);
                // Le envía la respuesta al cliente por el OutputStream
                salida.println(str);
                // Si es "Adios" es que finaliza la comunicación
                if (str.equals("Adios")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
