package com.mycompany.hammingcode;
import java.lang.Math;
import java.util.Scanner;
/**
 *
 * @author NasifAzam
 */

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

    public static void solve(int[] input, int n) {
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
        for (i = 0; i < c_l; i++) {
            System.out.print(code[i] + " ");
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
        solve(input, N);
    }
}