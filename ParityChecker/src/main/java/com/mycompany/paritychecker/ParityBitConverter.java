package com.mycompany.paritychecker;
import java.util.Scanner;
/**
 *
 * @author NasifAzam
 */
public class ParityBitConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("ID: ");
        String id = scanner.nextLine();

        String combinedData = name + " " + id;
        String binaryData = convertToBinary(combinedData);

        System.out.println("Converted: \n" + binaryData);
        int countOfOnes = 0;
        for (int i = 0; i < binaryData.length(); i++) {
            if (binaryData.charAt(i) == '1') {
                countOfOnes++;
            }
        }
        System.out.println("MOD Data:");
        if (countOfOnes % 2 == 0) {
            System.out.println("As per even parity: \n" + binaryData + '0');
            System.out.println("As per odd parity: \n" + binaryData + '1');
        } else {
            System.out.println("As per even parity: \n" + binaryData + '1');
            System.out.println("As per odd parity: \n" + binaryData + '0');
        }
        System.out.println("Total Lenght of Converted Data: " + binaryData.length());
        System.out.println("Total Number of 1s : " + countOfOnes);        
        System.out.println("Total Number of 0s : " + (binaryData.length() - countOfOnes));        
    }

    // Converts a string to binary based on ASCII values
    public static String convertToBinary(String input) {
        StringBuilder binaryData = new StringBuilder();
        for (char c : input.toCharArray()) {
            String binary = Integer.toBinaryString(c);
            while (binary.length() < 8) {
                binary = "0" + binary;
            }
            binaryData.append(binary);
        }
        return binaryData.toString();
    }
}
