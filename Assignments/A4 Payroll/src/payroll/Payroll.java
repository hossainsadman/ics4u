package payroll;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a payroll object, including methods to load/save staff lists and
 * access/manipulate staff information (including paystubs and sick days).
 * 
 * @author Sadman
 */
public class Payroll {
    
    // list containing staff information
    private ArrayList<Employee> staffList;

    /**
     * Instantiates a payroll object, initializing the staff list with an empty
     * list.
     */
    public Payroll() {
        staffList = new ArrayList<>();
    }

    /**
     * Print a list of all employees (including their number, names, and
     * status).
     */
    public void listAllEmployees() {
        System.out.println("All Employees:");
        
        for (Employee employee : staffList) {
            System.out.println(employee.toString());
        }
        
        System.out.println();
    }

    /**
     * Return an employee if it is present in the staff list.
     * 
     * @param id number of employee
     * 
     * @return employee object (if present in staff list; null if absent)
     */
    public Employee getEmployee(String id) {
        for (Employee employee : staffList) {
            // return employee object if matching id is found
            if (employee.employeeNumber.equals(id)) {
                return employee;
            }
        }
        
        // if employee is absent from staff list, return null
        System.out.println("Employee " + id + " not found!");
        return null;
    }

    /**
     * Update the number of sick days taken by employee with the given id.
     * 
     * @param id employee number
     * @param amount number of sick days taken
     */
    public void enterSickDay(String id, double amount) {
        Employee employee = getEmployee(id);
        
        if (employee != null) {
            employee.useSickDay(amount);
        }
        
        System.out.println();
    }

    /**
     * Print paystub of employee with the given id.
     * 
     * @param id employee number
     */
    public void printEmployeePayStub(String id) {
        Employee employee = getEmployee(id);
        
        if (employee != null) {
            employee.printPayStub();
        }
    }

    /**
     * Print paystubs of all employees.
     */
    public void printAllPayStubs() {
        System.out.println("All Employee Pay Stubs:");
        
        for (Employee employee : staffList) {
            employee.printPayStub();
        }
        
        System.out.println();
    }

    /**
     * Reset number of sick days left for all full-time employees to the default
     * amount.
     */
    public void yearlySickDayReset() {
        for (Employee employee : staffList) {
            // only reset sick days for full-time employees
            if (employee instanceof FullTimeEmployee) {
                employee.resetSickDays();
            }
        }
    }

    /**
     * Reset number of sick days taken by all part-time employees to the default
     * amount.
     */
    public void monthlySickDayReset() {
        for (Employee employee : staffList) {
            // only reset sick days for part-time employees
            if (employee instanceof PartTimeEmployee) {
                employee.resetSickDays();
            }
        }
    }

    /**
     * Save staff list information to a file with the given filename.
     * 
     * @param filename name of file to save information to
     * 
     * @return whether file is saved successfully
     */
    public boolean saveStaffList(String filename) {
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(filename));

            for (Employee employee : staffList) {
                w.write(employee.employeeNumber + ",");
                w.write(employee.lastName + ",");
                w.write(employee.firstName + ",");
                w.write(employee.jobTitle + ",");

                // full-time employee specific information
                if (employee instanceof FullTimeEmployee) {
                    w.write("full-time" + ",");
                    w.write(employee.pay() + ",");
                    w.write(employee.getSickDays() + "");
                    
                // part-time employee specific information
                } else if (employee instanceof PartTimeEmployee) {
                    w.write("part-time" + ",");
                    w.write(((PartTimeEmployee) employee).getNumHoursAssigned() + ",");
                    w.write(((PartTimeEmployee) employee).getHourlyWage() + ",");
                    w.write(((PartTimeEmployee) employee).getSickDays() + "");
                }

                // write data for a different employee on each line
                w.newLine();
            }
            
            w.close();
            return true;
            
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
        return false;
    }

    /**
     * Load staff list information from a file with the given filename.
     * 
     * @param filename name of file to load information from
     * 
     * @return whether file is loaded successfully
     */
    public boolean loadStaffList(String filename) {
        staffList = new ArrayList<>();

        try {
            Scanner s = new Scanner(new File(filename));

            // temporary variables to hold staff list data until it is loaded
            
            // temporary employee obejct
            Employee employee = null;
            // temporary string array to hold data from a line in the staff list 
            // file
            String[] line;

            // iterate through each line in staff list file
            while (s.hasNextLine()) {
                line = s.nextLine().split(",");

                // instantiate employee on current line as full-time or part-time
                // based on data in current line
                
                if (line[4].equals("full-time")) {
                    employee = new FullTimeEmployee(line[0], line[1], line[2],
                        line[3], Integer.parseInt(line[5]),
                        Double.parseDouble(line[6]));

                } else if (line[4].equals("part-time")) {
                    employee = new PartTimeEmployee(line[0], line[1], line[2],
                        line[3], Integer.parseInt(line[5]),
                        Double.parseDouble(line[6]),
                        Double.parseDouble(line[7]));
                }

                // add employee to staff list
                staffList.add(employee);
            }
            
            s.close();
            return true;

        } catch (IOException iox) {
            System.out.println(iox.getMessage());
            return false;
        }
    }
}
