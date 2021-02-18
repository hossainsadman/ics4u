package _0_3;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class Slopes_3 {

    // 3. This question is related to line segments in the x-y plane.

    // a) Write the following methods in the class:
    // calcSlope: accepts four doubles as parameters, the coordinates of two
    // points on a line, x1, y1, x2, y2, and returns its slope (double).
    private static double calcSlope(double x1, double y1, double x2, double y2) {
        double deltaX = x2-x1;
        double deltaY = y2-y1;
        if (deltaX == 0) {
            return Double.POSITIVE_INFINITY;
        } else {
            return deltaY/deltaX;
        }
    }

    // calcLength: accepts four doubles as parameters, the coordinates of two
    // points on the line, x1, y1, x2, y2, and returns its length (double)
    private static double calcLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TESTING a)
        // System.out.println(calcSlope(1, 1, 2, 2));
        // System.out.println(calcSlope(0, 0, 0, 1));
        // System.out.println(calcLength(0, 0, 2, 2));

        // b) Write a main method which asks the user for the coordinates of
        // four points on two different lines. Then check if the line segments
        // have the same length, and if they are parallel, perpendicular, or
        // neither.

        Scanner s = new Scanner(System.in);

        System.out.println("Please enter the coordinates of two points on line segment 1: ");
        double x1, y1, x2, y2;

        System.out.print("point A x-value: ");
        x1 = Double.parseDouble(s.nextLine());
        System.out.print("point A y-value: ");
        y1 = Double.parseDouble(s.nextLine());
        System.out.print("\npoint B x-value: ");
        x2 = Double.parseDouble(s.nextLine());
        System.out.print("point B y-value: ");
        y2 = Double.parseDouble(s.nextLine());

        System.out.println("\nPlease enter the coordinates of two points on line segment 2: ");
        double x3, y3, x4, y4;

        System.out.print("point C x-value: ");
        x3 = Double.parseDouble(s.nextLine());
        System.out.print("point C y-value: ");
        y3 = Double.parseDouble(s.nextLine());
        System.out.print("\npoint D x-value: ");
        x4 = Double.parseDouble(s.nextLine());
        System.out.print("point D y-value: ");
        y4 = Double.parseDouble(s.nextLine());

        System.out.println("\nResults:");
        double len1 = calcLength(x1, y1, x2, y2);
        double len2 = calcLength(x3, y3, x4, y4);
        if (len1 == len2) {
            System.out.println("The two line segments have the same length.");
        } else {
            System.out.println("The two line segments do not have the same length.");
        }

        double slope1 = calcSlope(x1, y1, x2, y2);
        double slope2 = calcSlope(x3, y3, x4, y4);
        if (slope1 == slope2) {
            System.out.println("The two line segments are parallel.");
        } else if (slope1 == -1/slope2){
            System.out.println("The two line segments are reciprocal.");
        }

        s.close();
    }


}
