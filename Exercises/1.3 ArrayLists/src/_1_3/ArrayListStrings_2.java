package _1_3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class ArrayListStrings_2 {

    private static Scanner s = new Scanner(System.in);

    // 2. Write the following methods for ArrayList<String>:

    // a) getStringList that prompts the user to enter string values until they
    // enter an empty string; store the values in a string ArrayList and return
    // it

    /**
     *
     * @return ArrayList<String>
     */
    static ArrayList<String> getStringList() {
        ArrayList<String> arrayList = new ArrayList<String>();
        System.out.println("ARRAYLIST CREATION - Enter a series of strings separated by 'Enter':");
        while (true) {
            String str = s.nextLine();
            if (str.trim().equals("")) {
                break;
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    // b) lengthsOfStrings that takes as parameter a string ArrayList and
    // returns the length of each string as an int[]

    /**
     *
     * @param arrayList
     * @return
     */
    static int[] lengthsOfStrings(ArrayList<String> arrayList) {
        int[] lengthsOfStrings = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            lengthsOfStrings[i] = arrayList.get(i).length();
        }
        return lengthsOfStrings;
    }

    // c) removeLast that takes as parameter a string ArrayList and removes the
    // last item in the list

    /**
     *
     * @param arrayList
     */
    static void removeLast(ArrayList<String> arrayList) {
        arrayList.remove(arrayList.size() - 1);
    }

    // d) removeFirst that takes as parameter a string ArrayList and removes
    // the first item in the list

    /**
     *
     * @param arrayList
     */
    static void removeFirst(ArrayList<String> arrayList) {
        arrayList.remove(0);
    }

    // e) printList that takes as parameter a string ArrayList and prints the
    // items each on their own line

    /**
     *
     * @param arrayList
     */
    static void printList(ArrayList<String> arrayList) {
        for (String str : arrayList) {
            System.out.println(str);
        }
    }

    // f) printReversed that takes as parameter a string ArrayList and prints
    // the items in reverse order without changing or copying the list

    /**
     *
     * @param arrayList
     */
    static void printReversed(ArrayList<String> arrayList) {
        for (int i = arrayList.size()-1; i >= 0; i--) {
            System.out.println(arrayList.get(i));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // in the main method:
        // g) ask the user to enter values for a string ArrayList
        ArrayList<String> arrayList = getStringList();

        // h) print each string on its own line
        printList(arrayList);
        System.out.println();

        // i) print the lengths of all the strings
        for (int length : lengthsOfStrings(arrayList)) {
            System.out.println(length);
        }
        System.out.println();

        // j) print the list in reverse order
        printReversed(arrayList);
        System.out.println();

        // k) remove the first and last items and print the list
        removeFirst(arrayList);
        removeLast(arrayList);
        printList(arrayList);

        // l) asks the user for a string to remove from the list, and if possible,
        // removes it and prints the new list, or prints an error; ask the user
        // for an index and remove that index element from the list, if
        // possible.
        System.out.print("\nInput a value to remove from the list: ");
        String valueToRemove = s.nextLine();
        if (arrayList.contains(valueToRemove)) {
            arrayList.remove(valueToRemove);
        } else {
            System.out.printf("\nError! %d is not a value within the list.\n", valueToRemove);
        }
        printList(arrayList);
        System.out.println();

        System.out.println("Input the index of an element to remove from the list: ");
        int indexToRemove = Integer.parseInt(s.nextLine());
        if (0 <= indexToRemove && indexToRemove <= arrayList.size()-1) {
            arrayList.remove(indexToRemove);
        } else {
            System.out.println("Invalid index!");
        }
        printList(arrayList);

    }
}
