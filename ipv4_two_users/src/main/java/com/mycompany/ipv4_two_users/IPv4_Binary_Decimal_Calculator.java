package com.mycompany.ipv4_two_users;
import java.util.Scanner;

public class IPv4_Binary_Decimal_Calculator  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an IPv4 address with given notation (192.168.10.10/24): ");
        String input = scanner.nextLine();

        String[] parts = input.split("/");
        if (parts.length != 2) {
            System.out.println("Invalid input format. Please use the format x.x.x.x/y.");
            return;
        }

        String ip = parts[0];
        int prefixLength = Integer.parseInt(parts[1]);

        if (prefixLength < 0 || prefixLength > 32) {
            System.out.println("Invalid prefix length. It should be between 0 and 32.");
            return;
        }

        int[] ipOctets = parseIPv4(ip);
        String subnetMask = calculateSubnetMask(prefixLength);
        int[] networkAddress = calculateNetworkAddress(ipOctets, subnetMask);
        int[] broadcastAddress = calculateBroadcastAddress(ipOctets, subnetMask);
        char ipClass = getIPClass(ipOctets[0]);
        int hostCount = calculateHostCount(prefixLength);

        // Display the results
        System.out.println("IPv4: " + toBinaryString(ipOctets));
        System.out.println("SM: " + subnetMask);
        System.out.println("NA: " + toBinaryString(networkAddress));
        System.out.println("BA: " + toBinaryString(broadcastAddress));
        System.out.println("Class: " + ipClass);
        System.out.println("Number of hosts: " + (hostCount - 2)); // Subtract 2 for network and broadcast addresses

        scanner.close();
    }

    private static int[] parseIPv4(String ip) {
        String[] octets = ip.split("\\.");
        int[] ipOctets = new int[4];

        for (int i = 0; i < 4; i++) {
            ipOctets[i] = Integer.parseInt(octets[i]);
        }

        return ipOctets;
    }

    private static String toBinaryString(int[] octets) {
        StringBuilder binary = new StringBuilder();
        for (int octet : octets) {
            String binaryOctet = String.format("%8s", Integer.toBinaryString(octet)).replace(' ', '0');
            binary.append(binaryOctet).append(".");
        }
        return binary.substring(0, binary.length() - 1); // Remove the trailing "."
    }

    private static char getIPClass(int firstOctet) {
        if (firstOctet >= 1 && firstOctet <= 126) {
            return 'A';
        } else if (firstOctet >= 128 && firstOctet <= 191) {
            return 'B';
        } else if (firstOctet >= 192 && firstOctet <= 223) {
            return 'C';
        } else if (firstOctet >= 224 && firstOctet <= 239) {
            return 'D';
        } else if (firstOctet >= 240 && firstOctet <= 255) {
            return 'E';
        }
        return 'N'; // Invalid
    }

    private static String calculateSubnetMask(int prefixLength) {
        int[] maskOctets = new int[4];
        for (int i = 0; i < 4; i++) {
            int maskValue = 0;
            if (prefixLength >= 8) {
                maskValue = 255;
                prefixLength -= 8;
            } else {
                for (int j = 7; j >= 8 - prefixLength; j--) {
                    maskValue |= (1 << j);
                }
            }
            maskOctets[i] = maskValue;
        }
        return toBinaryString(maskOctets);
    }

    private static int[] calculateNetworkAddress(int[] ipOctets, String subnetMask) {
        int[] subnetOctets = new int[4];
        String[] maskOctets = subnetMask.split("\\.");

        for (int i = 0; i < 4; i++) {
            subnetOctets[i] = ipOctets[i] & Integer.parseInt(maskOctets[i], 2);
        }

        return subnetOctets;
    }

    private static int[] calculateBroadcastAddress(int[] ipOctets, String subnetMask) {
        int[] broadcastOctets = new int[4];
        String[] maskOctets = subnetMask.split("\\.");

        for (int i = 0; i < 4; i++) {
            broadcastOctets[i] = ipOctets[i] | (~Integer.parseInt(maskOctets[i], 2) & 0xFF);
        }

        return broadcastOctets;
    }

    private static int calculateHostCount(int prefixLength) {
        return (int) Math.pow(2, 32 - prefixLength);
    }
}
