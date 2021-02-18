package _0_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sadman
 */
public class _0_1 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        // 1. Trace through the following code segments and illustrate the
        //    output and memory.

        // a = 3
        // b = 9
        // print(b)
        // a = b + 2
        // a = a + b
        // print(b+3)
        // print(a)

        // ans = 10
        // res = 6
        // num = ans + res
        // print(num + 2)
        // res = num + 3
        // print(res)

        // 2. Write a program that asks the user for three float values, then
        //    computes and prints the mean, or average. (Don’t worry about the
        //    print formatting at this point). eg. User enters 12, 33.4, and
        //    22.1; the mean is (12 + 33.4 + 22.1) / 3 = 22.5

        // CODE
        double sum = 0;
        for (int i = 0; i < 3; i++) {
                sum += Double.parseDouble(r.readLine());
        }
        System.out.println("Mean: " + sum/3);

        // A fast food restaurant charges $1.69 for burgers, $1.09 for fries,
        // and $0.99 for a drink. Make sure to use constants. Write a
        // point-of-sale program that prompts the employee for the number of
        // burgers, fries, and drinks and then displays the subtotal, the PST
        // (8%), the GST (5%), and the total. Modify the program to prompt the
        // employee for the amount tendered and then display the change due.
        // (Again, don’t worry about print formatting at this point.)

        // CODE
        // a)
        final double PRICE_BURGER = 1.69;
        final double PRICE_FRY = 1.09;
        final double PRICE_DRINK = 0.99;
        System.out.print("Number of burgers? ($1.69/each)");
        int burgers = Integer.parseInt(r.readLine());
        System.out.print("Number of fries? ($1.09/each)");
        int fries = Integer.parseInt(r.readLine());
        System.out.print("Number of drinks? ($0.99/each)");
        int drinks = Integer.parseInt(r.readLine());
        double subtotal = burgers*PRICE_BURGER + fries*PRICE_FRY + drinks*PRICE_DRINK;
        double total = subtotal*0.15;
        System.out.println("Total: $" + total);

        // b)
        System.out.println("Amount tendered?");
        double tender = Double.parseDouble(r.readLine());
        double change = total-tender;
        System.out.println("Change Due: $" + change);

        // Write a program that asks the user for a three-digit integer, finds
        // the sum of the digits of the number, and prints both the number and
        // its digit sum. You must store the number as int and may not convert
        // to str. (No need to check for incorrect input.) 
        // eg. User inputs 123; sum of digits is 1 + 2 + 3 = 6

        // CODE
        System.out.print("3 Digit Integer: ");
        int num = Integer.parseInt(r.readLine());
        String out = "";
        int digit;
        sum = 0;
        while (num>0) {
                // get the last digit of num
                digit = num%10;
                sum += digit;
                out = " + " + digit + out;
                // integer division of num by 10 gets rid of the last digit
                num /= 10;
        }
        out = out.substring(3);
        System.out.println(out + " = " + sum);
    }
    
}
