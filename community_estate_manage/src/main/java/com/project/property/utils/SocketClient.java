package com.project.property.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Since 2022/5/10 13:24
 */
public class SocketClient {
    private Socket socket = null;
    OutputStream outputStream = null;
    InputStream inputStream = null;

    public SocketClient(String host, int port) {

        try {
            socket = new Socket(host, port);
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendRequest(String req) throws IOException {
        outputStream.write(req.getBytes());
    }

    public String receive() throws IOException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024 * 2];
        while (true) {
            int len = inputStream.read(buffer);
            if (len == -1) {
                // 连接已关闭
                break;
            }
            arrayOutputStream.write(buffer, 0, len);

            if (inputStream.available() == 0) {
                break;
            }
        }

        return new String(arrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }

    public void close() throws IOException {
        socket.close();
    }

    public Socket getSocket() {
        return socket;
    }
}
