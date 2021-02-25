package _2_1;

/**
 *
 * @author Sadman
 */
class Fraction2 extends Fraction {

    // Continue the Fraction class that we have created. Make sure that it is
    // complete up to the end of Lesson 2.1

	public Fraction2(Fraction fraction) {
		super(fraction);
	}

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


    // b)   public void plusEquals(Fraction other)
    // Same as above, but for +=.

    // c)   public void integerMultiply(int k)
    // This method should multiply the fraction by the specified integer, eg.
    // 42383

    // d)   public void reduce()
    // This method reduces the implicit object Fraction to its lowest terms. It
    // also changes the signs of the numerator and denominator as follows: if
    // the fraction is negative, ensures only the numerator is negative, rather
    // than the denominator; if both numerator and denominator are negative,
    // they are both made positive, eg. 2/8 to 1/4

    // Modify all existing methods and write future methods to utilize the
    // reduce method after any operations and before returning, as necessary.

    // e)   public Fraction reciprocal()
    // This method returns the reciprocal of the implicit object.


    // f)   public Fraction divide(Fraction other)
    // This method returns the implicit Fraction object divided by the other
    // Fraction.

    // 2. Class Methods - Create class (static) methods sum, difference, and quotient. They should take two Fraction objects f1 and f2 as parameters, perform each operation and return a Fraction in lowest terms. (Hint: utilize existing methods)

    // 3. Overloaded Constructors - Add the following constructors to the
    //    Fraction class:

    // - A constructor that takes a double number as parameter and constructs
    //   the corresponding rational number, eg., 0.98 is 4950, -8.343 is
    //   -83431000.


    // - A constructor that takes a single int value as parameter, and so
    //   assigns that to the numerator and the denominator to 1.


    // - A constructor that takes no parameter and so initialises the fraction
    //   to 1.


    // 4. Printing - Modify the toString method to print zero fractions as
    //    simply 0 and fractions with a denominator of 1 as an integer.
}

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
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    // overriding Object.toString() method
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public boolean greaterThan(Fraction other) {
        return toDouble() > other.toDouble();
    }

//    public boolean equals(Fraction other) {
//        return numerator == other.numerator && denominator == other.denominator;
//    }


    // 2.1 LESSON EXERCISES

    // 1. Write the accessor (getter) and mutator (setter) methods for the
    // denominator field.

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    // 2. Write a mutator (setter) method that modifies both the numerator and
    // denominator fields at once.

    public void setNumerAndDenom(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // 3. Complete the instance method

    //    public Fraction multiply(Fraction other) { … }

    // which returns a Fraction object that is the product of the implicit
    // object parameter and the explicit parameter other.

    public Fraction multiply(Fraction other) {
        return new Fraction(numerator*other.numerator,
                denominator*other.denominator);
    }

    // 4. Complete the instance method

    //    public Fraction add(Fraction other) { … }

    // which returns a Fraction object whose value is the sum of the implicit
    // object parameter and the explicit parameter other. The method should
    // leave both its explicit and implicit parameters unchanged. (Don't worry
    // about the lowest common denominator for now.)

    public Fraction add(Fraction other) {
        return new Fraction(numerator*other.denominator + other.numerator*denominator,
                denominator*other.denominator);
    }

    // 5. Write another constructor (called overloading)

    //    public Fraction(Fraction other) { … }

    // which is a copy of other.

    public Fraction(Fraction other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
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

}
