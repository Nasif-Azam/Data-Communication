package Bit_Stuffing_Destuffing;
import java.util.Scanner;

/**
 * @author NasifAzam
 */
public class Bit_Stuffing_Destuffing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Message : ");
        String msg = sc.nextLine();
        String stuffed_msg = new String();
        String destuffed_msg = new String();
        int counter = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (msg.charAt(i) != '1' && msg.charAt(i) != '0') {
                System.out.println("Enter Valid Binary Values!!");
                return;
            }
            if (msg.charAt(i) == '1') {
                counter++;
                stuffed_msg = stuffed_msg + msg.charAt(i);
            } else {
                stuffed_msg = stuffed_msg + msg.charAt(i);
                counter = 0;
            }
            if (counter == 5) {
                stuffed_msg = stuffed_msg + '0';
                counter = 0;
            }
        }
        System.out.print("Enter the Flag : ");
        String flag = sc.nextLine();
//        System.out.println("Flag--> 01111110");
//        String new1 = "|01111110 | " + stuffed_msg + " | 01111110|";
         String new1 = "|" + flag + "| " + stuffed_msg + " |" + flag + "|";
        System.out.println("Stuffed BIT Looks Like : " + new1);
//        for (int k = 0; k <= (28 + msg.length()); k++) {
//            System.out.print("-");
//        }
//        System.out.println();
        counter = 0;
        for (int i = 0; i < stuffed_msg.length(); i++) {
            if (stuffed_msg.charAt(i) == '1') {
                counter++;
                destuffed_msg = destuffed_msg + stuffed_msg.charAt(i);
            } else {
                destuffed_msg = destuffed_msg + stuffed_msg.charAt(i);
                counter = 0;
            }
            if (counter == 5) {
                if ((i + 2) != stuffed_msg.length()) {
                    destuffed_msg = destuffed_msg + stuffed_msg.charAt(i + 2);
                } else {
                    destuffed_msg = destuffed_msg + '1';
                }
                i = i + 2;
                counter = 1;
            }
        }
        System.out.println("Destuffed BIT : " + destuffed_msg);
    }
}
