package com.nasif.socketprogramming;
/* @author Nasif Azam */

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5243); //argumrnent where server sever is local host and port 5243
        System.out.println("Connceted to the sever");   // connection check 

        DataOutputStream ds = new DataOutputStream(s.getOutputStream()); //for write the server 
        
        // for both side code       
        
        Scanner sc = new Scanner(System.in); // to take user input message 

        // to set a condition we used loop 
        String str = "";
        while (!str.equals("Bye")) {
            str = sc.nextLine();
            ds.writeUTF(str); 
        }        
        // close socket and datastream/ writing server 
        ds.close();
        s.close();   

    }
}
