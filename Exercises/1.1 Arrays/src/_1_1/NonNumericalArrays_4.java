package _1_1;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class NonNumericalArrays_4 {

    // 3. Write a program to complete the following tasks. Could write some
    //    methods.

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter an integer: ");
        int n = Integer.parseInt(s.nextLine());
        System.out.println("Enter " + n + " integers separated by 'Enter': ");
        double[] array = getArray(n);
        sumAndAvg(array);
        printArray(array);
        System.out.println("Smallest: " + smallest(array));
        System.out.println("Index of smallest: " + indexOfSmallest(array));
    }

    // a) Get an integer n from the user and initialize a double array of
    // length n. Ask the user to enter n numbers, and fill the array with them
    // in order.
    private static double[] getArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(s.nextLine());
        }
        return array;
    }

    // b) Calculate and print the sum and average of all the elements in the
    // array.
    private static void sumAndAvg(double[] array) {
        int sum = 0;
        for (double d : array) {
            sum += d;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + sum/array.length);
    }

    // c) Print all the elements of the array “nicely”, without using the
    // Arrays.toString() method. If the array was [3, 5, -4, 1], the print out
    // should be exactly as: 3, 5, -4, 1 No brackets or braces, no extra commas
    // at the end.
    private static void printArray(double[] array) {
        for (int i = 0; i < array.length-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length-1]);
        System.out.println();
    }

    // d) Identify and print the smallest value of the array.
    private static double smallest(double[] array) {
        double smallest = 9999999;
        for (double d : array) {
            if (d < smallest) {
                smallest = d;
            }
        }
        return smallest;
    }

    // e) Identify and print the index of the smallest value (first occurence,
    // if more than 1) of the array.
    private static int indexOfSmallest(double[] array) {
        double smallest = smallest(array);
        for (int i = 0; i < array.length; i++) {
            if (smallest == array[i]) {
                return i;
            }
        }
        return -1;
    }
}