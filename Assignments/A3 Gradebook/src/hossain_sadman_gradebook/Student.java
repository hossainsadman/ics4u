package hossain_sadman_gradebook;

import static hossain_sadman_gradebook.Gradebook.INDENT1;
import java.util.ArrayList;

/**
 * Represents a student, with a name, id, and a list of marks for each assignment
 * in a course.
 * @author Sadman
 */
public class Student {

    // name and id of the student
    private String name;
    private String id;
    // list of marks corresponding to each assignment
    private ArrayList<Integer> marks;

    /**
     * Instantiates a student object with the given name and id; its list of marks.
     * is initialized as an empty list
     * @param name student name
     * @param id student id
     */
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        marks = new ArrayList<>();
    }

    /**
     * Instantiates a student object with the given name, id, and list of marks.
     * @param name student name
     * @param id student id
     * @param marks list of marks
     */
    public Student(String name, String id, ArrayList<Integer> marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    /**
     * Returns the student's name.
     * @return student name
     */
	String getName() {
		return this.name;
	}

    /**
     * Set the student's name.
     * @param name new name of student
     */
	void setName(String name) {
		this.name = name;
	}

    /**
     * Returns the student's id.
     * @return student id
     */
	String getId() {
		return this.id;
	}

    /**
     * Set the student's id.
     * @param id new id of student
     */
	void setId(String id) {
		this.id = id;
	}

    /**
     * Return the student's list of marks.
     * @return list of marks
     */
	ArrayList<Integer> getMarks() {
		return this.marks;
	}

    /**
     * Set the student's list of marks.
     * @param marks
     */
	void setMarks(ArrayList<Integer> marks) {
		this.marks = marks;
	}

    /**
     * Return the student's mark on a specific assignment .
     * @param assignment number of the assignment
     * @return the student's mark on that assignment
     */
    int getMark(int assignment) {
        return this.marks.get(assignment);
    }

    /**
     * Add a mark to the student's list of marks.
     * @param mark mark to be added
     */
    void addMark(int mark) {
        this.marks.add(mark);
    }

    /**
     * Set the student's mark on a specific assignment.
     * @param assignment number of the assignment
     * @param mark new mark for the assignment
     */
    void setMark(int assignment, int mark) {
        this.marks.set(assignment, mark);
    }

    /**
     * Return the average of the student's marks. Note: this does not take the '-1'
     * placeholder mark for new assignments into consideration when calculating
     * the student's average.
     * @return average as a double
     */
    double average() {
        double average = 0;
        int numMarks = 0;

        for (int mark : marks) {
            // only calculate average for non-placeholder marks (as in, not -1)
            if (mark != -1) {
                average += mark;
                numMarks++;
            }
        }

        average /= numMarks;
        return average;
    }

    /**
     * Print the student's marks for each assignment.
     */
    void printAllMarks() {
        System.out.printf("MARKS FOR STUDENT: %s %s\n", id, name);

        for (int i = 0; i < marks.size(); i++) {
            System.out.printf("%sAssignment %d: %d\n", INDENT1, i, getMark(i));
        }

        System.out.println();
    }
}
