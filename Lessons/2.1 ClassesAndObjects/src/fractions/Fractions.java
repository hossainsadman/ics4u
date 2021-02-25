package fractions;

/**
 *
 * @author Sadman
 */
public class Fractions {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // CODE USED FOR LESSON
        Fraction f = new Fraction(1,2);
        
        System.out.println(f.getNumerator());
        f.setNumerator(3);
        System.out.println(f.getNumerator());
        
        // outputs the same string because toString() was overrided
        System.out.println("f: " + f);
        System.out.println(f.toString());
        
        double decimal = f.toDouble();
        System.out.println(decimal);
        
        Fraction f2 = new Fraction(1,4);
        boolean greater = f.greaterThan(f2);
        System.out.println(greater);
        
        // CODE FOR TESTING EXERCISE SOLUTIONS
        
        // 3. multiply method
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(3, 8);
        System.out.println(a.toString() + "*" + b.toString() + "= " + a.multiply(b).toString());
        
        // 7. equals method
        Fraction frac2 = new Fraction(-3,10);
        Fraction frac1 = new Fraction(30000,-100000);
        System.out.println(frac1.equals(frac2));
        
        // 8. product method
        Fraction frac3 = Fraction.product(frac1, frac2);
        System.out.println(frac3);
    }
}
