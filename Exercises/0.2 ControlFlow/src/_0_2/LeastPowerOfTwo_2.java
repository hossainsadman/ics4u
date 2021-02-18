package _0_2;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class LeastPowerOfTwo_2 {
    
    public static void main(String[] args) {
        // 2. Write a program that reads a positive integer and then finds and
        //    prints the smallest power of two that is greater than or equal to
        //    the number that was given. For example, if the program reads the
        //    value 25, it should note that 32 = 25 is the smallest power of two
        //    greater than or equal to 25.
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int num = Integer.parseInt(s.nextLine());

        int pow_two = 1;
        while (num >= pow_two) {
            pow_two *= 2;
        }

        System.out.println(pow_two + " is the smallest power of 2 greater than " + num + ".");

        s.close();
    }
    
}
