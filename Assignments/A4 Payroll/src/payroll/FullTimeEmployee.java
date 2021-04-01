package payroll;

/**
 * Represents a full-time employee, including a yearly salary and number of
 * sick days left.
 * @author Sadman
 */
public class FullTimeEmployee extends Employee {

    // default number of sick days available to each employee every year
    final private int YEARLY_SICK_DAYS = 20;
    // default number of months for which employees are paid
    final private int MONTHS = 12;

    private int yearlySalary;
    // number of sick days left for employee
    private double sickDaysLeft;

    /**
     * Instantiates a full-time employee object with the given identifiers
     * (including yearly salary and number of sick days left).
     *
     * @param employeeNumber employee number
     * @param lastName last name
     * @param firstName first name
     * @param jobTitle job title
     * @param yearlySalary yearly salary
     * @param sickDaysLeft number of sick days left
     */
    public FullTimeEmployee(String employeeNumber, String lastName, String firstName,
            String jobTitle, int yearlySalary, double sickDaysLeft) {
        super(employeeNumber, lastName, firstName, jobTitle);

        this.yearlySalary = yearlySalary;
        this.sickDaysLeft = sickDaysLeft;
    }

    /**
     * Returns yearly salary of employee.
     *
     * @return yearly salary as double
     */
    public double getYearlySalary() {
        return yearlySalary;
    }

    /**
     * Returns the amount of money earned monthly based on the yearly salary.
     *
     * @return monthly pay
     */
    @Override
    public double pay() {
        return (double) yearlySalary/MONTHS;
    }

    /**
     * Updates number of sick days left for employee (reduced by the amount of
     * sick days given).
     *
     * @param amount amount of sick days taken (in 0.5 increments)
     */
    @Override
    public void useSickDay(double amount) {
        sickDaysLeft -= amount;
    }

    /**
     * Returns the number of sick days left for employee.
     *
     * @return number of sick days left
     */
    @Override
    public double getSickDays() {
        return sickDaysLeft;
    }

    /**
     * Resets the number of sick days left for employee to the default value.
     */
    @Override
    public void resetSickDays() {
        sickDaysLeft = YEARLY_SICK_DAYS;
    }

    /**
     * Prints employee paystub (including information on yearly salary, monthly
     * pay, and number of sick days left).
     */
    @Override
    public void printPayStub() {
        System.out.println("\n--------------- PAY STUB ---------------");
        System.out.println(toString());
        System.out.printf("Yearly Salary: $%.2f", (double) yearlySalary);
        System.out.printf("\nCurrent Month pay: $%.2f", pay());
        System.out.printf("\nSick days left: %.1f", sickDaysLeft);
        System.out.println("\n----------------------------------------\n");
    }

    /**
     * Returns employee information formatted to a string, including employment
     * status.
     *
     * @return employee information as a string
     */
    @Override
    public String toString() {
        return super.toString() + ", full-time";
    }
}
