package hossain_sadman_gradebook;

import java.util.ArrayList;

/**
 * Represents a course, with a name, course code, and list of students who are
 * enrolled in it.
 * @author Sadman
 */
public class Course {

    // name and course code of the course
    private String name;
    private String code;
    // list of students enrolled in the course
    private ArrayList<Student> students;

    /**
     * Instantiates a course object with the given name and code; initializes its
     * list of students with an empty list.
     * @param name course name
     * @param code course code
     */
    public Course(String name, String code) {
        this.name = name;
        this.code = code;
        students = new ArrayList<>();
    }

    /**
     * Instantiates a course object with the given name, code, and list of
     * students.
     * @param name course name
     * @param code course code
     * @param students list of students in the course
     */
    public Course(String name, String code, ArrayList<Student> students) {
        this.name = name;
        this.code = code;
        this.students = students;
    }

    /**
     * Return the course name.
     * @return course name
     */
	String getName() {
		return this.name;
	}

    /**
     * Set the course name.
     * @param name new name for course
     */
	void setName(String name) {
		this.name = name;
	}

    /**
     * Return the course code.
     * @return course code
     */
	String getCode() {
		return this.code;
	}

    /**
     * Set the course code.
     * @param code new code for course
     */
	void setCode(String code) {
		this.code = code;
	}

    /**
     * Return the list of students in the course.
     * @return list of students
     */
	ArrayList<Student> getStudents() {
		return this.students;
	}

    /**
     * Return a student if it is in the course based on the student object;
     * return null if it is not found.
     * @param student student object being searched for
     * @return corresponding student object in the course (null if not found)
     */
    Student getStudent(Student student) {
        if (students.contains(student)) {
            return student;
        } else {
            System.out.println("Student not found!\n");
            return null;
        }
    }

    /**
     * Return a student if it is in the course based on the student's name or
     * id; return null if it is not found.
     * @param nameOrId name or id of the student being searched for
     * @return corresponding student object in the course (null if not found)
     */
    Student getStudent(String nameOrId) {
        for (Student student : students) {
            if (student.getName().equals(nameOrId) || student.getId().equals(nameOrId)) {
                return student;
            }
        }
        System.out.println("Student not found!\n");
        return null;
    }

    /**
     * Add a student to the course using a given name and id.
     * @param name name of student to be added
     * @param id id of student to be added
     */
    void addStudent(String name, String id) {
        ArrayList<Integer> marks = new ArrayList<>();
        for (int i = 0; i < numAssignments(); i++) {
            marks.add(-1);
        }
        students.add(students.size(), new Student(name, id, marks));
    }

    /**
     * Remove a student in the course (if it is found).
     * @param nameOrId name or id of student
     */
    void removeStudent(String nameOrId) {
        students.remove(getStudent(nameOrId));
    }

    /**
     * Add a mark to a student (assigns a placeholder mark of -1 for that mark
     * for all other students).
     * @param nameOrId name or id of student
     * @param mark mark to be added
     */
    void addMark(String nameOrId, int mark) {
        addAssignment();
        Student student = getStudent(nameOrId);
        student.setMark(student.getMarks().size() - 1, mark);
    }

    /**
     * Set a student's mark for an assignment.
     * @param nameOrId name or id of student
     * @param assignment number of assignment
     * @param mark new mark for that assignment
     */
    public void setMark(String nameOrId, int assignment, int mark) {
        getStudent(nameOrId).setMark(assignment, mark);
    }

    /**
     * Add an assignment for the course (adds a placeholder mark of -1 to each
     * student's list of marks).
     */
    void addAssignment() {
        for (Student student : students) {
            student.getMarks().add(-1);
        }
    }

    /**
     * Delete an assignment for the course (removes the mark for the specified
     * assignment in each student's list of marks).
     * @param assignment number of assignment
     */
    void deleteAssignment(int assignment) {
        for (Student student : students) {
            student.getMarks().remove(assignment);
        }
    }

    /**
     * Return the number of assignments in the course.
     * @return number of assignments
     */
    int numAssignments() {
        // get the number of marks assigned to the first student in the course
        // (acceptable because all students have the same number of
        // assignments)
        return students.get(0).getMarks().size();
    }

    /**
     * Return the average for the course.
     * @return course average
     */
    double courseAverage() {
        double average = 0;
        for (Student student : students) {
            average += student.average();
        }
        average /= students.size();
        return average;
    }

    /**
     * Return the average for an assignment.
     * @param assignment number of assignment
     * @return average for that assignment
     */
    double assignmentAverage(int assignment) {
        double average = 0;
        for (Student student : students) {
            average += student.getMark(assignment);
        }
        average /= students.size();
        return average;
    }
}
