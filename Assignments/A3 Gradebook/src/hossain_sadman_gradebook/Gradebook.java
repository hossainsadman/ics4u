package hossain_sadman_gradebook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class Gradebook {

    private static Scanner s = new Scanner(System.in);

    private static Course ics = new Course("Intro to CS", "ICS4U");

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

    public static void printStartUp() {
        System.out.println("--------TDSB GRADEBOOK--------");
        System.out.println("AUTHOR: Sadman Hossain");
        System.out.println("------------------------------");
    }

    public static void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n------COMMANDS------");
            System.out.println("1: Students");
            System.out.println("2: Assignments");
            System.out.println("3: Marks");
            System.out.println("-----------------");
            System.out.println("4: EXIT GRADEBOOK");

            int command = inputPrompt("> ", "Invalid command! Please enter a command between 1 and 4.\n", 1, 4);

            switch (command) {
                case 4: System.out.println("Thank you for using TDSB GRADEBOOK!");
                    exit = true;
                    break;
            }
        }
    }

    public static void students() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n----- <STUDENTS> -----");
            System.out.println("1: List Students");
            System.out.println("2: Add Students");
            System.out.println("3: Demit Students");
            System.out.println("4: View Student Info");
            System.out.println("5: Edit Student Info");
            System.out.println("-----------------");
            System.out.println("0: GO BACK TO <TOOLS>");

            int command = inputPrompt("> ", "Invalid command! Please enter a command between 0 and 5.\n", 0, 5);

            switch (command) {
                case 1: ics.printStudentAverages();
                case 0: System.out.println("GOING BACK TO <TOOLS>...");
                    exit = true;
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        printStartUp();
        Student a = new Student("a", "1");
        Student b = new Student("b", "2");
        Student c = new Student("c", "3");
        Student d = new Student("d", "4");
        Student e = new Student("t", "1");
        ArrayList<Student> asd= new ArrayList<Student>();
        asd.add(a);
        asd.add(b);
        asd.add(c);
        asd.add(d);
        asd.add(e);
        Course course = new Course("abcd", "12", asd);
        course.addAssignment();
        course.setMark("a", 0, 56);
        course.printAssignmentMarks(0);
        course.setAllMarks(0);
        course.addAssignment();
        course.setAllMarks(1);
        course.printAssignmentMarks(1);
        course.deleteAssignment(0);
        course.printAssignmentMarks(0);
    }

}