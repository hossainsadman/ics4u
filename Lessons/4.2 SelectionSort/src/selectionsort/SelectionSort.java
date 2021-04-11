package selectionsort;

import java.util.Arrays;

/**
 *
 * @author Sadman
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = new int[10000];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) Math.round(Math.random() * 1000);
        }
        sort(a);
    }

    // Write a method smallest(), which returns the smallest value in an int array
    public static int smallest(int[] array) {
        int smallest = array[0];
        for (int item : array) {
            if (item < smallest) {
                smallest = item;
            }
        }
        return smallest;
    }

    // Write a method indexOfTheSmallest(), which returns the index of the
    // smallest value in an int array
    public static int indexOfTheSmallest(int[] array) {
        int smallest = 99999999;
        int indexSmallest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                indexSmallest = i;
            }

        }
        return indexSmallest;
    }

    // Write a method indexOfTheSmallestStartingFrom(), which works just like
    // the method of the previous exercise, but only takes into consideration
    // the portion of an array starting from a certain index. In addition to
    // the array, the method gets as parameter an index, from which the search
    // for the smallest will be started
    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int smallest = 99999999;
        int indexSmallest = 0;
        for (int i = index; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                indexSmallest = i;
            }
        }
        return indexSmallest;
    }

    // Write a method swap(), to which will be passed an array and two of its
    // indexes. The method swaps the values of the cells between the two
    // indexes
    public static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    // Write a method sort(), which is based on the idea above. The method
    // ought to have a loop that goes through the indexes of the array. The
    // methods smallestIndexStartingFrom() and swap() are surely useful. Also
    // print the contents of the array before sorting and after each round to
    // be able to make sure that the algorithm works correctly.
    public static void sort(int[] array) {
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            int indexSwap = indexOfTheSmallestStartingFrom(array, i);
            swap(array, i, indexSwap);
            System.out.println(Arrays.toString(array));
        }
    }

}
