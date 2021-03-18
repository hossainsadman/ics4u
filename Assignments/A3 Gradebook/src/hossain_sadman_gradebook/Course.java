package hossain_sadman_gradebook;

import java.util.ArrayList;

/**
 *
 * @author Sadman
 */
public class Course {

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
            if (student.getName().equals(nameOrId) || student.getId().equals(nameOrId)) {
                return student;
            }
        }
        System.out.println("Student not found!\n");
        return null;
    }

    public void addStudent(String name, String id) {
        ArrayList<Integer> marks = new ArrayList<Integer>();
        for (int i = 0; i < students.get(0).getMarks().size(); i++) {
            marks.add(-1);
        }
        students.add(students.size(), new Student(name, id, marks));
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
        addAssignment();
        Student student = getStudent(nameOrId);
        student.setMark(student.getMarks().size() - 1, mark);
    }

    public void setMark(String nameOrId, int assignment, int mark) {
        getStudent(nameOrId).setMark(assignment, mark);
    }

    public void addAssignment() {
        for (Student student : students) {
            student.getMarks().add(-1);
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

    public double assignmentAverage(int assignment) {
        double average = 0;
        for (Student student : students) {
            average += student.getMark(assignment);
        }
        average /= students.size();
        return average;
    }
}
