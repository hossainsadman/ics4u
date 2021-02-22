package _1_1;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class ParallelArrays_5 {

    static Scanner s = new Scanner(System.in);

    // 5. Parallel arrays: We can use two arrays of the same length to associate
    //    values from each array. For example, an array of student names and
    //    their student numbers:

    // names = {"Alan", "Ada", "Grace", "Linus"}
    // numbers = {181256345, 181159830, 181245891, 189875304}

    // We know that Alan's student number is 181256345 because the index for
    // "Alan" is the same as the index of 181256345, namely 0. So we can
    // associate names[0] with numbers[0], etc.

    public static void main(String[] args) {

        // a) Write a program that initializes the above arrays and prints out
        // the class list as such:

        // Class:
        //   CS101
        // Students:
        //   Alan, 181256345
        //   Ada, 181159830
        //   Grace, 181245891
        //   Linus, 189875304

        String[] names = {"Alan", "Ada", "Grace", "Linus"};
        int[] numbers = {181256345, 181159830, 181245891, 189875304};

        String indent = "  ";
        System.out.println("Class:");
        System.out.println(indent + "CS101");

        System.out.println("Students:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%s%s, %d\n", indent, names[i], numbers[i]);
        }

        // b) Ask the user to enter a student's name and if that name exists,
        // print the student number. If it doesn't exist, print an error
        // message.

        // SAMPLE OUTPUT
        // Please enter a name: Steve
        // Student Steve does not exist.

        // Please enter a name: Alan
        // Alan's student number is 181256345.

        boolean found = false;
        while (!found) {
            System.out.print("\nEnter a student's name: ");
            String name = s.nextLine();

            for (int i = 0; i < names.length; i++) {
                if (name.equals(names[i])) {
                    System.out.printf("%s's student number is %d.", name, numbers[i]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.printf("Student %s does not exist.\n", name);
            }
        }
    }
}
