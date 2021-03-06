package _1_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class PrintArray_1 {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // 1. Write a program that asks the user for the first dimension of a 2-D
        //    integer array, then declare and initialize it. Ask the user to fill
        //    that array with arrays of arbitrary length, given by the user. Then
        //    print the array for the user using deepToString().

        // SAMPLE OUTPUT
        // Enter the length of the array: 3

        // Array 1:
        // Enter the length of array 1: 3
        // Enter 3 integer(s):
        // 0
        // 1
        // 5

        // Array 2:
        // Enter the length of array 2: 1
        // Enter 1 integer(s):
        // 999

        // Array 3:
        // Enter the length of array 3: 2
        // Enter 2 integer(s):
        // -2
        // 7

        // The array:
        // [[0, 1, 5], [999], [-2, 7]]

        System.out.print("Enter the length of the array: ");
        int n = Integer.parseInt(s.nextLine());

        int[][] array = new int[n][];

        for (int i = 0; i < n; i++) {
            System.out.println("\nArray " + (i+1) + ": ");

            System.out.print("Enter the length of array " + (i+1) + ": ");
            int arrayLength = Integer.parseInt(s.nextLine());

            System.out.printf("Enter %d integer(s): \n", arrayLength);
            int[] subarray = new int[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                subarray[j] = Integer.parseInt(s.nextLine());
            }
            array[i] = subarray;
        }

        System.out.println("\nThe array:");
        System.out.println(Arrays.deepToString(array));

        s.close();
    }

}
