import java.util.ArrayList;
import java.util.Collections;

// package comparable;

/**
 *
 * @author Sadman
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person p = new Person("Alan", 42);
        Person q = new Person("Linus", 38);
        Person r = new Person("Monty", 62);
        ArrayList<Person> ppl = new ArrayList<>();
        ppl.add(r);
        ppl.add(q);
        ppl.add(p);
        System.out.println(ppl);
        Collections.sort(ppl);
        System.out.print("sorted: ");
        System.out.println(ppl);
    }
}
