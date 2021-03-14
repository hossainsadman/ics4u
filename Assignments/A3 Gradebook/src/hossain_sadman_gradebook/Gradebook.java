package hossain_sadman_gradebook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class Gradebook {

    private static Scanner s = new Scanner(System.in);

    public static void printStartUp() {
        System.out.println("--------TDSB GRADEBOOK--------");
        System.out.println("AUTHOR: Sadman Hossain");
        System.out.println("------------------------------\n");
    }

    public static void menu() {
        boolean exit = false;
        while (true) {
            System.out.println("------COMMANDS------");
            System.out.println("1: Student Information");
            System.out.println("2: Assignments");
            System.out.println("3: Marks");
            System.out.println("-----------------");
            System.out.println("4: EXIT GRADEBOOK");

            int command = inputPrompt("> ", "Invalid command! Please enter a command between 1 and 4.\n", 1, 4);

            switch (command) {
                case 4: System.out.println("Thank you for using TDSB GRADEBOOK!");
                    break;
            }

            if (exit) {
                break;
            }
        }
    }

    private static int inputPrompt(String prompt, String errorMsg) {
        while (true) {
            System.out.print(prompt);
            try {
                int mark = Integer.parseInt(s.nextLine());
                return mark;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    private static int inputPrompt(String prompt, String errorMsg, int lower, int upper) {
        while (true) {
            System.out.print(prompt);
            try {
                int mark = Integer.parseInt(s.nextLine());
                if (mark < lower || mark > upper) {
                    System.out.println(errorMsg);
                    continue;
                }
                return mark;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printStartUp();
        Student a = new Student("a", 1);
        Student b = new Student("b", 2);
        Student c = new Student("c", 3);
        Student d = new Student("d", 4);
        Student e = new Student("t", 1);
        ArrayList<Student> asd= new ArrayList<Student>();
        asd.add(a);
        asd.add(b);
        asd.add(c);
        asd.add(d);
        asd.add(e);
        Course course = new Course("abcd", "12", asd);
        course.addAssignment();
        course.setMark(a, 0, 56);
        course.printAssignmentMarks(0);
        course.setAllMarks(0);
        course.addAssignment();
        course.setAllMarks(1);
        course.printAssignmentMarks(1);
        course.deleteAssignment(0);
        course.printAssignmentMarks(0);
    }

}