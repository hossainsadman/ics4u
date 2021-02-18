package _1_1;

import java.util.Arrays;

/**
 *
 * @author Sadman
 */
public class Arrays_2 {
    public static void main(String[] args) {

        // 2. Write a program that initializes this integer array [13, 60, 50,
        //    46, 56, 83, 22, 71] . Reverse the array, i.e. change to [71, 22,
        //    83, 56, 46, 50, 60, 13], using two different ways:

        // a) Simply print the elements in reverse order. No new array.
        int[] array = {13, 60, 50, 46, 56, 83, 22, 71};
        for (int i = array.length-1; i > -1; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // b) Create an empty array of identical length. The original array is
        // not changed. The second array gets the elements of the first array
        // in reversed order. The content of the second array is then printed
        // in order.
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array2[i] = array[array.length-i-1];
        }
        System.out.println(Arrays.toString(array2));

    }
}