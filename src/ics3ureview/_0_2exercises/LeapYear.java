package ics3ureview._0_2exercises;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        // 3. A leap year is one with 366 days instead of 365. Write a program
        //    to determine whether a particular year is a leap year. Recall that
        //    a year is a leap year if it is divisible by 4. But if the year is
        //    divisible by 100, it is only a leap year if it is also divisible
        //    by 400 (why?!). Ask the user for a year and print the result.

        Scanner s = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = Integer.parseInt(s.nextLine());

        if (year % 4 == 0 && (year % 100 != 0 || (year % 100 == 0 && year % 400 == 0))) {
            System.out.println("The year " + year + " is a leap year.");
        } else {
            System.out.println("The year " + year + " is not a leap year.");
        }
    }
}
