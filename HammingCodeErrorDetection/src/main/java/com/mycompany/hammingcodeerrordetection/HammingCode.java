package com.mycompany.hammingcodeerrordetection;

/**
 *
 * @author NasifAzam
 */
import java.util.Scanner;
public class HammingCode {
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
        int i, p_n = 0, c_l, j, k;
        i = 0;

        while (n > (int) Math.pow(2, i) - (i + 1)) {
            p_n++;
            i++;
        }
        c_l = p_n + n;
        j = k = 0;
        int[] code = new int[c_l];

        for (i = 0; i < c_l; i++) {
            if (i == ((int) Math.pow(2, k) - 1)) {
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

        System.out.print("Hamming Code: ");
        int hamLen = 0;
        for (i = 0; i < c_l; i++) {
            System.out.print(code[i]);
            hamLen++;
        }
        System.out.println();

        int numberOfParityBits = getNumberOfParityBits(c_l);
        System.out.println("Number of Parity Bits: " + numberOfParityBits);
        System.out.println("Hammming Code Length: " + hamLen);
    }

    public static int getNumberOfParityBits(int c_l) {
        int i = 0;
        while (c_l > (int) Math.pow(2, i) - (i + 1)) {
            i++;
        }
        return i;
    }

    public static String decode(int[] received) {
        int p_n = getNumberOfParityBits(received.length);
        int[] parityBits = new int[p_n];
        int c = 0;

        for (int i = 0; i < p_n; i++) {
            int position = (int) Math.pow(2, i);
            int value = hamCalc(position, received);
            parityBits[i] = value;
            if (value == 1) {
                c += position;
            }
        }

        if (c != 0) {
            received[c - 1] = (received[c - 1] == 0) ? 1 : 0;
            System.out.println("Error Status: Yes");
            return "Error Detected at position: " + c;
        } else {
            System.out.println("Error Status: No");
            return "No Errors Detected.";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Binary Data: ");
        String binary = sc.nextLine();
        int[] input = new int[binary.length()];

        for (int i = 0; i < binary.length(); i++) {
            input[i] = Integer.parseInt(String.valueOf(binary.charAt(i)));
        }
        int N = binary.length();
        System.out.println("Binary Data Length: " + N);
        encode(input);
        System.out.print("Enter Received Hamming Code: ");
        String receivedBinary = sc.nextLine();
        int[] receivedData = new int[receivedBinary.length()];
        for (int i = 0; i < receivedBinary.length(); i++) {
            receivedData[i] = Integer.parseInt(String.valueOf(receivedBinary.charAt(i)));
        }
        System.out.println( decode(receivedData));
    }
}
