package _0_3;

/**
 *
 * @author Sadman
 */
public class Math_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(doubleInt(2));
        System.out.println(average(1, 2, 3));
        printTriangle(3);
        System.out.println(circumference(0.5));
    }

    // 1. For these questions, make sure you follow conventions for naming.

    // a) Write a method that takes an int as parameter and doubles it. Return
    // the value.
    private static int doubleInt(int n) {
        return n*2;
    }

    // b) Write a method that takes three double values and returns the average.
    private static double average(double d1, double d2, double d3) {
        return (d1+d2+d3)/3;
    }

    // c) Write a method that takes an int parameter n and prints a triangle of
    // asterisks starting from 1 to n. Sample output if n = 5:
    // *
    // **
    // ***
    // ****
    // *****
    private static void printTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("*".repeat(n));
        }
    }

    // d) Write a method to return the circumference of a circle given the
    // radius as parameter. Use Math.PI to get 𝜋.
    private static double circumference(double radius) {
        return 2*Math.PI*radius;
    }
}
