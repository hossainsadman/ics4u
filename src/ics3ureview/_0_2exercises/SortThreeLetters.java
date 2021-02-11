package ics3ureview._0_2exercises;

import java.util.Scanner;

public class SortThreeLetters {
    public static void main(String[] args) throws Exception {
        // 1. Write a program that prompts for three lower case letters
        //    separately (String). Assuming all inputs are valid, sort and
        //    output the three letters in alphabetical order, otherwise, output
        //    an error message. No arrays for now.

        Scanner s = new Scanner(System.in);

        System.out.println("Enter 3 letters:");
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

        System.out.println(first + " " + second + " " + third);
    }
}
