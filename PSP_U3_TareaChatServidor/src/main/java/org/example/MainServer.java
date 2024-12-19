package org.example;

public class MainServer {
    public static void main(String[] args) {
        ChatServer servidor = new ChatServer();
        servidor.configurarPuerto(); // Configura el puerto
        servidor.iniciarServidor(); // Inicia el servidor
    }
}
