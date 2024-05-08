package com.nasif.socketprogrammingtwoway;
/* @author Nasif Azam */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5243);
        System.out.println("Client Connected at server Handshaking port : " + socket.getPort());
        System.out.println("Client’s communcation port : " + socket.getLocalPort());
        System.out.println("Client request accepted."+"\nConnceted to the Server.\nSend \" stop\" to close the connection.");
        
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); //For write message to the server 
        DataInputStream dis = new DataInputStream(socket.getInputStream()); //For read message from the server
        Scanner sc = new Scanner(System.in); 
        String str1 = "";
        String str2 = "";
        while (!str1.equals("stop")) {
            System.out.print("Client : " );
            str1 = sc.nextLine();
            dos.writeUTF(str1);

            str2 = dis.readUTF();
            System.out.println("Server : " + str2);
        }
        //close the connections
        socket.close();
        dos.close();
        dis.close();
        System.out.println("Disconnected");
    }
}