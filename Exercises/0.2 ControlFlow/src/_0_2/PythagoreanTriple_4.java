package _0_2;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class PythagoreanTriple_4 {
    
    public static void main(String[] args) {
        // 4. Three positive integers a, b, and c with a < b < c form a
        //    Pythagorean Triple if a^2 + b^2 = c^2.  For example (3, 4, 5) is a
        //    Pythagorean Triple since 3^2 + 4^2 = 5^2.  Write a program that
        //    first prompts the user for a positive integer and then finds and
        //    prints all Pythagorean Triples whose largest member is less than
        //    or equal to that integer. [Challenge: do not print Pythagorean
        //    Triples that are multiples of other triples, e.g. (6, 8, 10) is
        //    simply 2 × (3, 4, 5).]

        Scanner s = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = Integer.parseInt(s.nextLine());

        System.out.println("Pythagorean Triples:");

        // BRUTE FORCE
        if (n >= 5) {
            for (int c = 3; c <= n; c++) {
                for (int b = 2; b < c; b++) {
                    for (int a = 1; a < b; a++) {
                        if ( a*a + b*b == c*c ) {
                            System.out.println("(" + a + ", " + b + ", " + c + ")");
                        }
                    }
                }
            }
        } else {
            System.out.println("There are no Pythagorean Triples.");
        }

        s.close();
    }
    
}
