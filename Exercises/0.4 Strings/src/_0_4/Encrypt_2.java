package _0_4;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class Encrypt_2 {

    // 2. Write a method which encrypts a string and returns the ciphertext.
    //    The encryption specifications are as follows:
    // - first and last character of the string are swapped
    // - remaining characters of the string are shifted +2 in the ASCII table
    //   (needs to works for all printable characters)
    // - spaces are untouched
    // - careful with strings with less than 3 characters
    private static String encrypt(String str) {
        String encrypted = "";
        encrypted += str.charAt(str.length()-1);
        for (int i = 1; i < str.length()-1; i++) {
            int letter = (int) str.charAt(i);
            if (letter == 32) {
                encrypted += (char) letter;
            } else {
                encrypted += (char) (letter + 2);
            }
        }
        encrypted += str.charAt(0);
        return encrypted;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Write a main method with a simple interface as shown.
        // SAMPLE OUTPUT:
        // Enter a message to be encrypted: Hello World!
        // The ciphertext is: !gnnq YqtnfH
        System.out.print("Enter a message to be encrypted: ");
        String encrypted = encrypt(s.nextLine());
        System.out.println("The ciphertext is: " + encrypted);

        s.close();
    }
}
