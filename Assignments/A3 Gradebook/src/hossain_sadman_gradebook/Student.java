package hossain_sadman_gradebook;

import static hossain_sadman_gradebook.Gradebook.INDENT1;

import java.util.ArrayList;

/**
 *
 * @author Sadman
 */
public class Student {

    private String name;
    private String id;
    private ArrayList<Integer> marks;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        marks = new ArrayList<Integer>();
    }

    public Student(String name, String id, ArrayList<Integer> marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Integer> getMarks() {
		return this.marks;
	}

	public void setMarks(ArrayList<Integer> marks) {
		this.marks = marks;
	}

    public int getMark(int assignment) {
        return this.marks.get(assignment);
    }

    public void addMark(int mark) {
        this.marks.add(mark);
    }

    public void setMark(int assignment, int mark) {
        this.marks.set(assignment, mark);
    }

    public double average() {
        double average = 0;
        int numMarks = 0;
        for (int mark : marks) {
            if (mark != -1) {
                average += mark;
                numMarks++;
            }
        }
        average /= numMarks;
        return average;
    }

    public void printAllMarks() {
        System.out.printf("MARKS FOR STUDENT: %s %s\n", id, name);
        for (int i = 0; i < marks.size(); i++) {
            System.out.printf("%sAssignment %d: %d\n", INDENT1, i, getMark(i));
        }
        System.out.println();
    }
}
