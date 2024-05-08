package Bit_Stuffing_Destuffing;
import java.util.Scanner;

/**
 *
 * @author NasifAzam
 */
public class Bit_Stuffing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Bits:-");
        String d1 = sc.nextLine();
        String remaining = new String();
        String output = new String();
        int counter = 0;
        for (int i = 0; i < d1.length(); i++) {

            if (d1.charAt(i) != '1' && d1.charAt(i) != '0') {
                System.out.println("Enter valid Binary values");
                return;
            }
            if (d1.charAt(i) == '1') {
                counter++;
                remaining = remaining + d1.charAt(i);
            } else {
                remaining = remaining + d1.charAt(i);
                counter = 0;
            }
            if (counter == 5) {
                remaining = remaining + '0';
                counter = 0;
            }
        }
        System.out.println("Flag: 1111");
        String new1 = "|1111| " + remaining + " |1111|";
        System.out.println("Stuffed data at intermediate site is:");
        for (int k = 0; k <= (28 + d1.length()); k++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println(" " + new1);
        for (int k = 0; k <= (28 + d1.length()); k++) {
            System.out.print("-");
        }
    }
}
