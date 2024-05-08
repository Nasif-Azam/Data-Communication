/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nasif.get_post_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Nasif Azam
 */
public class GET {
    public static void main(String[] args) throws IOException{
        URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        int codeResponse =  connection.getResponseCode();
        System.out.println("Code: " + connection.getResponseCode() + " MSG: "+connection.getResponseMessage());
        
        if( connection.getResponseCode() == connection.HTTP_OK){
            BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer fromServer = new StringBuffer();
            String store = null;
            while ((store = read.readLine()) != null) {
                fromServer.append(store);
              
            }
            read.close();
            System.out.println("MSG from server: " + fromServer.toString());
            
        }
    }
}
