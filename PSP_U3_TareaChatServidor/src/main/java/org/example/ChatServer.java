package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ChatServer {

    private int port; // Puerto en el que escucha el servidor
    private static final int DEFAULT_PORT = 12345; // Puerto predeterminado
    private static final Set<ClientHandler> clients = Collections.synchronizedSet(new HashSet<>()); // Lista sincronizada de clientes conectados al servidor
    private boolean running = true;

    public ChatServer() {
        this.port = DEFAULT_PORT; // Inicia con el puerto predeterminado
    }

    // Solicita puerto con validaciones y aplica el cambio dinámicamente
    public void configurarPuerto() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el puerto para el servidor (por defecto 12345): ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            this.port = DEFAULT_PORT;
            System.out.println("Usando el puerto predeterminado: " + DEFAULT_PORT);
        } else {
            try {
                int selectedPort = Integer.parseInt(input);
                if (selectedPort > 0 && selectedPort <= 65535) {
                    this.port = selectedPort;
                    System.out.println("Puerto configurado en: " + selectedPort);
                } else {
                    System.out.println("Puerto fuera de rango. Usando el puerto predeterminado: " + DEFAULT_PORT);
                    this.port = DEFAULT_PORT;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Usando el puerto predeterminado: " + DEFAULT_PORT);
                this.port = DEFAULT_PORT;
            }
        }
    }

    // Inicia el servidor en el puerto configurado.
    public void iniciarServidor() {
        System.out.println("Servidor iniciado en el puerto: " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Esperando conexiones...");

            while (running) {
                try {
                    Socket socket = serverSocket.accept(); // Acepta conexión
                    System.out.println("Cliente conectado: " + socket.getRemoteSocketAddress()); // Imprime la dirección

                    ClientHandler clientHandler = new ClientHandler(socket);
                    clients.add(clientHandler); // Añade el cliente a la lista de clientes conectados
                    new Thread(clientHandler).start(); // Crea un nuevo hilo para el cliente y lo inicia
                } catch (IOException e) {
                    System.err.println("Error al aceptar conexión: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
            e.printStackTrace();
        } finally {
            stopServer();
        }

    }

    public static void broadcast(String message, ClientHandler excludeClient) {
        synchronized (clients) {
            for (ClientHandler client : clients) {
                if (client != excludeClient) {
                    client.sendMessage(message);
                }
            }
        }
    }

    public static void removeClient(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public void stopServer() {
        running = false;
        System.out.println("Servidor detenido.");
    }
}