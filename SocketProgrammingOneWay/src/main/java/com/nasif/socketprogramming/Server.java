package com.nasif.socketprogramming;
/* @author Nasif Azam */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(5243); // for server site we need to use port number only
        System.out.println("Port connection");
        
        System.out.println("Waiting for client");  // waiting is call bind in networking 
        
        
        Socket s = ss.accept(); // client socket because is trying to write
        System.out.println("Client request accepted");
        
        //for read client request where clinet is trying to request to the server 
        DataInputStream ds = new DataInputStream(s.getInputStream());
        
        //to read the message 
        String str = "";
        while(!str.equals("Bye")){          
            str = ds.readUTF();
            System.out.println("Client : "+str);        
        }        
        //close the connection     || for have to start from 
        ds.close();
        s.close();
        ss.close();
    }
 
}
