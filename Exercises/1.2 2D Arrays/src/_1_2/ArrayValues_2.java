package _1_2;

import java.util.Arrays;

/**
 *
 * @author Sadman
 */
public class ArrayValues_2 {

    // 2. PROGRAM REQUIREMENTS
    // a) method arraySum() to compute and return the sum of the elements of an
    // int[]
    private static int arraySum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    // b) a method printArray() to print an int[][] using Arrays.toString(),
    // but not deepToString(), exactly like this:
    // [ [3, 2, 5],
    // [1, 4, 4, 8, 13],
    // [9, 1, 0, 2],
    // [0, 2, 6, 4, -1, -8] ]
    private static void printArray(int[][] array) {
        System.out.print("[ ");
        int i = 0;
        for (i = 0; i < array.length - 1; i++) {
            System.out.print(Arrays.toString(array[i]) +"],\n");
        }
        System.out.println(Arrays.toString(array[i]) + " ]");
    }

    // c) a method printAll() to print all the elements in the array like this:
    // row 0, col 0 = 3
    // row 0, col 1 = 2
    // ...
    private static void printAll(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("row %d, col %d = %d\n", i, j, array[i][j]);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] array = {
            {3, 2, 5},
            {1, 4, 4, 8, 13},
            {9, 1, 0, 2},
            {0, 2, 6, 4, -1, -8}
        };

        int totalSum = 0;
        for (int i = 0; i < array.length; i++) {
            // d) print the sum of each of the inside arrays (rows)
            System.out.printf("Sum of array %d: %d\n", i+1, arraySum(array[i]));
            totalSum += arraySum(array[i]);
        }

        // e) print the sum of all elements in the array
        System.out.printf("\nTotal sum of arrays: %d\n\n", totalSum);

        // f) print all the elements in the array using printArray() and
        // printAll()
        printArray(array);
        printAll(array);
    }
}
