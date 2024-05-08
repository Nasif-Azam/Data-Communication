/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nasif.get_post_method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class POST_method {
    public static void main(String[] args) throws IOException{ 
          URL url = new URL("https://jsonplaceholder.typicode.com/posts");
          HttpURLConnection connection = (HttpURLConnection)url.openConnection();
          connection.setRequestMethod("POST");
          connection.setRequestProperty("User-agent", "Chrome");          
           connection.setDoOutput(true);
           OutputStream out = connection.getOutputStream();
           String postedString = "Posted 1st blog!!";
           out.write(postedString.getBytes());           
          
          int codeResponse = connection.getResponseCode();
          String codeMessage = connection.getResponseMessage();          
          if(codeResponse == connection.HTTP_CREATED){
              System.out.println("Response Code : " + codeResponse + "\nResponse Message : " + codeMessage);
          }
          else{
               System.out.print("GO HOME EVERYBODY :( ");
          }
           BufferedReader read = new BufferedReader(new InputStreamReader(connection.getInputStream()));
           StringBuffer fromServer = new StringBuffer();
           String store=null;
           while((store=read.readLine()) != null){
               fromServer.append(store);
               fromServer.append(System.lineSeparator());
            }
            read.close();
            System.out.print("Here is our posted content :\n"+fromServer);
    }
}
