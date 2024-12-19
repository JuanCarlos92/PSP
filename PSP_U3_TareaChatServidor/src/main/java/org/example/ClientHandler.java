package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler implements Runnable {
    private final Socket socket;
    private PrintWriter escribir;
    private BufferedReader leer;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            leer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            escribir = new PrintWriter(socket.getOutputStream(), true);

            ChatServer.broadcast("Nuevo usuario se unió al chat", this);

            String mensaje;
            while ((mensaje = leer.readLine()) != null) {
                System.out.println("Mensaje recibido: " + mensaje);
                ChatServer.broadcast(mensaje, this);
            }
        } catch (IOException e) {
            System.out.println("Conexión perdida con el cliente: " + socket.getRemoteSocketAddress());
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ChatServer.removeClient(this);
        ChatServer.broadcast("Un usuario ha salido del chat", null);
    }

    public void sendMessage(String message) {
        if (escribir != null) {
            escribir.println(message);
        }
    }
}
