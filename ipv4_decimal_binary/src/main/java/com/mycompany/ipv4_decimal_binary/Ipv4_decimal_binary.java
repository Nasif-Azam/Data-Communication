package com.mycompany.ipv4_decimal_binary;
import java.util.Scanner;
/**
 *
 * @author NasifAzam
 */
public class Ipv4_decimal_binary {
  public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("IP Address: ");
        String ip = in.nextLine();
        
        System.out.println("Network Address: ");
        String na = in.nextLine();
        
        System.out.println("Subnet Mask: ");
        String sm = in.nextLine();
        
        System.out.println("Broadcast Address: ");
        String ba = in.nextLine();
        
        //split ip address by dot(.)  
        String[] ipArray = ip.split("\\.");
        String[] naArray = na.split("\\.");
        String[] smArray = sm.split("\\.");
        String[] baArray = ba.split("\\.");
        
        System.out.println("\nIP: ");
        for (String string : ipArray) {
            //finds the primitive data type of a certain string  
            int octet = Integer.parseInt(string);
            //converts integer into binary string  
            String binaryOctet = Integer.toBinaryString(octet);
            //prints the corresponding binary string of the ip address  
            System.out.print(binaryOctet);       
            System.out.print(".");
        }
        
        System.out.println("\nNA: ");
        for (String string : naArray) {
            //finds the primitive data type of a certain string  
            int octet = Integer.parseInt(string);
            //converts integer into binary string  
            String binaryOctet = Integer.toBinaryString(octet);
            //prints the corresponding binary string of the ip address  
            System.out.print(binaryOctet);
            System.out.print(".");
        }
        System.out.println("\nSM: ");        
        for (String string : smArray) {
            //finds the primitive data type of a certain string  
            int octet = Integer.parseInt(string);
            //converts integer into binary string  
            String binaryOctet = Integer.toBinaryString(octet);
            //prints the corresponding binary string of the ip address  
            System.out.print(binaryOctet);
            System.out.print(".");
        }
        System.out.println("\nBA: ");
        for (String string : baArray) {
            //finds the primitive data type of a certain string  
            int octet = Integer.parseInt(string);
            //converts integer into binary string  
            String binaryOctet = Integer.toBinaryString(octet);
            //prints the corresponding binary string of the ip address  
            System.out.print(binaryOctet);
            System.out.print(".");
        }
    }
}
