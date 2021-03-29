package payroll;

/**
 * Abstract class that represents an employee, with unique identifiers
 * (including name & id) and abstract methods for pay, sick day information, and
 * paystub
 *
 * @author Sadman
 */
abstract class Employee {

    protected String employeeNumber;
    protected String lastName;
    protected String firstName;
    protected String jobTitle;

    /**
     * Instantiates an employee object with the given identifiers.
     *
     * @param employeeNumber
     * @param lastName
     * @param firstName
     * @param jobTitle
     */
    public Employee(String employeeNumber, String lastName, String firstName,
            String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.jobTitle = jobTitle;
    }

    /**
     * Return the amount of money earned by the employee over a specific time
     * period (based on the employee's status)
     *
     * @return amount of money earned
     */
    abstract double pay();

    /**
     * Update the number of sick days left or taken by the employee based on the
     * given amount (if there are enough sick days left)
     *
     * @param amount
     */
    abstract void useSickDay(double amount);

    /**
     * Return the number of sick days left or taken by the employee
     *
     * @return number of sick days left or taken
     */
    abstract double getSickDays();

    /**
     * Reset the number of sick days left or taken by the employee to the
     * default amount
     */
    abstract void resetSickDays();

    /**
     * Print employee paystub (including information id, name, title, status,
     * and pay)
     */
    abstract void printPayStub();

    /**
     * Return employee information formatted to a string.
     * @return employee information as a string
     */
    @Override
    public String toString() {
        return "Employee: " + employeeNumber + ", " + firstName + " " + lastName + ", " + jobTitle;
    }
}
