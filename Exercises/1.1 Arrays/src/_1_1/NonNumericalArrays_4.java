package _1_1;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class NonNumericalArrays_4 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // 4. Non-numerical arrays.

        // a) Ask the user to enter a string. Add each character of the string
        // to two different arrays: char[] and String[], e.g. "Java" → ['J',
        // 'a', 'v', 'a'] and ["J", "a", "v", "a"] (Though when printed, both
        // will look like [J, a, v, a])

        // System.out.println("Enter a string: ");
        // String str = s.nextLine();

        // char[] charArray = str.toCharArray();
        // String[] stringArray = new String[str.length()];
        // for (int i = 0; i < str.length(); i++) {
        //     stringArray[i] = Character.toString(charArray[i]);
        // }

        // System.out.println(stringArray.toString());
        // System.out.println(charArray.toString());


        // b) Get an integer n from the user and initialize a String array of
        // length n. Ask the user to enter n strings and fill the array. Create
        // a new string which is the elements of the array in order,
        // concatenated with spaces between each element but not after the last
        // string, e.g. ["All", "your", "base"] → "All your base"

        System.out.print("Enter an integer: ");
        int n = Integer.parseInt(s.nextLine());

        String[] stringArray2 = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Enter string %d: ", i+1);
            stringArray2[i] = s.nextLine();
        }

        String string = String.join(" ", stringArray2);
        string.trim();
        System.out.println(string);

        s.close();
    }
}