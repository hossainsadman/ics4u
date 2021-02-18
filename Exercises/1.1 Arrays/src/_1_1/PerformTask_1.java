package _1_1;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class PerformTask_1 {

    public static void main(String[] args) {
        // 1. Write a program to perform each task (in separate loops):
        // a) Ask user to enter an integer n, then declare an array of integers
        // of size n
        // b) Initialize all elements of the array to 1
        // c) Ask user to enter n integers, and fill the array with these
        // integers in order
        // d) Switch the first and last values of the array
        // e) Change any negative values to positive values (of the same
        // magnitude), but don't touch the positive ones
        // f) Print a line of “*”, one for each number in the array. The number
        // of stars equals the value of each cell. If the array was [1, 4, 2],
        // you should print:
        // *
        // ****
        // **
        // g) Print all the even numbers in the array

        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = Integer.parseInt(s.nextLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = 1;
        }

        System.out.println("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ": ");
            array[i] = Integer.parseInt(s.nextLine());
        }

        int tmp = array[0];
        array[0] = array[n-1];
        array[0] = tmp;

        for (int i = 0; i < n; i++) {
            if (array[i] < 0) {
                array[i] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < array[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) {
                System.out.println(array[i]);
            }
        }

        s.close();
    }

}
