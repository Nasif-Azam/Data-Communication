package com.mycompany.ipv4_two_users;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ipv4_user_2 {
    public static void main(String[] args) {
        // This is the receiving end of the binary addresses, you can process them as needed.
    }

    public static void receiveBinaryAddresses(int[] ipOctets, int[] subnetOctets, int[] networkAddress, int[] broadcastAddress, int[] gatewayAddress) {
        System.out.println("\n\n==========User-2 Side Starts==========");
        // Binary Addresses
        System.out.println("********User-2 Binary Addresses********");
        System.out.println("Received Binary IP Address: ");
        for (int octet : ipOctets) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");
        }

        System.out.println("\nReceived Binary Subnet Mask: ");
        for (int octet : subnetOctets) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");
        }
        
        System.out.println("\nReceived Binary Network Address: ");
        for (int octet : networkAddress) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");
        }

        System.out.println("\nReceived Binary Broadcast Address: ");
        for (int octet : broadcastAddress) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");
        }
        
        System.out.println("\nReceived Binary Gateway Address: ");
        for (int octet : gatewayAddress) {
            String binaryOctet = Integer.toBinaryString(octet);
            System.out.print(String.format("%8s", binaryOctet).replace(' ', '0'));
            System.out.print(" | ");
        }        
        System.out.println();
        // Decimal Addresses
        System.out.print("\n********User-2 Decimal Addresses********");
        String binaryIP = Arrays.stream(ipOctets).mapToObj(Integer::toBinaryString).collect(Collectors.joining("."));
        convertBinaryToDecimal(binaryIP, "Decimal IP Address: ");

        String binarySubnetMask = Arrays.stream(subnetOctets).mapToObj(Integer::toBinaryString).collect(Collectors.joining("."));
        convertBinaryToDecimal(binarySubnetMask, "Decimal Subnet Mask: ");
        
        String binaryNetworkAddress = Arrays.stream(gatewayAddress).mapToObj(Integer::toBinaryString).collect(Collectors.joining("."));
        convertBinaryToDecimal(binaryNetworkAddress, "Decimal Network Address: ");        

        String binaryBroadcastAddress = Arrays.stream(broadcastAddress).mapToObj(Integer::toBinaryString).collect(Collectors.joining("."));
        convertBinaryToDecimal(binaryBroadcastAddress, "Decimal Broadcast Address: ");        
        
        String binaryGatewayAddress = Arrays.stream(gatewayAddress).mapToObj(Integer::toBinaryString).collect(Collectors.joining("."));
        convertBinaryToDecimal(binaryGatewayAddress, "Decimal Gateway Address: ");
    }

    public static void convertBinaryToDecimal(String binary, String msg) {
        // Split the binary string into 8-bit segments
        String[] binaryOctets = binary.split("\\.");
        System.out.println("\n"+msg);
        for (String binaryOctet : binaryOctets) {
            int decimalOctet = Integer.parseInt(binaryOctet, 2);
            System.out.print(decimalOctet);
            System.out.print(".");
        }
    }
}
