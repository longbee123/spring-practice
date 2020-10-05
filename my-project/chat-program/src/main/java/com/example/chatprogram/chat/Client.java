package com.example.chatprogram.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
    private final Socket socket;
    private final InputStream in;
    private final OutputStream out;

    public Client(String address , int port) throws IOException {
        this.socket = new Socket(address,port);
        this.in = socket.getInputStream();
        this.out = socket.getOutputStream();
    }
    private void send(String message) throws IOException {
        out.write(message.getBytes());
    }

    @Override
    public void run() {
        byte[] buffer = new byte[2048];
        try {
            while (true) {
                int receivedBytes = in.read(buffer);
                if (receivedBytes < 1)
                    break;
                String message = new String(buffer, 0, receivedBytes);
                System.out.println(message);
            }
        } catch (IOException e) {
        }
        close();
        System.exit(0);
    }
    private void close(){
        try {
            socket.close();
        } catch (IOException e) {

        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Please input your username: ");
        Scanner scanner = new Scanner(System.in);
        Client client = null;
        String messages = scanner.nextLine();
        System.out.println("Wellcome "+messages+" join group chat ");
        try {
            client = new Client("192.90.51.122", 6000);
            client.send(messages);
            client.start();
            while(true){
                messages = scanner.nextLine();
                client.send(messages);
            }
        }catch (IOException e){

        }
        if (client != null) {
            client.close();
        }
            scanner.close();


    }
}
