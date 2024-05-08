package com.mycompany.ipv4_two_users;
import java.util.Scanner;

public class Ipv4_user_1 {
    public static void main(String[] args) {
//        String ip = "192.168.10.1";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The IP Address: ");
        String ip = sc.nextLine();
        
        String subnet_mask = "255.255.255.0";        
        // Split IP address and subnet mask by dot (.)
        String[] ipArray = ip.split("\\.");
        String[] subnetMaskArray = subnet_mask.split("\\.");

        int[] ipOctets = new int[4];
        int[] subnetOctets = new int[4];

        for (int i = 0; i < 4; i++) {
            ipOctets[i] = Integer.parseInt(ipArray[i]);
            subnetOctets[i] = Integer.parseInt(subnetMaskArray[i]);
        }

        int[] networkAddress = new int[4];
        int[] broadcastAddress = new int[4];
        int[] gatewayAddress = new int[4];

        // Calculate network, broadcast, and gateway addresses
        for (int i = 0; i < 4; i++) {
            networkAddress[i] = ipOctets[i] & subnetOctets[i];
            broadcastAddress[i] = networkAddress[i] | (~subnetOctets[i] & 0xFF);
            gatewayAddress[i] = networkAddress[i];
        }
        
        System.out.println("==========User-1 Side Starts==========");
        // Decimal Addresses
         System.out.println("********User-1 Decimal Addresses********");
        System.out.println("Decimal IP Address: \n" + ip);
        System.out.println("Decimal Subnet Mask: \n" + subnet_mask);
        System.out.println("Decimal Network Address: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(networkAddress[i]);
            System.out.print(".");
        }
        System.out.println("\nDecimal Broadcast Address: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(broadcastAddress[i]);
            System.out.print(".");
        }
        System.out.println("\nDecimal Gateway Address: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(gatewayAddress[i]);
            System.out.print(".");
        }
        // Binary Addresses     
        System.out.println("\n\n********User-1 Binary Addresses********");
        System.out.println("Binary IP Address: ");
        for (int octet : ipOctets) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");                    
        }       
        
        System.out.println("\nBinary Subnet Mask Address: ");
        for (int octet : subnetOctets) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");                    
        }      
        
        System.out.println("\nBinary Network Address: ");
        for (int octet : networkAddress) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");     
        }

        System.out.println("\nBinary Broadcast Address: ");
        for (int octet : broadcastAddress) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");     
        }

        System.out.println("\nBinary Gateway Address: ");
        for (int octet : gatewayAddress) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");     
        }

        // Now, send the binary addresses to Ipv4_user_2.java
        Ipv4_user_2.receiveBinaryAddresses(ipOctets, subnetOctets, networkAddress, broadcastAddress, gatewayAddress);
    }
}
