package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ManejadorCliente implements Runnable {
    private final Socket socket; // Representa la conexión del cliente al servidor.
    private PrintWriter escribir; // Permite enviar mensajes al cliente.
    private BufferedReader leer; // Permite leer mensajes enviados por el cliente.

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Inicialización de flujos de entrada y salida
            leer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            escribir = new PrintWriter(socket.getOutputStream(), true);

            // Notifica a todos los clientes que un nuevo usuario se ha unido
            comunicacion("Nuevo usuario unido al chat");

            // Bucle para leer mensajes del cliente
            String mensaje;
            while ((mensaje = leer.readLine()) != null) {
                System.out.println("Mensaje: " + mensaje); // Muestra el mensaje en la consola del servidor
                comunicacion(mensaje); // Reenvía el mensaje a todos los demás clientes
            }
        } catch (IOException e) {
            System.out.println("Error en la conexión con el cliente: " + socket.getRemoteSocketAddress());
        } finally {
            try {
                socket.close(); // Cierra el socket
            } catch (IOException e) {
                e.printStackTrace();
            }
            ChatServer.clients.remove(this); // Elimina al cliente de la lista de clientes conectados
            comunicacion("Un usuario ha abandonado el chat.");
        }
    }

    private void comunicacion(String message) {
        // Sincroniza el acceso a la lista de clientes para evitar problemas de concurrencia
        synchronized (ChatServer.clients) {
            for (ManejadorCliente client : ChatServer.clients) {
                if (client != this) { // Evita enviar el mensaje al cliente remitente
                    client.escribir.println(message); // Envía el mensaje al cliente
                }
            }
        }
    }
}

