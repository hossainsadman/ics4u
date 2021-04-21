package _5_1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sadman
 */
public class Person_1 implements Comparable<Person_1>{

    private String name;
    private int age;

    public Person_1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // sort by age
    @Override
    public int compareTo(Person_1 p) {
        return this.age - p.age;
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

class Sort {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person_1 p = new Person_1("Alan", 42);
        Person_1 q = new Person_1("Linus", 38);
        Person_1 r = new Person_1("Monty", 62);
        ArrayList<Person_1> ppl = new ArrayList<>();
        ppl.add(r);
        ppl.add(q);
        ppl.add(p);
        System.out.println(ppl);
        Collections.sort(ppl);
        System.out.print("sorted: ");
        System.out.println(ppl);
    }
}