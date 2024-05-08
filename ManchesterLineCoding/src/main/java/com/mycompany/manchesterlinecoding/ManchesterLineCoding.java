package com.mycompany.manchesterlinecoding;

/**
 *
 * @author NasifAzam
 */
public class ManchesterLineCoding {

    public static void main(String[] args) {
        String input = "01010011";
        System.out.println("Inputed Bit: " + input);
        String[] encodedBit = new String[input.length() + 2];
        encodedBit[0] = "M";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                encodedBit[i + 1] = "HL";
            }
            if (input.charAt(i) == '1') {
                encodedBit[i + 1] = "LH";
            }
        }
        encodedBit[encodedBit.length - 1] = "M";
        System.out.print("Encoded Bit: ");
        for (String bit : encodedBit) {
            System.out.print(" " + bit);
        }
    }
}
