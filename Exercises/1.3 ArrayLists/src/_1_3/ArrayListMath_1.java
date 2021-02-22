package _1_3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class ArrayListMath_1 {

    private static Scanner s = new Scanner(System.in);

    // 1. Write the following methods for ArrayList<Integer>:

    // a) getIntList that prompts the user for integer values (one to a line)
    // and stores them in an ArrayList; when the user enters an empty line, the
    // list ends; the method should return the list as ArrayList<Integer>

    /**
     *
     * @return ArrayList<Integer>
     */
    static ArrayList<Integer> getIntList() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        System.out.println("ARRAYLIST CREATION - Enter a series of integers separated by 'Enter':");
        while (true) {
            String num = s.nextLine();
            if (num.trim().equals("")) {
                break;
            }
            arrayList.add(Integer.parseInt(num));
        }
        return arrayList;
    }

    // b) greatest that takes as parameter an integer ArrayList and returns the
    // greatest value in the list (don't sort the list)

    /**
     *
     * @param arrayList
     * @return greatest integer in arraylist
     */
    static int greatest(ArrayList<Integer> arrayList) {
        int greatest = -999999;
        for (int num : arrayList) {
            if (num < greatest) {
                num = greatest;
            }
        }
        return greatest;
    }

    // c) sum that takes as parameter an integer ArrayList and returns the sum
    // of all values of the list

    /**
     *
     * @param arrayList
     * @return sum of integer values in arraylist
     */
    static int sum(ArrayList<Integer> arrayList) {
        int sum = 0;
        for (int num : arrayList) {
            sum += num;
        }
        return sum;
    }

    // d) average that takes as parameter an integer ArrayList and returns the
    // average of all values (must use sum); return 0 if the list is empty

    /**
     *
     * @param arrayList
     * @return average of all values in arraylist (0 if empty)
     */
    static double average(ArrayList<Integer> arrayList) {
        if (arrayList.size() > 0) {
            return (double) sum(arrayList)/arrayList.size();
        }
        return 0;
    }

    // e) median that takes as parameter an integer ArrayList and returns the
    // median value (the middle value of sorted list, or the average of the
    // middle two of an even number of values); return 0 if the list is empty

    /**
     *
     * @param arrayList
     * @return median value of items in the sorted list (0 if empty)
     */
    static double median(ArrayList<Integer> arrayList) {
        // if arraylist is empty, return 0
        if (arrayList.size() == 0) {
            return 0;
        }

        arrayList.sort(null);
        // if arraylist is even, return its middle value after sorting
        if (arrayList.size() % 2 == 0) {
            return arrayList.get(arrayList.size()/2);
        }
        // if arraylist is odd, return average of its middle 2 values
        return (arrayList.get(arrayList.size()/2) + arrayList.get(arrayList.size()/2 + 1)) / 2.0;
    }

    // f) variance that takes as parameter an integer list and returns the
    // sample variance of the list (must use average); see the Wikipedia entry
    // on population & sample variance to determine the unbiased sample

    /**
     *
     * @param arrayList
     * @return sample variance
     */
    static double variance(ArrayList<Integer> arrayList) {
        double average = average(arrayList);
        double variance = 0;
        for (int num : arrayList) {
            variance += Math.pow(num - average, 2);
        }
        variance = variance / (arrayList.size() - 1.0);
        return variance;
    }

    // g) moreThanOnce that takes as parameters an integer list and an integer
    // and returns true if the integer appears more than once in the list

    /**
     *
     * @param arrayList
     * @param value
     * @return boolean of whether value appears more than once in arraylist
     */
    static boolean moreThanOnce(ArrayList<Integer> arrayList, int value) {
        if (arrayList.indexOf(value) != arrayList.lastIndexOf(value)) {
            return true;
        }
        return false;
    }

    // h) combine that takes as parameters two integer lists and combines them
    // into a new list, which is then returned; however, duplicate entries are
    // not included

    /**
     *
     * @param arrayList1
     * @param arrayList2
     * @return arraylist that combines arrayList1 and arrayList2 while
     * excluding duplicate entries
     */
    static ArrayList<Integer> combine(ArrayList<Integer> arrayList1, ArrayList<Integer> arrayList2) {
        for (int num : arrayList2) {
            if (!arrayList1.contains(num)) {
                arrayList1.add(num);
            }
        }
        return arrayList1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // in the main method:
        // i) ask the user to enter values for an integer list
        ArrayList<Integer> arrayList = getIntList();

        // j) print the list
        System.out.println(arrayList.toString() + "\n");

        // k) print the greatest value, sum, average, median, and variance
        // nicely with explanatory statements
        System.out.printf("\nSum of values in arraylist: %d\n", sum(arrayList));
        System.out.printf("Average of values in arraylist: %.2f\n", average(arrayList));
        System.out.printf("Median of values in arraylist: %f\n", median(arrayList));
        System.out.printf("Variance of values in arraylist: %.2f\n", variance(arrayList));

        // l) asks the user for an integer to check if it appears more than
        // once in the list and print the result
        System.out.print("\nInput an integer to see if it appears more than once in your arraylist: ");
        int num = Integer.parseInt(s.nextLine());
        System.out.println(num + " appears more than once? " + moreThanOnce(arrayList, num));

        // m) asks the user to enter values for another integer list and
        // combine it with the list from above; print each entered list and the
        // combined list
        System.out.println("\nCreate another arraylist.");
        ArrayList<Integer> arrayList2 = getIntList();
        ArrayList<Integer> combined = combine(arrayList, arrayList2);

        arrayList.sort(null);
        arrayList2.sort(null);
        combined.sort(null);

        System.out.println("List 1: " + arrayList.toString());
        System.out.println("List 2: " + arrayList2.toString());
        System.out.println("Combined List: " + combined.toString());
    }
}
