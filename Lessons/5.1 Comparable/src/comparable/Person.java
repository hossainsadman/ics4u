// package comparable;

/**
 *
 * @author Sadman
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // sort by age
    @Override
    public int compareTo(Person p) {
        return this.age - p.age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}