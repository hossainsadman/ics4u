package payroll;

import java.util.Scanner;

public class PayrollRunner {

    static final String FILE_PATH = "src/payroll/";
    static final double SMALLEST_UNIT = 0.5;
    static Scanner input = new Scanner(System.in);
    static Payroll payroll = null;

    public static void main(String[] args) {

        String filename = "";
        String choice;

        boolean running = true;

        while (running) {
            printMenu();

            if (payroll != null) {
                System.out.print("> ");
                choice = input.nextLine();
            } else {
                System.out.println("There is no file loaded!");
                choice = "1";
            }

            switch (choice) {
                case "0": {     // Exit.
                    System.out.println("Closing...");
                    running = false;
                    break;
                }

                case "1": {     // Load information from file.
                    boolean success;
                    payroll = new Payroll();
                    do {
                        System.out.printf("Enter a filename to load (default location: %s): ", FILE_PATH);
                        filename = input.nextLine();
                        success = payroll.loadStaffList(FILE_PATH + filename);
                        if (success) {
                            System.out.println("Staff list in file \'" + filename + "\' loaded.");
                        } else {
                            System.out.println("Staff list not loaded!");
                        }
                    } while (!success);
                    break;
                }

                case "2": {     // Save information to file.
                    System.out.print("Do you want to use the same filename ("
                            + filename + ")? (y/n) ");
                    choice = input.nextLine();
                    if (!choice.equals("y")) {
                        System.out.print("Enter a filename to save: ");
                        filename = input.nextLine();
                    }
                    System.out.println("Saving file...");
                    payroll.saveStaffList(FILE_PATH + filename);
                    System.out.println("");
                    break;
                }

                case "3": {     // Print Employee list.
                    payroll.listAllEmployees();
                    break;
                }

                case "4": {     // Print one pay stub.
                    System.out.println("Pay stub of one employee");
                    System.out.print("Enter employee ID: ");
                    String id = input.nextLine();
                    payroll.printEmployeePayStub(id);
                    break;
                }

                case "5": {     // Print all pay stubs.
                    System.out.println("All pay stubs of all employees:");
                    payroll.printAllPayStubs();
                    break;
                }

                case "6": {     // Use a sick day.
                    System.out.println("Use Sick Day(s)");
                    System.out.print("Please enter an employee ID: ");
                    String id = input.nextLine();
                    System.out.printf("Enter the number of sick days used (increments of %s): ", SMALLEST_UNIT);
                    double numDays = Double.parseDouble(input.nextLine());
                    payroll.enterSickDay(id, numDays);
                    break;
                }

                case "7": {
                    System.out.println("Reset All Full-time Employee Sick Days");
                    payroll.yearlySickDayReset();
                    System.out.println("Done!");
                    break;
                }

                case "8": {
                    System.out.println("Reset All Part-time Employee Sick Days");
                    payroll.monthlySickDayReset();
                    System.out.println("Done!");
                    break;
                }

                default: {
                    System.out.println("\nInvalid choice!\n");
                }
            }
        }
    }

    public static void printMenu() {
        System.out.println("\nBCI INC. PAYROLL APPLICATION");
        System.out.println("----------------------------");
        System.out.println("Choose an option from the menu:");
        System.out.println("  1. Load staff list from file");
        System.out.println("  2. Save staff list to file");
        System.out.println("  3. List all employees");
        System.out.println("  4. Print Pay Stub for employee (ID)");
        System.out.println("  5. Print Pay Stubs for all empoloyees");
        System.out.println("  6. Use Sick Day (ID)");
        System.out.println("  7. Reset All Full-Time Employee Sick Days");
        System.out.println("  8. Reset All Part-Time Employee Sick Days");
        System.out.println("  0. Exit");
    }

}
