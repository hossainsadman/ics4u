package hossain_sadman_gradebook;

import java.util.ArrayList;

/**
 *
 * @author Sadman
 */
public class Student {

    private String name;
    private int id;
    private ArrayList<Integer> marks;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        marks = new ArrayList<Integer>();
    }

    public Student(String name, int id, ArrayList<Integer> marks) {
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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
        for (int mark : marks) {
            average += mark;
        }
        return average;
    }

    public void printAllMarks() {
        String str = "MARKS FOR STUDENT: " + name + "\n";
        for (int i = 1; i < marks.size(); i++) {
            str += "  Assignment " + i + ": " + getMark(i) + "\n";
        }
        System.out.println(str);
    }

    @Override
    public String toString() {
        return (String) name + id;
    }
}
