package org.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345; // Puerto de escucha

    // Lista sincronizada de clientes conectados al servidor
    // Es un conjunto (Set) que guarda las instancias de la clase ManejadorCliente
    static final Set<ManejadorCliente> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("Servidor iniciado. Esperando conexiones...");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {  // Crea un ServerSocket para escuchar conexiones en el puerto especificado
            while (true) {  // bucle esperando conexiones
                Socket socket = serverSocket.accept();  // Acepta una nueva conexión
                System.out.println("Cliente conectado: " + socket.getRemoteSocketAddress());  // Imprime la dirección

                // Crea un objeto ManejadorCliente
                ManejadorCliente clientHandler = new ManejadorCliente(socket);

                clients.add(clientHandler); // Añade el cliente a la lista de clientes conectados

                // Crea un nuevo hilo para el cliente y lo inicia
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
