package exercises1_1_arrays;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class Arrays_3 {
    public static void main(String[] args) {
        // 3. Write a program to complete the following tasks. Could write some
        //    methods.

        // a) Get an integer n from the user and initialize a double array of
        // length n. Ask the user to enter n numbers, and fill the array with
        // them in order.
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = Integer.parseInt(s.nextLine());
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i+1)+": ");
            array[i] = Double.parseDouble(s.nextLine());
        }

        // b) Calculate and print the sum and average of all the elements in
        // the array.
        int sum = 0;
        for (double num : array) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + sum/array.length);

        // c) Print all the elements of the array “nicely”, without using the
        // Arrays.toString() method. If the array was [3, 5, -4, 1], the print
        // out should be exactly as: 3, 5, -4, 1
        // No brackets or braces, no extra commas at the end.
        for (int i = 0; i < array.length-1; i++) {
            if ((int) array[i] == array[i]) {
                System.out.print((int) array[i] + ", ");
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        if ((int) array[array.length-1] == array[array.length-1]) {
            System.out.print((int) array[array.length-1]);
        } else {
            System.out.print(array[array.length-1]);
        }
        System.out.println();

        // d) Identify and print the smallest value of the array.
        // e) Identify and print the index of the smallest value (first
        // occurence, if more than 1) of the array.
        double smallest = 999999;
        int smallest_index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                smallest_index = i;
            }
        }
        System.out.println(smallest);
        System.out.println(smallest_index);

        s.close();
    }
}
