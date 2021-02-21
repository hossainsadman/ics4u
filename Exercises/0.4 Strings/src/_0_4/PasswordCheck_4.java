package _0_4;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class PasswordCheck_4 {

    // 4. Write a program that asks a user to set a new password (String). It
    //    should ask the user to enter the password twice to verify. If both
    //    entries are not identical, then  it should ask the user to try again.
    //    If they are identical, then it should then check the "strength" of the
    //    password and report back to the user. A "weak" password contains only
    //    lower case (a-z) and/or upper case (A-Z) letters, and is at least 8
    //    characters in length. A "medium" password consists of at least one
    //    lower case and/or upper case letter, and one number (0-9), and is at
    //    least 8 characters. A "strong" password contains at least one lower
    //    case letter, upper case letter, number, and symbol (~`-_=+ etc.), and
    //    is at least 16 characters. Any password less than 8 characters is
    //    "invalid". The program should ask the user whether they want to keep
    //    this password or try another. If they choose the former, the program
    //    terminates.


    private static int passwordStrength(String str) {
        if (str.length() < 8) {
            return -1;
        }

        boolean containsLowercase = false;
        boolean containsUppercase = false;
        boolean containsNumbers = false;
        boolean containsSymbols = false;

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if (!containsLowercase && 97 <= (int)letter && (int)letter <= 122) {
                containsLowercase = true;
            } else if (!containsUppercase && 65 <= (int)letter && (int)letter <= 90) {
                containsUppercase = true;
            } else if (!containsNumbers && 48 <= (int)letter && (int)letter <= 57) {
                containsNumbers = true;
            } else if (!containsSymbols && ((32 <= (int)letter && (int)letter <= 47) || (58 <= (int)letter && (int)letter <= 96) || (123 <= (int)letter && (int)letter <= 126)) ) {
                containsSymbols = true;
            }
        }

        if (containsLowercase || containsUppercase) {
            if (containsNumbers) {
                if (containsSymbols && str.length() >= 16) {
                    return 2;
                }
                return 1;
            }
            return 0;
        }
        return -1;
    }

    // private static

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        // SAMPLE OUTPUT

        // Please enter a new password: passwd
        // Please re-enter the password: passwd

        // The password strength is invalid!

        // Please enter a new password: helloworld
        // Please re-enter the password: heloworld

        // Passwords do not match. Try again.

        // Please enter a new password: Password0
        // Please re-enter the password: Password0

        // The password strength is medium!

        // Please enter a new password: Horse/lemon-stapler99
        // Please re-enter the password: Horse/lemon-stapler99

        // The password strength is strong!

        boolean keepPassword = false;
        while (!keepPassword) {
            System.out.print("Please enter a new password: ");
            String password = s.nextLine();
            System.out.print("Please re-enter the password: ");

            if (!password.equals(s.nextLine())) {
                System.out.println("Passwords do not match. Try again.\n");
                continue;
            }

            int passwordStrength = passwordStrength(password);
            String msg = "The password strength is ";
            if (passwordStrength == -1) {
                msg += "invalid!" + " Try again.\n";
                System.out.println(msg);
                continue;
            } else if (passwordStrength == 0) {
                msg += "weak!";
            } else if (passwordStrength == 1) {
                msg += "medium!";
            } else if (passwordStrength == 2) {
                msg += "strong!";
            }
            System.out.println(msg);

            System.out.print("\nKeep password? (Y/N): ");
            String keep = s.nextLine();
            if (keep.equals("Y") || keep.equals("y")) {
                System.out.println("\nPassword: " + password);
                keepPassword = true;
            }
        }

        s.close();
    }
}
