package _1_2;

import java.util.Arrays;

/**
 *
 * @author Sadman
 */
public class ArrayManipulation_3 {

    // 3. The following exercises will use rectangular 2D integer arrays (that
    //    is, each row has the same number of columns).

    // a) Write a method swapRow() that swaps two rows in an array. The method
    // should take as parameters the array and two row indexes to be swapped.
    // Assume the array has enough rows.

    private static int[][] swapRow(int[][] array, int row1, int row2) {
        int[] tmp = array[row1];
        array[row1] = array[row2];
        array[row2] = tmp;
        return array;
    }

    // b) Write a method swapCol() that swaps two columns in an array. The
    // method should take as parameters the array and two column indexes to be
    // swapped. Assume the array has enough columns.

    private static int[][] swapCol(int[][] array, int col1, int col2) {
        for (int i = 0; i < array.length; i++) {
            int tmp = array[i][col1];
            array[i][col1] = array[i][col2];
            array[i][col2] = tmp;
        }
        return array;
    }

    // c) Write a method multiplyRow() that multiplies every element in a
    // particular row by a given integer constant. The method should take as
    // parameters the array, the row index, and the constant.

    private static int[][] multiplyRow(int[][] array, int row, int multiplier) {
        for (int i = 0; i < array[row].length; i++) {
            array[row][i] *= multiplier;
        }
        return array;
    }

    // d) Write a method rotate() that rotates the array clockwise 90° and
    // returns the new array.

    private static int[][] rotate(int[][] array) {
        int[][] rotatedArray = new int[array[0].length][array.length];
        for (int col = 0; col < array.length; col++) {
            for (int row = 0; row < array.length; row++) {
                rotatedArray[col][row] = array[array.length-1-row][col];
            }
        }
        return rotatedArray;
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

        // Finally, write a main method that shows each of these methods in
        // action.

        System.out.println(Arrays.deepToString(swapRow(array, 0, 1)));
        System.out.println(Arrays.deepToString(swapCol(array, 0, 1)));
        System.out.println(Arrays.deepToString(multiplyRow(array, 0, 5)));
        System.out.println(Arrays.deepToString(rotate(array)));
    }
}
