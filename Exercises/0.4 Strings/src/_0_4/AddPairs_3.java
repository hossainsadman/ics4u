package _0_4;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class AddPairs_3 {

    // 3. Write a program that separates a positive integer entered by the user
    //    (as String) into two digit integers (if there are an odd number of
    //    characters, the last number is only one digit), then output the sum of
    //    the set of numbers.
    private static int addPairs(String str) {
        int sum = 0;
        for (int i = 0; i < str.length()-1; i += 2) {
            sum += Integer.parseInt(str.substring(i, i+2));
        }
        if (str.length() % 2 != 0) {
            sum += Integer.parseInt(str.substring(str.length()-1) );
        }
        return sum;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // SAMPLE OUTPUT
        // Input: 239403854
        // Output: 209
        // EXPLANATION FOR OUTPUT -> 209 = 23+94+3+85+4

        System.out.print("Input: ");
        System.out.println("Output: " + addPairs(s.nextLine()));
    }
}
