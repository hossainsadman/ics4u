package fractions;

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
