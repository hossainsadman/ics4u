package hossain_sadman_gradebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Represents the interface with which teachers can access and modify student
 * information and marks for various courses. Implements course and
 * student-specific methods with simple text formatting for the user.
 * @author Sadman
 */
public class Gradebook {

    static Scanner s = new Scanner(System.in);

    // indent string constants for text formatting
    final static String INDENT1 = "  ";
    final static String INDENT2 = INDENT1 + INDENT1;

    /**
     * Returns an integer input safely; catches errors and displays given input
     * and error messages for the user.
     * @param prompt initial message to display prompting input
     * @param errorMsg error message
     * @return an integer input
     */
    static int intPrompt(String prompt, String errorMsg) {
        while (true) {
            System.out.print(prompt);

            try {
                int input = Integer.parseInt(s.nextLine());
                System.out.println();
                return input;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    /**
     * Returns an integer input safely; has given lower and upper bounds for
     * input, catches errors, and displays given input and error messages for
     * the user.
     * @param prompt initial message to display prompting input
     * @param errorMsg error message
     * @param lower lower bound for input
     * @param upper upper bound for input
     * @return an integer input
     */
    static int intPrompt(String prompt, String errorMsg, int lower, int upper) {
        while (true) {
            System.out.print(prompt);

            try {
                int input = Integer.parseInt(s.nextLine());

                // set lower and upper bounds for input
                if (input < lower || input > upper) {
                    System.out.println(errorMsg);
                    continue;
                }

                System.out.println();
                return input;
            } catch (NumberFormatException e) {
                System.out.println(errorMsg);
            }
        }
    }

    /**
     * Returns a valid integer input for an assignment number; displays input
     * and error messages for user and prevents user from inputting an invalid
     * assignment number (below 0 or above the number of assignments for each
     * student).
     * @param course course to return assignment number for
     * @return a valid assignment number (as an integer)
     */
    private static int assignmentPrompt(Course course) {
        int assignment = intPrompt("Enter an assignment number: ",
                "Assignment does not exist!", 0, course.numAssignments() - 1);
        return assignment;
    }

    /**
     * Prints the startup message for the gradebook program.
     */
    static void startUp(Course course) {
        System.out.println("+----------------+");
        System.out.println("| TDSB GRADEBOOK |");
        System.out.println("+----------------+");
        System.out.println("AUTHOR: Sadman Hossain");

        System.out.println("\nEnter the number of the command or menu you wish to use.");
        System.out.println("e.g. \'> 1\'\n");
        System.out.printf("COURSE: %s - %s\n", course.getCode(), course.getName());

        menuMain(course);
    }

    /**
     * Runs the topmost menu for gradebook program (allows user to enter
     * 'STUDENTS' and 'MARKS' menus).
     * @param course course to run menu for
     */
    static void menuMain(Course course) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n  <<<MENUS>>>");
            System.out.println("1: STUDENTS");
            System.out.println("2: MARKS");
            System.out.println("-----------------");
            System.out.println("0: EXIT GRADEBOOK");

            int command = intPrompt("\n> ",
                    "Invalid command! Please enter a command between 0 and 2.",
                    0, 2);

            switch (command) {
                // menu exit command
                case 0:
                    System.out.println("Thank you for using TDSB GRADEBOOK!");
                    exit = true;
                    break;
                case 1:
                    menuStudents(course);
                    break;
                case 2:
                    menuMarks(course);
                    break;
            }
        }
    }

    /**
     * Run 'STUDENTS' commands menu; allows user to access and modify student
     * personal information.
     * @param course course to run menu for
     */
    static void menuStudents(Course course) {
        boolean exit = false;
        while (!exit) {
            System.out.println("--------- <STUDENTS> ---------");
            System.out.println("1: List Students");
            System.out.println("2: Add a Student");
            System.out.println("3: Demit a Student");
            System.out.println("4: Edit a Student's Name");
            System.out.println("5: Edit a Student's ID");
            System.out.println("------------------------------");
            System.out.println("0: EXIT TO <<<MENUS>>>");

            int command = intPrompt("\n> ",
                    "Invalid command! Please enter a command between 0 and 5.",
                    0, 5);

            switch (command) {
                // menu exit command
                case 0:
                    System.out.println("EXITING TO <<<MENUS>>>...");
                    exit = true;
                    break;
                case 1:
                    printAverageForAllStudents(course);
                    break;
                case 2:
                    addStudent(course);
                    break;
                case 3:
                    removeStudent(course);
                    break;
                case 4:
                    editName(course);
                    break;
                case 5:
                    editId(course);
                    break;
            }
        }
    }

    /**
     * Run menu command for adding a student to a course.
     * @param course course to run command for
     */
    static void addStudent(Course course) {
        // get new student's name and id
        System.out.print("Enter student name: ");
        String name = s.nextLine();
        System.out.print("Enter student ID: ");
        String id = s.nextLine();

        // add new student to course
        course.addStudent(name, id);
        System.out.printf("Added student: %s %s. All marks set to -1.\n\n", id, name);
    }

    /**
     * Run menu command for removing a student from a course.
     * @param course course to run command for
     */
    static void removeStudent(Course course) {
        // get student from course
        System.out.print("Enter student name or ID: ");
        String nameOrId = s.nextLine();
        Student student = course.getStudent(nameOrId);

        // remove student if present in course
        if (student != null) {
            System.out.printf("Removed student: %s %s\n\n", student.getId(),
                    student.getName());
            course.removeStudent(nameOrId);
        }
    }

    /**
     * Run menu command for editing name of a student in a course.
     * @param course course to run command for
     */
    static void editName(Course course) {
        System.out.print("Enter student name or ID: ");
        String nameOrId = s.nextLine();

        if (course.getStudent(nameOrId) != null) {
            // print current name of student
            System.out.printf("Current Name: %s\n",
                    course.getStudent(nameOrId).getName());

            // set new inputted name for student
            System.out.print("New Name: ");
            String name = s.nextLine();
            course.getStudent(nameOrId).setName(name);
            System.out.printf("Student name set set to: %s\n\n", name);
        }
    }

    /**
     * Run menu command for editing id of a student in a course.
     * @param course course to run command for
     */
    static void editId(Course course) {
        System.out.print("Enter student name or ID: ");
        String nameOrId = s.nextLine();

        if (course.getStudent(nameOrId) != null) {
            // print current id of student
            System.out.printf("Current ID: %s\n",
                    course.getStudent(nameOrId).getId());

            // set new inputted id for student
            System.out.print("New ID: ");
            String id = s.nextLine();
            course.getStudent(nameOrId).setId(id);
            System.out.printf("Student name set set to: %s\n\n", id);
        }
    }

    /**
     * Run 'STUDENTS' commands menu; allows user to access and modify student
     * personal information.
     * @param course course to run menu for
     */
    static void menuMarks(Course course) {
        boolean exit = false;
        while (!exit) {
            System.out.println("---------- <MARKS> ----------");
            System.out.println("1: Add a Mark for a Student");
            System.out.println("2: Add Assignment");
            System.out.println("3: Delete Assignment");
            System.out.println("|");
            System.out.println("4: EDIT MARKS");
            System.out.println("5: LIST MARKS");
            System.out.println("6: VIEW AVERAGES");
            System.out.println("------------------------------");
            System.out.println("0: EXIT TO <<<MENUS>>>");

            int command = intPrompt("\n> ",
                    "Invalid command! Please enter a command between 0 and 5.",
                    0, 6);

            switch (command) {
                // menu exit command
                case 0:
                    System.out.println("EXITING TO <<<MENUS>>>...");
                    exit = true;
                    break;
                case 1:
                    addMark(course);
                    break;
                case 2:
                    addAssignment(course);
                    break;
                case 3:
                    deleteAssignment(course);
                    break;
                case 4:
                    menuEditMarks(course);
                    break;
                case 5:
                    menuListMarks(course);
                    break;
                case 6:
                    menuViewAverages(course);
                    break;
            }
        }
    }

    /**
     * Run menu command for adding an assignment in a course (by adding
     * placeholder mark of -1 to each student's list of marks).
     * @param course course to run command for
     */
    static void addAssignment(Course course) {
        course.addAssignment();
        System.out.println("Added an assignment!\n");
    }

    /**
     * Run menu command for deleting an assignment in a course (by removing the
     * corresponding mark from each student's list of marks).
     * @param course course to run command for
     */
    static void deleteAssignment(Course course) {
        int assignment = assignmentPrompt(course);
        course.deleteAssignment(assignment);
        System.out.printf("Deleted assignment: %d\n\n", assignment);
    }

    /**
     * Run menu command for adding a mark for a new assignment to a student
     * (set a placeholder mark of -1 for that assignment for all other
     * students).
     * @param course course to run command for
     */
    static void addMark(Course course) {
        System.out.print("Enter student name or ID: ");
        String nameOrId = s.nextLine();
        Student student = course.getStudent(nameOrId);

        if (student != null) {
            // get mark to be added
            int mark = intPrompt("Enter assignment mark: ",
                "Invalid input! Please try again.",
                0, 100);

            // set inputted mark as the student's mark for a new assignment
            // (marks of all other students are set to -1)
            course.addMark(nameOrId, mark);
            System.out.printf("Added mark %d to student %s %s\n\n",
                mark, student.getId(), student.getName());
        }
    }

    /**
     * Run 'EDIT MARKS' commands menu; allows user to modify student and
     * assignment marks.
     * @param course course to run menu for
     */
    static void menuEditMarks(Course course) {
        boolean exit = false;
        while (!exit) {
            System.out.println("----------- EDIT MARKS -----------");
            System.out.println("1: Edit a Mark for a Student");
            System.out.println("2: Edit all Marks for a Student");
            System.out.println("3: Edit all Marks for an Assignment");
            System.out.println("-----------------------------------");
            System.out.println("0: EXIT TO <MARKS>");

            int command = intPrompt("\n> ",
                    "Invalid command! Please enter a command between 0 and 5.",
                    0, 3);

            switch (command) {
                // menu exit command
                case 0:
                    System.out.println("EXITING TO <MARKS>...\n");
                    exit = true;
                    break;
                case 1:
                    editMarkForStudent(course);
                    break;
                case 2:
                    editAllMarksForStudent(course);
                    break;
                case 3:
                    editAllMarksForAssignment(course);
                    break;
            }
        }
    }

    /**
     *  Run menu command for editing a mark for a specific student's
     *  assignment.
     * @param course course to run command for
     */
    static void editMarkForStudent(Course course) {
        System.out.print("Enter student name or ID: ");
        Student student = course.getStudent(s.nextLine());

        if (student != null) {
            // get assignment and current mark for assignment
            int assignment = assignmentPrompt(course);
            System.out.printf("%sCurrent mark: %d\n", INDENT1, student.getMark(assignment));

            // set new inputted mark for assignment
            int mark = intPrompt(INDENT1 + "New mark: ",
                "Invalid input! Please try again.", 0, 100);
            student.setMark(assignment, mark);
            System.out.printf("Set assignment %d mark for %s %s to: %d\n\n",
                assignment, student.getId(), student.getName(), mark);
        }
    }

    /**
     * Run menu command for editing all marks of a student in the course.
     * @param course course to run command for
     */
    static void editAllMarksForStudent(Course course) {
        System.out.print("Enter student name or ID: ");
        Student student = course.getStudent(s.nextLine());

        if (student != null) {
            System.out.printf("EDIT ALL MARKS FOR STUDENT %s %s:\n",
                    student.getId(), student.getName());

            for (int i = 0; i < student.getMarks().size(); i++) {
                // print each assignment and the student's corresponding mark
                System.out.println(INDENT1 + "Assignment " + i + ":");
                System.out.println(INDENT2 + "Current Mark: " + student.getMark(i));

                // set new inputted mark for each assignment
                student.setMark(i, intPrompt(INDENT2 + "New Mark: ",
                    INDENT2 + "Invalid input! Please enter an integer mark between 0 and 100.",
                    0, 100));
            }
        }
    }

    /**
     * Run menu command for editing all marks of an assignment in the course.
     * @param course course to run command for
     */
    static void editAllMarksForAssignment(Course course) {
        int assignment = assignmentPrompt(course);
        System.out.print("EDIT ALL MARKS FOR ASSIGNMENT " + assignment + ":\n");

        for (Student student : course.getStudents()) {
            // print each student's current mark
            System.out.println(INDENT1 + student.getId() + " "
                    + student.getName() + ":");
            System.out.println(INDENT2 + "Current Mark: "
                    + student.getMark(assignment));

            // set new inputted mark for each student
            student.setMark(assignment, intPrompt(INDENT2 + "New Mark: ", INDENT2
                    + "Invalid input! Please enter an integer mark between 0 and 100.",
                    0, 100));
        }
    }

    /**
     * Run 'LIST MARKS' commands menu; allows user to access marks for students
     * and assignments.
     * @param course course to run menu for
     */
    static void menuListMarks(Course course) {
        boolean exit = false;
        while (!exit) {
            System.out.println("---------- LIST MARKS ----------");
            System.out.println("1: List Marks for an Assignment");
            System.out.println("2: List Marks for all Assignments");
            System.out.println("3: List Marks for a Student");
            System.out.println("4: List Marks for all Students");
            System.out.println("---------------------------------");
            System.out.println("0: EXIT TO <MARKS>");

            int command = intPrompt("\n> ",
                    "Invalid command! Please enter a command between 0 and 4.",
                    0, 4);

            switch (command) {
                // menu exit command
                case 0:
                    System.out.println("EXITING TO <MARKS>...\n");
                    exit = true;
                    break;
                case 1:
                    int assignment = assignmentPrompt(course);
                    printMarksForAssignment(course, assignment);
                    break;
                case 2:
                    printMarksForAllAssignments(course);
                    break;
                case 3:
                    printMarksForStudent(course);
                    break;
                case 4:
                    printMarksForAllStudents(course);
                    break;
            }
        }
    }

    /**
     * Run menu command for displaying all marks for an assignment in the course.
     * @param course course to run command for
     * @param assignment number of assignment
     */
    static void printMarksForAssignment(Course course, int assignment) {
        System.out.print("ASSIGNMENT " + assignment + " MARKS:\n");

        for (Student student : course.getStudents()) {
            // print each student's mark for the specified assignment
            System.out.printf("%s %s: %d\n", INDENT1 + student.getId(),
                    student.getName(), student.getMark(assignment));
        }
        System.out.println();
    }

    /**
     * Run menu command for displaying all marks for all assignments in the
     * course.
     * @param course course to run command for
     */
    static void printMarksForAllAssignments(Course course) {
        for (int i = 0; i < course.numAssignments(); i++) {
            printMarksForAssignment(course, i);
        }
    }

    /**
     * Run menu command for displaying all marks for a student in the course.
     * @param course course to run command for
     */
    static void printMarksForStudent(Course course) {
        System.out.print("Enter student name or ID: ");
        Student student = course.getStudent(s.nextLine());

        if (student != null) {
            System.out.println();
            student.printAllMarks();
        }
    }

    /**
     * Run menu command for displaying all marks for all students in the
     * course.
     * @param course course to run command for
     */
    static void printMarksForAllStudents(Course course) {
        for (Student student1 : course.getStudents()) {
            student1.printAllMarks();
        }
    }

    /**
     * Run 'VIEW AVERAGES' commands menu; allows user to access student and
     * assignment averages.
     * @param course course to run menu for
     */
    static void menuViewAverages(Course course) {
        boolean exit = false;
        while (!exit) {
            System.out.println("---------- VIEW AVERAGES ----------");
            System.out.println("1: View Average for Course");
            System.out.println("2: View Average for a Student");
            System.out.println("3: View Averages for all Students");
            System.out.println("4: View Average for an Assignment");
            System.out.println("5: View Averages for all Assignments");
            System.out.println("-----------------------------------");
            System.out.println("0: EXIT TO <MARKS>");

            int command = intPrompt("\n> ",
                    "Invalid command! Please enter a command between 0 and 5.",
                    0, 5);

            switch (command) {
                // menu exit command
                case 0:
                    System.out.println("EXITING TO <MARKS>...\n");
                    exit = true;
                    break;
                case 1:
                    printAverageForCourse(course);
                    break;
                case 2:
                    System.out.print("Enter student name or ID: ");
                    Student student = course.getStudent(s.nextLine());

                    if (student != null) {
                        System.out.println("\n" + course.getCode() + " STUDENT AVERAGE:");
                        printAverageForStudent(course, student);
                        System.out.println();
                    }
                    break;
                case 3:
                    printAverageForAllStudents(course);
                    break;
                case 4:
                    printAverageForAssignment(course);
                    break;
                case 5:
                    printAverageForAllAssignments(course);
                    break;
            }
        }
    }

    /**
     * Run menu command for displaying the course average.
     * @param course course to run command for
     */
    static void printAverageForCourse(Course course) {
        System.out.printf("%s COURSE AVERAGE: %.1f\n\n", course.getCode(),
                course.courseAverage());
    }

    /**
     * Run menu command for displaying the average of a student in the course.
     * @param course course to run command for
     * @param student student object in the course
     */
    static void printAverageForStudent(Course course, Student student) {
        System.out.printf("%s %s: %.1f\n", INDENT1 + student.getId(),
                student.getName(), student.average());
    }

    /**
     * Run menu command for displaying the averages of all students in the
     * course.
     * @param course course to run command for
     */
    static void printAverageForAllStudents(Course course) {
        System.out.print(course.getCode() + " STUDENT AVERAGES:\n");

        for (Student student : course.getStudents()) {
            // print average for each student
            printAverageForStudent(course, student);
        }

        System.out.println();
    }

    /**
     * Run menu command for displaying the average of an assignment in the
     * course.
     * @param course course to run command for
     */
    static void printAverageForAssignment(Course course) {
        int assignment = assignmentPrompt(course);
        System.out.printf("%s ASSIGNMENT %d AVERAGE: %.1f\n\n", course.getCode(),
                assignment, course.assignmentAverage(assignment));
    }

    /**
     * Run menu command for displaying the averages of all assignments in the
     * course.
     * @param course course to run command for
     */
    static void printAverageForAllAssignments(Course course) {
        System.out.print(course.getCode() + " ASSIGNMENT AVERAGES:\n");

        for (int i = 0; i < course.numAssignments(); i++) {
            // print average for each assignment
            System.out.printf("%sAssignment %d: %.1f\n", INDENT1, i,
                    course.assignmentAverage(i));
        }

        System.out.println();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // hard-coded student info and instantiation
        Student alan = new Student("Alan T", "110101011",
                new ArrayList<Integer>(Arrays.asList(83, 71, 76, 91, 85)));
        Student donald = new Student("Donald K", "314159265",
                new ArrayList<Integer>(Arrays.asList(84, 90, 88, 99, 80)));
        Student albert = new Student("Albert E", "299792458",
                new ArrayList<Integer>(Arrays.asList(93, 65, 95, 40, 19)));
        Student marie = new Student("Marie C", "002661600",
                new ArrayList<Integer>(Arrays.asList(76, 52, 96, 92, 66)));
        Student ada = new Student("Ada L", "018151210",
                new ArrayList<Integer>(Arrays.asList(91, 98, 89, 99, 99)));

        // hard-coded course info and instantiation
        ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(alan, donald, albert, marie, ada));
        Course csc = new Course("Introduction to Computer Science", "CSC100", students);

        startUp(csc);
    }

}
