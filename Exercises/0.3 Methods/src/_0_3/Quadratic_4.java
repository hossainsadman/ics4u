package _0_3;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class Quadratic_4 {

    // 4. a) Recall the definition of a quadratic equation is of the form
    // ax2+bx+c=0. Write the following methods:

    // discriminant: accepts three double values a, b, c, and returns the value
    // of the discriminant of the equation, D=b2-4ac
    private static double discriminant(double a, double b, double c) {
        return b*b - 4*a*c;
    }

    // numSolutions: accepts three double values a, b, c, and returns the number
    // of solutions to the equation
    private static int numSolutions(double a, double b, double c) {
        double discriminant = discriminant(a, b, c);
        if (discriminant > 0) {
            return 2;
        } else if (discriminant == 0) {
            return 1;
        }
        return 0;
    }

    // solveEquation: accepts three double values a, b, c, and prints the roots,
    // if any, in a nice statement, rounded to two decimal places, if necessary.
    // If there are no real roots, prints a statement to that effect.
    private static void roots(double a, double b, double c) {
        int numSols = numSolutions(a, b, c);
        if (numSols == 2) {
            double discriminant = discriminant(a, b, c);
            double root1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2*a);

            System.out.print("The roots are approximately: ");
            System.out.printf("%.2f and %.2f\n", root1, root2);
        } else if (numSols == 1) {
            double root = -b / (2*a);
            System.out.print("The root is approximately: ");
            System.out.printf("%.2f\n", root);
        } else {
            System.out.println("No real roots.");
        }
    }


    // (Optional) isFactorable: accepts three double values a, b, c, and returns
    // true if the equation is factorable over the integers
    private static boolean isFactorable(double a, double b, double c) {
        if ((int) a == a && (int) b == b && (int) c == c) {
            double sqrtDiscrim = Math.sqrt(discriminant(a, b, c));
            if ((int) sqrtDiscrim == sqrtDiscrim) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // b) Create a main method that prints a nice menu asking the user for
        // the values of a, b, and c, from their quadratic equation. The program
        // should print the value of the discriminant, the number of solutions,
        // and the numeric roots, if any. (Optional: also print whether the
        // equation is factorable.)

        Scanner s = new Scanner(System.in);
        double a, b, c;

        System.out.println("Enter coefficients of a quadratic equation: ");

        System.out.print("a: ");
        a = Double.parseDouble(s.nextLine());
        System.out.print("b: ");
        b = Double.parseDouble(s.nextLine());
        System.out.print("c: ");
        c = Double.parseDouble(s.nextLine());

        roots(a,b,c);
        boolean factorable = isFactorable(a, b, c);
        System.out.println("The equation is factorable: " + factorable);

        s.close();
    }
}
