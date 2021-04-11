package binarysearch;

/**
 *
 * @author Sadman
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] test = {-42, -40, -39, -37, -30, -24, -22, -12, -10, -3, -2, 4, 7, 9, 14, 19, 25, 32, 34, 36, 39, 41, 43, 48};
        System.out.println(binarySearch(test, -42));
    }

    public static int linearSearch2(int[] array, int searched) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searched) {
                return i;
            } else if (array[i] > searched) {
                return -1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int searched) {
        int start, end, index;
        index = -1;
        start = 0;
        end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == searched) {
                index = mid;
                break;
            } else if (array[mid] < searched) {
                start = mid + 1;
            } else if (array[mid] > searched) {
                end = mid - 1;
            }
        }

        return index;
    }

}
