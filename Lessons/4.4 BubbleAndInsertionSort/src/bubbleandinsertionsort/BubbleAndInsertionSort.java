package bubbleandinsertionsort;

import java.util.Arrays;

/**
 *
 * @author Sadman
 */
public class BubbleAndInsertionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] test = {54, 26, 93, 17, 77, 31, 44, 55};
        // bubbleSort(test);
        // insertionSort(test);
    }

    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    // Bubble sort compares adjacent cells and moves smaller ones left, larger
    // ones right. The largest value will be 'bubbled' to the right, and
    // smallest value 'bubbled' to the left. Once its sorted, a final pass is
    // required to ensure that no swaps were made.

    // Create an algorithm which implements Bubble Sort.
    public static void bubbleSort(int[] array) {
        while (true) {
            boolean sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }

            if (sorted) {
                break;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    // Insertion sort iterates through the array and moves the current array
    // cell left into its proper position by shifting cells right, as long as
    // it's smaller than the cell on the left. The array is sorted from left to
    // right.

    // Write an algorithm that implements Insertion Sort.
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > curr) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }

        System.out.println(Arrays.toString(array));
    }
}