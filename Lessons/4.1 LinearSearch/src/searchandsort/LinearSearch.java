package searchandsort;

/**
 *
 * @author Sadman
 */
public class LinearSearch {

    public static void main(String[] args) {
        int[] a = {3, -3, 7, 12, 9, 10, 14};
        System.out.println(linearSearch(a, 4));
        System.out.println(linearSearch(a, 14));
    }

    // Write a method linearSearch() which takes parameters an array and searched value
    public static boolean linearSearch(int[] array, int searched) {
        for (int item : array) {
            if (item == searched) {
                return true;
            }
        }
        return false;
    }
}
