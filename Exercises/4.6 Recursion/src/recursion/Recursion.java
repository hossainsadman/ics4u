package recursion;

/**
 *
 * @author Sadman
 */
public class Recursion {

    // 1. Write a recursive function for the power function: x^n. Test it by
    //    prompting the user for the value of x and n, calling the function and
    //    printing out the result.
    private static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n - 1);
        }
    }

    // 2. Write a recursive method fib(n) which returns the nth fibonacci
    //    number. (Warning: it is really slow for high n.) (Although it's a
    //    good example of recursion, it's a terrible way to calculate.)
    private static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // 3. One of the most famous algorithms known was stated over two thousand
    //    years ago by the Greek mathematician Euclid. Euclid’s algorithm
    //    provides a method of finding the greatest common divisor (gcd) of a
    //    pair of natural numbers. The algorithm is based on the following
    //    properties of gcd:

    // Rule 1:  If m = n, then gcd(m, n) = m
    // Rule 2:  If m > n, then gcd(m, n) = gcd(n, m-n)
    // Rule 3:  If m < n, then gcd(m, n) = gcd(n, m)

    // Write a recursive method that returns the greatest common divisor of two positive integers.
    private static int gcd(int m, int n) {
        if (m == n) {
            return m;
        } else if (m > n) {
            return gcd(n, m-n);
        } else if (m < n) {
            return gcd(n, m);
        }
        return -1;
    }

    // 4. Write a recursive function for calculating square numbers
    private static int square(int n) {
        if (n == 1) {
            return 1;
        } else {
            return square(n - 1) + 2 * n - 1;
        }
    }

    // 5. Write a recursive function for returning whether a number is prime
    private static boolean prime(int n) {
        return divides(n, n - 1);
    }

    private static boolean divides(int m, int n) {
        if (n == 1) {
            return true;
        } else if (m % n == 0) {
            return false;
        } else {
            return divides(m, n - 1);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(power(2, 3));
        System.out.println(fib(4));
        System.out.println(gcd(15,35));
        System.out.println(square(4));
        System.out.println(prime(29));
        System.out.println(prime(30));
    }

}
