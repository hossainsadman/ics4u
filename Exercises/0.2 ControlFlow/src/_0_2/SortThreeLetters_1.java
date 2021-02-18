package _0_2;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class SortThreeLetters_1 {

    public static void main(String[] args) {
        // 1. Write a program that prompts for three lower case letters
        //    separately (String). Assuming all inputs are valid, sort and
        //    output the three letters in alphabetical order, otherwise, output
        //    an error message. No arrays for now.

        Scanner s = new Scanner(System.in);

        System.out.println("Enter a single letter followed by 'Enter':");
        char char1 = s.nextLine().charAt(0);
        char char2 = s.nextLine().charAt(0);
        char char3 = s.nextLine().charAt(0);

        char first = char1;
        char second = char2;
        char third = char3;

        if (second < first) {
            first = char2;
            second = char1;
        }

        if (third < second) {
            third = second;
            second = char3;
            if (second < first) {
                char tmp = second;
                second = first;
                first = tmp;
            }
        }

        System.out.println("Your letters in alphabetical order: ");
        System.out.print(first + " " + second + " " + third);

        s.close();
    }
    
}
