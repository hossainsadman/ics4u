package _0_4;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class MakeUppercase_1 {

    // 1. Write a method, similar to the built-in toUpperCase() method, which
    //    changes a string to its uppercase equivalent and returns it. Code a
    //    main method with a simple user interface as shown. Note: only lower
    //    case letters should be changed.
    // SAMPLE OUTPUT:
    // Enter a string: Abracadabra!
    // Uppercase Equivalent:  ABRACADABRA!

    // ASCII VALUES:
    // A to Z: 97 to 122
    // a to z: 65 to 90, or (97-32) to (90-32)
    // if ascii value of a character is in the range 65-90, add 32 to its ascii
    // value (to get the uppercase letter) and replace the lowercase letter
    private static String toUpperCase(String str) {
        String new_str = "";
        for (int i = 0; i < str.length(); i++) {
            int letter = (int) str.charAt(i);
            if (97 <= letter && letter <= 122) {
                letter -= 32;
            }
            new_str += (char)letter;
        }
        return new_str;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = s.nextLine();
        System.out.println("Uppercase Equivalent: " + toUpperCase(str));

        s.close();
    }

}
