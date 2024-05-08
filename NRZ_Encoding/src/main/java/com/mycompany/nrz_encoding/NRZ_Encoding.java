/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nrz_encoding;

/**
 *
 * @author NasifAzam
 */
public class NRZ_Encoding {

    public static void nrzI(String binaryInput) {
        char currentBit = '0';
        System.out.print("NRZ-I Signal (High/Low): ");
        for (int i = 0; i < binaryInput.length(); i++) {
            if (binaryInput.charAt(i) == '1') {
                currentBit = (currentBit == '0') ? '1' : '0';
            }
            System.out.print((currentBit == '1') ? 'H' : 'L' + " ");
        }
        System.out.println();
    }

    public static void nrzL(String binaryInput) {
        System.out.print("NRZ-L Signal (High/Low): ");
        for (int i = 0; i < binaryInput.length(); i++) {
            System.out.print((binaryInput.charAt(i) == '1') ? 'H' : 'L' + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String binaryInput = "10010011011";
        nrzI(binaryInput);
        nrzL(binaryInput);
    }
}

