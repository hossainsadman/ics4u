package _2_2;

import java.util.ArrayList;

/**
 * Manages a list of employees (of type Employee). Employee objects are
 * stored in an ArrayList. Employees can be added, removed, and given raises.
 * Sick days can be used. Employees are referenced by their String
 * employee ID or name.
 * @author Student
 */
public class Employees {
    private ArrayList<Employee> employees;

    /**
     * Constructor that initializes the employees list.
     */
    public Employees() {
        employees = new ArrayList<Employee>();
    }

    /**
     * Adds an employee to the list
     * @param e an instance of class Employee
     */
    public void addEmployee(Employee e) {
        employees.add(e);
    }

    /**
     * Gets and an Employee from the list by matching the employee
     * name or ID given.
     * @param nameOrID String that is the employee name or ID
     * @return the Employee or null if not in the list
     */
    public Employee getEmployee(String nameOrID) {
        for (Employee e : employees) {
            if (e.getName().equals(nameOrID) || e.getId().equals(nameOrID)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Removes the first occurrence of an employee from the list, if they exist.
     * Prints a message with results.
     * @param nameOrID String that is the employee name or ID
     */
    public void removeEmployee(String nameOrID) {
        for (Employee e : employees) {
            if (e.getName().equals(nameOrID) || e.getId().equals(nameOrID)) {
                employees.remove(e);
                return;
            }
        }
        System.out.println(nameOrID + " is not an employee.");
    }


    /**
     * Reduces by 1 the number of sick days of the given employee.
     * Prints a success message or an error message if the employee does not
     * exist or does not have enough sick days.
     * @param nameOrID String that is the employee name or ID
     */
    public void useSickDay(String nameOrID) {
        Employee e = getEmployee(nameOrID);
        if (e != null && e.getSickDays() > 0) {
            e.setSickDays(e.getSickDays() - 1);
        } else {
            System.out.println(nameOrID + " does not have enough sick days.");
        }
    }


    /**
     * Gives a raise to the employee. Prints the new salary or an error
     * message if they do not exist.
     * @param nameOrID String that is the name or ID of the employee
     * @param amount dollar amount to increase the salary
     */
    public void giveRaise(String nameOrID, int amount) {
        Employee e = getEmployee(nameOrID);
        if (e != null) {
            e.setSalary(e.getSalary() + amount);
        } else {
            System.out.println(nameOrID + " is not an employee.");
        }
    }


    /**
     * Override for toString.
     * @return String of all employee information
     */
    @Override
    public String toString() {
        String str = "Employees:\n[";
        for (Employee e : employees) {
            str += e.toString();
        }
        str += "]";
        return str;
    }



}
