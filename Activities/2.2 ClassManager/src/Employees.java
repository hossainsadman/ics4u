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
        // your code here
    }
    
    /**
     * Adds an employee to the list
     * @param e an instance of class Employee
     */
    public void addEmployee(Employee e) {
        // your code here
    }
    
    /**
     * Gets and an Employee from the list by matching the employee
     * name or ID given.
     * @param nameOrID String that is the employee name or ID
     * @return the Employee or null if not in the list
     */
    public Employee getEmployee(String nameOrID) {
        // your code here
        return null;
    }
    
    /**
     * Removes the first occurrence of an employee from the list, if they exist.
     * Prints a message with results.
     * @param nameOrID String that is the employee name or ID
     */
    public void removeEmployee(String nameOrID) {
        // your code here
    }
    
    
    /**
     * Reduces by 1 the number of sick days of the given employee. 
     * Prints a success message or an error message if the employee does not
     * exist or does not have enough sick days.
     * @param nameOrID String that is the employee name or ID
     */
    public void useSickDay(String nameOrID) {
        // your code here
    }
    
    
    /**
     * Gives a raise to the employee. Prints the new salary or an error
     * message if they do not exist.
     * @param nameOrID String that is the name or ID of the employee
     * @param amount dollar amount to increase the salary
     */
    public void giveRaise(String nameOrID, int amount) {
        // your code here
    }
    
    
    /**
     * Override for toString.
     * @return String of all employee information 
     */
    @Override
    public String toString() {
        return null; // your code here
    }
    
    
    
}
    
