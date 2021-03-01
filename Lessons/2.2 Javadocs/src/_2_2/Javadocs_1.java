package _2_2;

/**
 *
 * @author Sadman
 */
public class Javadocs_1 {

    // Javadoc Comments are special comments used in Java for generating 
    // documentation, and usually precede the code of a class or a method.
    
    // 1. Copy and paste each method into a project class called JavadocPractice. 
    // Then write the Javadoc comments for each.
    
    /**
     * Calculate the area of a circle
     *
     * @param r the radius of the circle
     * @return the area of the circle
     */
    public static double areaCircle(double r) {
        double area = Math.PI * r * r;
        return area;
    }

    /**
     * Calculate the square of a number
     *
     * @param num the number to be squared
     * @return the number squared
     */
    public static double sqrNum(double num) {
        double result = num * num;
        return result;
    }

    /**
     * Calculate the sum of 2 numbers
     *
     * @param num1 first number to be summed
     * @param num2 second number to be summed
     * @return sum of the first and second numbers
     */
    public static int add2Nums(int num1, int num2) {
        int total = num1 + num2;
        return total;
    }

    /**
     * Calculate the average of 2 marks
     *
     * @param m1 the first mark
     * @param m2 the second mark
     * @return average of the 2 marks
     */
    public static double avg2Marks(int m1, int m2) {
        int total = m1 + m2;
        double avg = (double) total / 2;
        return avg;
    }

    /**
     * Determine whether a mark is enough to pass the course
     *
     * @param num the mark
     * @return whether the mark is greater than or equal to 50
     */
    public static boolean isPass(float num) {
        if (num >= 50) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Print "senior", "adult", "young", or "invalid age" based on the inputted
     * age
     *
     * @param age age of the student
     * @return None
     */
    public static String ageMessage(int age) {
        if (age > 65) {
            return "senior";
        } else if (age > 19) {
            return "adult";
        } else if (age > 0) {
            return "young";
        } else {
            return "invalid age";
        }
    }

    /**
     * Calculate the total cost of items
     *
     * @param costPerUnit cost per unit
     * @param quantity quantity of the items
     * @return total cost of the items
     */
    public static double totalCost(double costPerUnit, int quantity) {
        double result = costPerUnit * quantity;
        return result;
    }

    /**
     * Calculate the total cost of items including tax
     *
     * @param subTotal subtotal cost of the items
     * @return total cost of items including tax
     */
    public static double taxTotal(double subTotal) {
        double result = subTotal * 1.13;
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }

}
