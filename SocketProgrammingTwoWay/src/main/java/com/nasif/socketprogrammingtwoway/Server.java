package com.nasif.socketprogrammingtwoway;
/* @author Nasif Azam */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5243);
        System.out.println("Server is connected at port no : " + serverSocket.getLocalPort());
        System.out.println("Server is connecting..\nWaiting for the client..");
        Socket socket = new Socket();
        socket = serverSocket.accept();
        System.out.println("Client request is accepted at port no: " + socket.getPort() + "\nServer’s Communication Port: "+socket.getLocalPort());
        System.out.println("Send \" stop\" to close the connection.");  
        
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); //For write message to the client 
        DataInputStream dis = new DataInputStream(socket.getInputStream()); //For read message from the client
        Scanner sc = new Scanner(System.in);
        
        String str1 = "";
        String str2 = "";
        while (!str1.equals("stop")) {
            str1 = dis.readUTF();
            System.out.println("Client : " + str1);
            
            System.out.print("Server : ");
            str2 = sc.nextLine();
            dos.writeUTF(str2);
        }
        //close the connections
        serverSocket.close();
        socket.close();
        dos.close();
        dis.close();
        System.out.println("Disconnceted");
    }
}