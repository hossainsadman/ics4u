package hossain_sadman_gradebook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Sadman
 */
public class Gradebook {

    static Scanner s = new Scanner(System.in);

    final static String INDENT1 = "  ";
    final static String INDENT2 = INDENT1 + INDENT1;

    static int intPrompt(String prompt, String errorMsg) {
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

    static int intPrompt(String prompt, String errorMsg, int lower, int upper) {
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

    private static int assignmentPrompt(Course course) {
        int assignment = intPrompt("Enter an assignment number: ",
                        "Assignment does not exist!", 0,
                        course.getStudents().get(0).getMarks().size() - 1);
        return assignment;
    }

    public static void printStartUp() {
        System.out.println("+----------------+");
        System.out.println("| TDSB GRADEBOOK |");
        System.out.println("+----------------+");
        System.out.println("AUTHOR: Sadman Hossain");

        System.out.println("\nEnter the number of the command or section you wish to use:");
        System.out.println("e.g. \"> 1\"");
    }

    public static void sectionMenu(Course course) throws InterruptedException {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n<<< SECTIONS >>>");
            System.out.println("1: STUDENTS");
            System.out.println("2: MARKS");
            System.out.println("-----------------");
            System.out.println("0: EXIT GRADEBOOK");

            int command = intPrompt("\n> ", "Invalid command! Please enter a command between 0 and 2.", 0, 2);

            switch (command) {
                case 0:
                    System.out.println("Thank you for using TDSB GRADEBOOK!");
                    exit = true;
                    break;
                case 1:
                    sectionStudents(course);
                    break;
                case 2:
                    sectionMarks(course);
                    break;
            }
        }
    }

    public static void sectionStudents(Course course) throws InterruptedException {
        boolean exit = false;
        while (!exit) {
            System.out.println("-------- <STUDENTS > --------");
            System.out.println("1: List Students");
            System.out.println("2: Add a Student");
            System.out.println("3: Demit a Student");
            System.out.println("4: Edit a Student's Name");
            System.out.println("5: Edit a Student's ID");
            System.out.println("------------------------------");
            System.out.println("0: GO BACK TO <<< SECTIONS >>>");

            int command = intPrompt("\n> ",
                                    "Invalid command! Please enter a command between 0 and 5.",
                                    0, 5);

            switch (command) {
                case 0:
                    System.out.println("GOING BACK TO <<< SECTIONS >>>...");
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
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public static void addStudent(Course course) {
        System.out.print("Enter student name: ");
        String name = s.nextLine();
        System.out.print("Enter student ID: ");
        String id = s.nextLine();
        course.addStudent(name, id);
        System.out.printf("Added student: %s %s\n\n", id, name);
    }

    static void removeStudent(Course course) {
        System.out.print("Enter student name or ID: ");
        String nameOrId = s.nextLine();
        Student student = course.getStudent(nameOrId);
        if (student != null) {
            System.out.printf("Removed student: %s %s\n\n", student.getId(), student.getName());
            course.removeStudent(nameOrId);
        }
    }

    static void editName(Course course) {
        System.out.print("Enter student name or ID: ");
        String nameOrId = s.nextLine();
        if (course.getStudent(nameOrId) != null) {
            System.out.printf("Current Name: %s\n",
                            course.getStudent(nameOrId).getName());
            System.out.print("New Name: ");
            String name = s.nextLine();
            course.getStudent(nameOrId).setName(name);
            System.out.printf("Student name set set to: %s\n\n", name);
        }
    }

    static void editId(Course course) {
        System.out.print("Enter student name or ID: ");
        String nameOrId = s.nextLine();
        if (course.getStudent(nameOrId) != null) {
            System.out.printf("Current ID: %s\n",
                        course.getStudent(nameOrId).getId());
            System.out.print("New ID: ");
            String id = s.nextLine();
            course.getStudent(nameOrId).setId(id);
            System.out.printf("Student name set set to: %s\n\n", id);
        }
    }

    public static void sectionMarks(Course course) throws InterruptedException {
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
            System.out.println("0: GO BACK TO <<< SECTIONS >>>");

            int command = intPrompt("\n> ",
                                    "Invalid command! Please enter a command between 0 and 5.",
                                    0, 6);

            switch (command) {
                case 0:
                    System.out.println("GOING BACK TO <<< SECTIONS >>>...");
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
                    sectionEditMarks(course);
                    break;
                case 5:
                    sectionListMarks(course);
                    break;
                case 6:
                    sectionViewAverages(course);
                    break;
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }

    static void addAssignment(Course course) {
        course.addAssignment();
        System.out.println("Added an assignment!\n");
    }

    static void deleteAssignment(Course course) {
        int assignment = assignmentPrompt(course);
        course.deleteAssignment(assignment);
        System.out.printf("Deleted assignment: %d\n\n", assignment);
    }

    static void addMark(Course course) {
        System.out.print("Enter student name or ID: ");
        String nameOrId = s.nextLine();
        Student student = course.getStudent(nameOrId);
        if (student != null) {
            int mark = intPrompt("Enter assignment mark: ",
                                        "Invalid input! Please try again.",
                                        0, 100);
            course.addMark(nameOrId, mark);
            System.out.printf("Added mark %d to student %s %s\n\n",
                                mark, student.getId(), student.getName());
        }
    }

    public static void sectionEditMarks(Course course) throws InterruptedException {
        boolean exit = false;
        while (!exit) {
            System.out.println("---- EDIT MARKS ----");
            System.out.println("1: Edit a Mark for a Student");
            System.out.println("2: Edit all Marks for a Student");
            System.out.println("3: Edit all Marks for an Assignment");
            System.out.println("---------------------");
            System.out.println("0: GO BACK TO <MARKS>");

            int command = intPrompt("\n> ",
                                    "Invalid command! Please enter a command between 0 and 5.",
                                    0, 3);

            switch (command) {
                case 0:
                    System.out.println("GOING BACK TO <MARKS>...\n");
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

    static void editMarkForStudent(Course course) {
        System.out.print("Enter student name or ID: ");
        Student student = course.getStudent(s.nextLine());
        if (student != null) {
            int assignment = assignmentPrompt(course);
            System.out.printf("%sCurrent mark: %d\n", INDENT1, student.getMark(assignment));
            int mark = intPrompt(INDENT1 + "New mark: ",
                                "Invalid input! Please try again.", 0, 100);
            student.setMark(assignment, mark);
            System.out.printf("Set assignment %d mark for %s %s to: %d\n\n", 
                assignment, student.getId(), student.getName(), mark);
        }
    }

    static void editAllMarksForStudent(Course course) {
        System.out.print("Enter student name or ID: ");
        Student student = course.getStudent(s.nextLine());
        if (student != null) {
            System.out.printf("EDIT ALL MARKS FOR STUDENT %s %s:\n", student.getId(), student.getName());
            for (int i = 0; i < student.getMarks().size(); i++) {
                System.out.println(INDENT1 + "Assignment " + i + ":");
                System.out.println(INDENT2 + "Current Mark: " + student.getMark(i));
                student.setMark(i, intPrompt(INDENT2 + "New Mark: ",
                                INDENT2 + "Invalid input! Please enter an integer mark between 0 and 100.",
                                0, 100));
            }
        }
    }

    static void editAllMarksForAssignment(Course course) {
        int assignment = assignmentPrompt(course);
        System.out.print("EDIT ALL MARKS FOR ASSIGNMENT " + assignment + ":\n");
        for (Student student : course.getStudents()) {
            System.out.println(INDENT1 + student.getId() + " " + student.getName() + ":");
            System.out.println(INDENT2 + "Current Mark: " + student.getMark(assignment));
            student.setMark(assignment, intPrompt(INDENT2 + "New Mark: ",
                            INDENT2 + "Invalid input! Please enter an integer mark between 0 and 100.",
                            0, 100));
        }
    }

    public static void sectionListMarks(Course course) throws InterruptedException {
        boolean exit = false;
        while (!exit) {
            System.out.println("---- LIST MARKS ----");
            System.out.println("1: List Marks for an Assignment");
            System.out.println("2: List Marks for all Assignments");
            System.out.println("3: List Marks for a Student");
            System.out.println("4: List Marks for all Students");
            System.out.println("---------------------");
            System.out.println("0: GO BACK TO <MARKS>");

            int command = intPrompt("\n> ",
                                    "Invalid command! Please enter a command between 0 and 4.",
                                    0, 4);

            switch (command) {
                case 0:
                    System.out.println("GOING BACK TO <MARKS>...\n");
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
            TimeUnit.SECONDS.sleep(1);
        }
    }

    static void printMarksForAssignment(Course course, int assignment) {
        System.out.print("ASSIGNMENT " + assignment + " MARKS:\n");
        for (Student student : course.getStudents()) {
            System.out.printf("%s %s: %d\n", INDENT1 + student.getId(),
                    student.getName(), student.getMark(assignment));
        }
        System.out.println();
    }

    static void printMarksForAllAssignments(Course course) {
        for (int i = 0; i < course.getStudents().get(0).getMarks().size(); i++) {
            printMarksForAssignment(course, i);
        }
    }

    static void printMarksForStudent(Course course) {
        System.out.print("Enter student name or ID: ");
        Student student = course.getStudent(s.nextLine());
        if (student != null) {
            System.out.println();
            student.printAllMarks();
        }
    }

    static void printMarksForAllStudents(Course course) {
        for (Student student1 : course.getStudents()) {
            student1.printAllMarks();
        }
    }

    public static void sectionViewAverages(Course course) throws InterruptedException {
        boolean exit = false;
        while (!exit) {
            System.out.println("--- VIEW AVERAGES ---");
            System.out.println("1: View Average for Course");
            System.out.println("2: View Average for a Student");
            System.out.println("3: View Average for all Students");
            System.out.println("4: View Average for an Assignment");
            System.out.println("5: View Average for all Assignments");
            System.out.println("---------------------");
            System.out.println("0: GO BACK TO <MARKS>");

            int command = intPrompt("\n> ",
                            "Invalid command! Please enter a command between 0 and 5.",
                            0, 5);

            switch (command) {
                case 0:
                    System.out.println("GOING BACK TO <MARKS>...\n");
                    exit = true;
                    break;
                case 1:
                    printAverageForCourse(course);
                    break;
                case 2:
                    System.out.print("Enter student name or ID: ");
                    Student student = course.getStudent(s.nextLine());
                    if (student != null) {
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
            TimeUnit.SECONDS.sleep(1);
        }
    }

    static void printAverageForCourse(Course course) {
        System.out.printf("%s COURSE AVERAGE: %.1f\n\n", course.getCode(),
                course.courseAverage());
    }

    static void printAverageForStudent(Course course, Student student) {
        System.out.printf("%s %s Average: %.1f\n", INDENT1 + student.getId(),
                    student.getName(), student.average());
    }

    static void printAverageForAllStudents(Course course) {
        System.out.print(course.getCode() + " STUDENT AVERAGES:\n");
        for (Student student : course.getStudents()) {
            printAverageForStudent(course, student);
        }
        System.out.println();
    }

    static void printAverageForAssignment(Course course) {
        int assignment = assignmentPrompt(course);
        System.out.printf("ASSIGNMENT %d AVERAGE: %.1f\n\n", assignment,
                            course.assignmentAverage(assignment));
    }

    static void printAverageForAllAssignments(Course course) {
        System.out.print(course.getCode() + " ASSIGNMENT AVERAGES\n");
        for (int i = 0; i < course.getStudents().get(0).getMarks().size(); i++) {
            System.out.printf("%sAssignment %d: %.1f\n", INDENT1, i,
                    course.assignmentAverage(i));
        }
        System.out.println();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        printStartUp();
        Student a = new Student("Mario S", "01");
        Student b = new Student("Petey C", "02");
        Student c = new Student("Anna S", "03");
        Student d = new Student("Paul M", "04");
        Student e = new Student("Anna M", "05");
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(a);
        students.add(b);
        students.add(c);
        students.add(d);
        students.add(e);
        Course ics = new Course("Intro to CS", "ICS4U", students);
        ics.addAssignment();
        ics.addAssignment();
        a.setMark(0, 0);
        b.setMark(0, 0);
        c.setMark(0, 0);
        d.setMark(0, 0);
        e.setMark(0, 0);
        a.setMark(1, 1);
        b.setMark(1, 1);
        c.setMark(1, 1);
        d.setMark(1, 1);
        e.setMark(1, 1);
        sectionMenu(ics);
    }

}
