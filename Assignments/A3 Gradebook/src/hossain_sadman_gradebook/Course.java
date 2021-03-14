package hossain_sadman_gradebook;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class Course {

    private Scanner s = new Scanner(System.in);

    private String name;
    private String code;
    private ArrayList<Student> students;

    public Course(String name, String code) {
        this.name = name;
        this.code = code;
        students = new ArrayList<Student>();
    }

    public Course(String name, String code, ArrayList<Student> students) {
        this.name = name;
        this.code = code;
        this.students = students;
    }

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ArrayList<Student> getStudents() {
		return this.students;
	}

    public Student getStudent(Student student) {
        if (students.contains(student)) {
            return student;
        } else {
            System.out.println("Student not found!");
            return null;
        }
    }

    public Student getStudent(String nameOrId) {
        for (Student student : students) {
            if (student.getName().equals(nameOrId)) {
                return student;
            }
        }
        System.out.println("Student not found!");
        return null;
    }

    public void addStudent(Student student) {
        students.add(students.size() - 1, student);
    }

    public void removeStudent(String nameOrId) {
        students.remove(getStudent(nameOrId));
    }

    public void setStudentName(String oldName, String newName) {
        getStudent(oldName).setName(newName);
    }

    public void setStudentId(String oldId, String newId) {
        getStudent(oldId).setName(newId);
    }

    public void addMark(String nameOrId, int mark) {
        getStudent(nameOrId).addMark(mark);
    }

    public void setMark(String nameOrId, int assignment, int mark) {
        getStudent(nameOrId).setMark(assignment, mark);
    }

    private int inputPrompt(String prompt, String errorMsg, int lower, int upper) {
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

    public void setAllMarks(int assignment) {
        System.out.println("EDIT ALL MARKS FOR ASSIGNMENT " + assignment + ":");
        for (Student student : students) {
            System.out.println("  Name: " + student.getName() + "; ID: " + student.getId());
            System.out.println("    Current Mark: " + student.getMark(assignment));
            student.setMark(assignment, inputPrompt("    New Mark: ", "Invalid input! Please enter a mark between 0 and 100.", 0, 100));
            System.out.println();
        }
    }

    public void addAssignment() {
        for (Student student : students) {
            student.getMarks().add(0);
        }
    }

    public void deleteAssignment(int assignment) {
        for (Student student : students) {
            student.getMarks().remove(assignment);
        }
    }

    public double courseAverage() {
        double average = 0;
        for (Student student : students) {
            average += student.average();
        }
        average /= students.size();
        return average;
    }

    public void printCourseAverage() {
        System.out.printf("\n%s COURSE AVERAGE: %.1f", code, courseAverage());
    }

    public double assignmentAverage(int assignment) {
        double average = 0;
        for (Student student : students) {
            average += student.getMark(assignment);
        }
        average /= students.size();
        return average;
    }

    public void printAssignmentAverage(int assignment) {
        System.out.printf("\nASSIGNMENT %d AVERAGE: %.1f", assignment, assignmentAverage(assignment));
    }

    public void printAllAssignmentAverages() {
        System.out.println(code + " ASSIGNMENT AVERAGES");
        for (int i = 0; i < students.get(0).getMarks().size(); i++) {
            System.out.printf("Assignment %d: %.1f", i, assignmentAverage(i));
        }
    }

    public void printAssignmentMarks(int assignment) {
        System.out.println("ASSIGNMENT " + assignment + " MARKS:");
        for (Student student : students) {
            System.out.println("  " + student.getName() + ": " + student.getMark(assignment));
        }
    }

    public void printStudentAverages() {
        System.out.println(code + " STUDENT AVERAGES:");
        for (Student student : students) {
            System.out.printf("  %s %s: %.1f\n", student.getId(), student.getName(), student.average());
        }
    }
}
