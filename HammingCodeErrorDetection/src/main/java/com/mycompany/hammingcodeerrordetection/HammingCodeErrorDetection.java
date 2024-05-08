package com.mycompany.hammingcodeerrordetection;

/**
 *
 * @author NasifAzam
 */
import java.util.Scanner;

public class HammingCodeErrorDetection {

    public static int hamCalc(int position, int[] code) {
        int count = 0;
        int i = position - 1;
        int cl = code.length;

        while (i < cl) {
            for (int j = i; j < i + position && j < cl; j++) {
                if (code[j] == 1) {
                    count++;
                }
            }
            i = i + 2 * position;
        }

        if (count % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void encode(int[] input) {
        int n = input.length;
        int p_n = 0;
        int i = 0;

        while (n > Math.pow(2, i) - (i + 1)) {
            p_n++;
            i++;
        }
        int c_l = p_n + n;
        int j = 0;
        int k = 0;
        int[] code = new int[c_l];

        for (i = 0; i < c_l; i++) {
            if (i == Math.pow(2, k) - 1) {
                code[i] = 0;
                k++;
            } else {
                code[i] = input[j];
                j++;
            }
        }

        for (i = 0; i < p_n; i++) {
            int position = (int) Math.pow(2, i);
            int value = hamCalc(position, code);
            code[position - 1] = value;
        }

        System.out.print("Encoded Hamming Code: ");
        for (i = 0; i < c_l; i++) {
            System.out.print(code[i] + " ");
        }
        System.out.println();
    }

    public static void decode(int[] receivedCode) {
        int p_n = 0;
        int i = 0;

        while (receivedCode.length > Math.pow(2, i) - (i + 1)) {
            p_n++;
            i++;
        }

        int errorPosition = 0;
        for (i = 0; i < p_n; i++) {
            int position = (int) Math.pow(2, i);
            int value = hamCalc(position, receivedCode);
            if (value != 0) {
                errorPosition += position;
            }
        }

        if (errorPosition != 0) {
            System.out.println("Error detected at position: " + errorPosition);
        } else {
            System.out.println("No error detected.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Binary Data: ");
        String binary = sc.nextLine();
        int[] input = new int[binary.length()];

        System.out.print("Binary Data: ");
        for (int i = 0; i < binary.length(); i++) {
            input[i] = Integer.parseInt(String.valueOf(binary.charAt(i)));
            System.out.print(input[i]);
        }
        int N = binary.length();
        System.out.println("\nBinary Data Length: " + N);

        encode(input);

        System.out.print("Enter Received Hamming Code: ");
        String receivedBinary = sc.nextLine();
        int[] receivedCode = new int[receivedBinary.length()];

        System.out.print("Received Hamming Code: ");
        for (int i = 0; i < receivedBinary.length(); i++) {
            receivedCode[i] = Integer.parseInt(String.valueOf(receivedBinary.charAt(i)));
            System.out.print(receivedCode[i]);
        }

        decode(receivedCode);
    }
}
