/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nasif.get_post_method;

/**
 *
 * @author Nasif Azam
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author cse
 */
public class get_post_method {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL myUrl = new URL("https://jsonplaceholder.typicode.com/posts/");
        HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        
        OutputStream out = conn.getOutputStream();
        String postedString = "Hi!!! We have posted something!!! Yay!!!";
        out.write(postedString.getBytes());

        int responseCode = conn.getResponseCode();
        System.out.print("Value of http created is: "+HttpURLConnection.HTTP_CREATED+"\n");
        if (responseCode == HttpURLConnection.HTTP_CREATED)
        {
            System.out.print("This is the response Code: "+responseCode+"\n");
            System.out.print("This is the response Message from server: "+conn.getResponseMessage()+"\n");

        }
        else System.out.print("GO HOME EVERYBODY 🙁 ");


        InputStreamReader in = new InputStreamReader(conn.getInputStream());

        StringBuffer fromServer;
        try (BufferedReader buffer = new BufferedReader(in)) {
            fromServer = new StringBuffer();
            String eachLine;
            eachLine = null;
            while((eachLine=buffer.readLine()) != null)
            {
                fromServer.append(eachLine);
                fromServer.append(System.lineSeparator());
            }
        }
        
        System.out.print("Here is our posted content :\n"+fromServer);
    }
    
}
