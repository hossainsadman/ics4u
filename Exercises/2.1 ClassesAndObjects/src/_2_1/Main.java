package _2_1;

/**
 *
 * @author Sadman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // 1. d) reduce
        // Fraction f1 = new Fraction(123,45678);
        // f1.reduce();
        // System.out.println(f1.toString());

        // 1. e) reciprocal
        Fraction f2 = new Fraction(2,-1);
        System.out.println(f2.reciprocal().toString());
    }
}
