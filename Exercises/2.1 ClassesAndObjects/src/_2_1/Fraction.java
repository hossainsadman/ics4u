package _2_1;

/**
 *
 * @author Sadman
 */
public class Fraction {

    // Lesson 2.1: Classes and Objects Introduction
    // CLASS BUILT FOR LESSON

    // fields/variables
    private int numerator;
    private int denominator;

    // constructor
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        reduce();
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    // overriding Object.toString() method
    // @Override
    // public String toString() {
    //     return numerator + "/" + denominator;
    // }

    public boolean greaterThan(Fraction other) {
        return toDouble() > other.toDouble();
    }

    // 2.1 LESSON EXERCISES

    // 1. Write the accessor (getter) and mutator (setter) methods for the
    // denominator field.

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
        reduce();
    }

    // 2. Write a mutator (setter) method that modifies both the numerator and
    // denominator fields at once.

    public void setNumerAndDenom(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    // 3. Complete the instance method

    //    public Fraction multiply(Fraction other) { … }

    // which returns a Fraction object that is the product of the implicit
    // object parameter and the explicit parameter other.

    public Fraction multiply(Fraction other) {
        Fraction f = new Fraction(numerator*other.numerator,
                denominator*other.denominator);
        f.reduce();
        return f;
    }

    // 4. Complete the instance method

    //    public Fraction add(Fraction other) { … }

    // which returns a Fraction object whose value is the sum of the implicit
    // object parameter and the explicit parameter other. The method should
    // leave both its explicit and implicit parameters unchanged. (Don't worry
    // about the lowest common denominator for now.)

    public Fraction add(Fraction other) {
        Fraction f = new Fraction(numerator*other.denominator + other.numerator*denominator,
                denominator*other.denominator);
        f.reduce();
        return f;
    }

    // 5. Write another constructor (called overloading)

    //    public Fraction(Fraction other) { … }

    // which is a copy of other.

    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
        reduce();
    }

    // 7. Modify the equals method such that two Fraction objects are considered
    // equal if and only if the fractions are equivalent

    public boolean equals(Fraction other) {
        if (numerator == other.numerator && denominator == other.denominator) {
            return true;
        }
        if (((double) denominator / other.denominator) * other.numerator == numerator) {
            return true;
        }
        return false;
    }

    // 8. Create a static class that multiplies 2 fractions

    public static Fraction product(Fraction f1, Fraction f2) {
        return f1.multiply(f2);
    }

    // --------------------------- 2.1 EXERCISES ---------------------------

    // Continue the Fraction class that we have created. Make sure that it is
    // complete up to the end of Lesson 2.1

    // 1. Instance Methods - Complete the definitions of the following instance
    //    methods for the Fraction class.

    // a)   public void timesEquals(Fraction other)
    // This method should have the same effect (for Fraction objects) that the
    // *= operator has for primitive numeric types. Thus, if called by the
    // statement
    //      p.timesEquals(q);
    // (where p and q are objects of type Fraction), the method would make
    // p represent the product of the fractions currently represented by p
    // and q while the value of q would be left unchanged.

    public void timesEquals(Fraction other) {
        numerator *= other.numerator;
        denominator *= other.denominator;
        reduce();
    }

    // b)   public void plusEquals(Fraction other)
    // Same as above, but for +=.

    public void plusEquals(Fraction other) {
        if (denominator == other.denominator) {
            numerator += other.denominator;
        } else {
            numerator = numerator*other.denominator + other.numerator*denominator;
            denominator *= other.denominator;
        }
        reduce();
    }

    // c)   public void integerMultiply(int k)
    // This method should multiply the fraction by the specified integer, eg.
    // 42383

    public void integerMultiply(int k) {
        numerator *= k;
        reduce();
    }

    // d)   public void reduce()
    // This method reduces the implicit object Fraction to its lowest terms. It
    // also changes the signs of the numerator and denominator as follows: if
    // the fraction is negative, ensures only the numerator is negative, rather
    // than the denominator; if both numerator and denominator are negative,
    // they are both made positive, eg. 2/8 to 1/4

    // Modify all existing methods and write future methods to utilize the
    // reduce method after any operations and before returning, as necessary.

    // GCD method is based on Euclid's algorithm
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public void reduce() {
        int gcd = gcd(numerator, denominator);
        if (gcd != 0 && gcd != 1) {
            numerator /= gcd;
            denominator /= gcd;
        }

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    // e)   public Fraction reciprocal()
    // This method returns the reciprocal of the implicit object.

    public Fraction reciprocal() {
        Fraction reciprocal = new Fraction(denominator, numerator);
        reciprocal.reduce();
        return reciprocal;
    }

    // f)   public Fraction divide(Fraction other)
    // This method returns the implicit Fraction object divided by the other
    // Fraction.

    public Fraction divide(Fraction other) {
        return multiply(other.reciprocal());
    }

    // 2. Class Methods - Create class (static) methods sum, difference, and
    //    quotient. They should take two Fraction objects f1 and f2 as
    //    parameters, perform each operation and return a Fraction in lowest
    //    terms. (Hint: utilize existing methods)

    public static Fraction sum(Fraction f1, Fraction f2) {
        return f1.add(f2);
    }

    public static Fraction difference(Fraction f1, Fraction f2) {
        f2.numerator *= -1;
        return f1.add(f2);
    }

    public static Fraction quotient(Fraction f1, Fraction f2) {
        return f1.divide(f2);
    }

    // 3. Overloaded Constructors - Add the following constructors to the
    //    Fraction class:

    // a) A constructor that takes a double number as parameter and constructs
    //   the corresponding rational number, eg., 0.98 is 49/50, -8.343 is
    //   -8343/1000.

    public Fraction(double d) {
        // if (d % 1 != 0) {
        // }
        String double_ = Double.toString(d);
        int decimal = double_.indexOf(".");
        int decimalPlaces = double_.length() - decimal - 1;
        numerator = (int) (d * Math.pow(10, decimalPlaces));
        denominator = (int) Math.pow(10, decimalPlaces);
        reduce();
    }

    // b) A constructor that takes a single int value as parameter, and so
    //   assigns that to the numerator and the denominator to 1.

    public Fraction(int i) {
        numerator = i;
        denominator = 1;
    }

    // c) A constructor that takes no parameter and so initialises the fraction
    //   to 1.

    public Fraction() {
        numerator = 1;
        denominator = 1;
    }

    // 4. Printing - Modify the toString method to print zero fractions as
    //    simply 0 and fractions with a denominator of 1 as an integer.

    @Override
    public String toString() {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 1) {
            return "1";
        }
        return numerator + "/" + denominator;
    }

}
