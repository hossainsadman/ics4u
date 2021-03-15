package hossain_sadman_gradebook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class Gradebook {

    private static Scanner s = new Scanner(System.in);

    private static int inputPrompt(String prompt, String errorMsg) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = Integer.parseInt(s.nextLine());
                System.out.println();
                return input;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    private static int inputPrompt(String prompt, String errorMsg, int lower, int upper) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = Integer.parseInt(s.nextLine());
                if (input < lower || input > upper) {
                    System.out.println(errorMsg);
                    continue;
                }
                System.out.println();
                return input;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static void printStartUp() {
        System.out.println("******TDSB GRADEBOOK******");
        System.out.println("\nAUTHOR: Sadman Hossain");
        System.out.println("\n**************************");
    }

    public static void menu(Course course) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n<<<<<< SECTIONS >>>>>>");
            System.out.println("1: Students");
            System.out.println("2: Marks");
            System.out.println("-----------------");
            System.out.println("3: EXIT GRADEBOOK");

            int command = inputPrompt("\n> ", "Invalid command! Please enter a command between 1 and 3.\n", 1, 3);

            switch (command) {
                case 1:
                    students(course);
                    break;
                case 2:
                    marks(course);
                    break;
                case 3:
                    System.out.println("\nThank you for using TDSB GRADEBOOK!");
                    exit = true;
                    break;
            }
        }
    }

    public static void students(Course course) {
        boolean exit = false;
        while (!exit) {
            System.out.println("----- <STUDENTS > -----");
            System.out.println("1: List Students");
            System.out.println("2: Add a Student");
            System.out.println("3: Demit a Student");
            System.out.println("4: Edit a Student's Name");
            System.out.println("5: Edit a Student's ID");
            System.out.println("-----------------");
            System.out.println("0: GO BACK TO <SECTIONS>");

            int command = inputPrompt("\n> ",
                                    "Invalid command! Please enter a command between 0 and 5.",
                                    0, 5);

            String name, id, nameOrId;

            switch (command) {
                case 1:
                    course.printStudentAverages();
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    name = s.nextLine();
                    System.out.print("Enter student ID: ");
                    id = s.nextLine();
                    course.addStudent(new Student(name, id));
                    System.out.printf("Added student: %s %s\n\n", id, name);
                    break;
                case 3:
                    System.out.print("Enter student name or ID: ");
                    nameOrId = s.nextLine();
                    course.removeStudent(nameOrId);
                    System.out.printf("Removed student (if present): %s\n\n", nameOrId);
                    break;
                case 4:
                    System.out.print("Enter student name or ID: ");
                    nameOrId = s.nextLine();
                    System.out.printf("Current Name: %s\n",
                                    course.getStudent(nameOrId).getName());
                    System.out.print("New Name: ");
                    name = s.nextLine();
                    course.getStudent(nameOrId).setName(name);
                    System.out.printf("Student name set set to: %s\n\n", name);
                    break;
                case 5:
                    System.out.print("Enter student name or ID: ");
                    nameOrId = s.nextLine();
                    System.out.printf("Current ID: %s\n",
                                    course.getStudent(nameOrId).getId());
                    System.out.print("New ID: ");
                    id = s.nextLine();
                    course.getStudent(nameOrId).setId(id);
                    System.out.printf("Student name set set to: %s\n\n", id);
                    break;
                case 0:
                    System.out.println("GOING BACK TO <SECTIONS>...");
                    exit = true;
                    break;
            }
        }
    }

    public static void marks(Course course) {
        boolean exit = false;
        while (!exit) {
            System.out.println("----- <MARKS> -----");
            System.out.println("1: Add Assignment");
            System.out.println("2: Delete Assignment");
            System.out.println("|");
            System.out.println("3: Add a Mark for a Student");
            System.out.println("4: Edit a Mark for a Student");
            System.out.println("5: Edit all Marks for a Student");
            System.out.println("|");
            System.out.println("6: Edit All Marks For An Assignment");
            System.out.println("7: Edit A Mark For An Assignment");
            System.out.println("|");
            System.out.println("8: View Average For: Course");
            System.out.println("9: View Average For: An Assignment");
            System.out.println("10: List Marks For: An Assignment");
            System.out.println("11: View Average For: All Assignments");
            System.out.println("12: List Marks For: All Assignments");
            System.out.println("|");
            System.out.println("13: View Average For: A Student");
            System.out.println("14: List Marks For: A Student");
            System.out.println("15: View Average For: All Students");
            System.out.println("16: List Marks For: All Students");
            System.out.println("17: View Average For: All Students");
            System.out.println("-----------------");
            System.out.println("0: GO BACK TO <SECTIONS>");

            int command = inputPrompt("\n> ",
                                    "Invalid command! Please enter a command between 0 and 17.\n",
                                    0, 17);

            int assignment;

            switch (command) {
                case 1:
                    course.addAssignment();
                    System.out.println("Added an assignment!\n");
                    break;
                case 2:
                    assignment = inputPrompt("Enter assignment number: ",
                                                    "Invalid input! Please try again.");
                    course.deleteAssignment(assignment);
                    System.out.printf("Deleted assignment: %d\n\n", assignment);
                    break;
                case 6:
                    assignment = inputPrompt("Enter assignment number: ",
                                                    "Invalid input! Please try again.",
                                                    0, course.getStudents().get(0).getMarks().size() - 1);
                    course.setAllMarksForAssignment(assignment);
                    break;
                case 8:
                    course.printCourseAverage();
                    break;
                case 11:
                    course.printAllAssignmentAverages();
                    break;
                case 12:
                    course.printAllAssignmentAverages();
                    break;
                case 17:
                    course.printStudentAverages();
                    break;
                case 0:
                    System.out.println("GOING BACK TO <SECTIONS>...");
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
        Student a = new Student("Mario S", "00001");
        Student b = new Student("Petey C", "00002");
        Student c = new Student("Anna S", "00003");
        Student d = new Student("Paul M", "00004");
        Student e = new Student("Anna M", "00005");
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(a);
        students.add(b);
        students.add(c);
        students.add(d);
        students.add(e);
        Course course = new Course("Intro to CS", "ICS4U", students);
        menu(course);
    }

}
