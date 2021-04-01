package payroll;

/**
 * Abstract class that represents an employee, with unique identifiers
 * (including name & id) and abstract methods for accessign pay, sick day, and
 * paystub information.
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
     * Return employee number.
     *
     * @return employee number.
     */
	public String getEmployeeNumber() {
		return this.employeeNumber;
	}

    /**
     * Return employee last name.
     *
     * @return employee last name
     */
	public String getLastName() {
		return this.lastName;
	}

    /**
     * Return employee first name.
     *
     * @return employee first name
     */
	public String getFirstName() {
		return this.firstName;
	}

    /**
     * Return employee job title.
     *
     * @return employee job title.
     */
	public String getJobTitle() {
		return this.jobTitle;
	}

    /**
     * Returns employee information formatted to a string.
     *
     * @return employee information as a string
     */
    @Override
    public String toString() {
        return "Employee: " + employeeNumber + ", " + firstName + " " + lastName + ", " + jobTitle;
    }

    /**
     * Returns the amount of money earned by the employee over a specific time
     * period (based on the employee's status)
     *
     * @return amount of money earned
     */
    abstract double pay();

    /**
     * Updates the number of sick days left or taken by the employee based on
     * the given amount (if there are enough sick days left)
     *
     * @param amount
     */
    abstract void useSickDay(double amount);

    /**
     * Returns the number of sick days left or taken by the employee
     *
     * @return number of sick days left or taken
     */
    abstract double getSickDays();

    /**
     * Resets the number of sick days left or taken by the employee to the
     * default amount
     */
    abstract void resetSickDays();

    /**
     * Prints employee's paystub (including information id, name, title, status,
     * and pay)
     */
    abstract void printPayStub();
}
