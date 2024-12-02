package org.example.FTP;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

public class ApacheFTPClient {
    private String server;
    private int port;
    private String user;
    private String password;
    private FTPClient ftp;

    public ApacheFTPClient(String server, int port, String user, String password) {
        this.server = server;
        this.port = port;
        this.user = user;
        this.password = password;
    }

    void open() throws IOException {
        ftp = new FTPClient();
        ftp.connect(server, port);
        int reply = ftp.getReplyCode();
        if (!FTPReply.isPositiveCompletion(reply)) {
            ftp.disconnect();
            throw new IOException("Exception in connecting to FTP Server");
        }
        ftp.login(user, password);
    }

    void close() throws IOException {
        ftp.disconnect();
    }


    public static void main(String[] args) throws IOException {
        ApacheFTPClient client = new ApacheFTPClient("192.168.12.102", 21, "pruebaftp", "pruebaftp");
        client.open();
        client.close();
    }
}
