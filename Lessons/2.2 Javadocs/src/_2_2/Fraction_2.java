package _2_2;

// Go back to the Fraction Class that we developed in lesson 2.1. Write the full
// Javadoc comments for the class and all methods.

/**
 * A class that defines rational numbers, p/q, where p and q are integers.
 * Operations that are possible include: addition, subtraction, multiplication,
 * division, reducing, reciprocal, comparison, and shortcut addition (+=) and
 * multiplication (*=).
 *
 * @author Sadman
 */
public class Fraction_2 {

    private int numerator;
    private int denominator;

    /**
     * Constructs a Fraction object
     *
     * @param numerator   numerator of fraction
     * @param denominator denominator of fraction
     */
    public Fraction_2(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Get the numerator of the fraction
     *
     * @return numerator of fraction
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Set the numerator of the fraction
     *
     * @param numerator numerator of fraction
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    /**
     * Return the fraction as a double
     *
     * @return fraction as a double
     */
    public double toDouble() {
        return (double) numerator / denominator;
    }

    /**
     * Format the fraction as a string
     *
     * @return fraction as a string
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Determine whether this fraction is greater than another fraction
     *
     * @param other another fraction that this fraction is being compared to
     *
     * @return whether this fraction is greater than another fraction
     */
    public boolean greaterThan(Fraction_2 other) {
        return toDouble() > other.toDouble();
    }

    // public boolean equals(Fraction_2 other) {
    // return numerator == other.numerator && denominator == other.denominator;
    // }
    
    // 2.1 LESSON EXERCISES
    // 1. Write the accessor (getter) and mutator (setter) methods for the 
    // denominator field.
    
    /**
     * Get the denominator of the fraction
     *
     * @return denominator of the fraction
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Set the denominator of the fraction
     *
     * @param denominator denominator of the fraction
     */
    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    // 2. Write a mutator (setter) method that modifies both the numerator and 
    // denominator fields at once.
    
    /**
     * Set the numerator and denominator of the fraction
     *
     * @param numerator   numerator of the fraction
     * @param denominator denominator of the fraction
     */
    public void setNumerAndDenom(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // 3. Complete the instance method
    
    //    public Fraction_2 multiply(Fraction_2 other) { … }
    
    // which returns a Fraction_2 object that is the product of the implicit 
    // object parameter and the explicit parameter other.
    
    /**
     * Multiply the fraction with another fraction
     *
     * @param other another fraction
     *
     * @return product of the 2 fractions as a Fraction object
     */
    public Fraction_2 multiply(Fraction_2 other) {
        return new Fraction_2(numerator * other.numerator,
                denominator * other.denominator);
    }

    // 4. Complete the instance method
    
    //    public Fraction_2 add(Fraction_2 other) { … }
    
    // which returns a Fraction_2 object whose value is the sum of the implicit 
    // object parameter and the explicit parameter other. The method should 
    // leave both its explicit and implicit parameters unchanged. (Don't worry 
    // about the lowest common denominator for now.)
    
    /**
     * Add another fraction to the fraction
     *
     * @param other another fraction
     *
     * @return sum of the 2 fractions
     */
    public Fraction_2 add(Fraction_2 other) {
        return new Fraction_2(numerator * other.denominator + other.numerator * denominator,
                denominator * other.denominator);
    }

    // 5. Write another constructor (called overloading) 
    
    //    public Fraction_2(Fraction_2 other) { … } 
    
    // which is a copy of other.
    
    /**
     * Construct a fraction with the same values as another fraction
     *
     * @param other another fraction
     */
    public Fraction_2(Fraction_2 other) {
        this.numerator = other.numerator;
        this.denominator = other.denominator;
    }

    // 7. Modify the equals method such that two Fraction_2 objects are considered
    // equal if and only if the fractions are equivalent
    
    /**
     * Determine whether the fraction equals another fraction
     *
     * @param other another fraction
     *
     * @return boolean of whether the fraction equals another fraction
     */
    public boolean equals(Fraction_2 other) {
        if (numerator == other.numerator && denominator == other.denominator) {
            return true;
        }
        if (((double) denominator / other.denominator) * other.numerator == numerator) {
            return true;
        }
        return false;
    }

    // 8. Create a static class that multiplies 2 fractions
    
    /**
     * Multiply 2 fractions
     *
     * @param f1 first fraction
     * @param f2 second fraction
     *
     * @return product of the 2 fractions
     */
    public static Fraction_2 product(Fraction_2 f1, Fraction_2 f2) {
        return f1.multiply(f2);
    }

}
