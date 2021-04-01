package payroll;

/**
 * Represents a part-time employee object, including assigned hours, hourly
 * wage, and a number of sick days taken.
 *
 * @author Sadman
 */
public class PartTimeEmployee extends Employee {

    // default number of hours worked by each employee per day
    final private int HOURS_PER_DAY = 7;

    private int numHoursAssigned;
    private double hourlyWage;
    private double sickDaysTaken;

    /**
     *
     * Instantiates a part-time employee object with the given identifiers
     * (including number of hours assigned, hourly wage, and number of sick days
     * taken).
     *
     * @param employeeNumber employee number
     * @param lastName last name
     * @param firstName first name
     * @param jobTitle job title
     * @param numHoursAssigned number of assigned hours
     * @param hourlyWage hourly wage
     * @param sickDaysTaken number of sick days taken
     */
    public PartTimeEmployee(String employeeNumber, String lastName,
            String firstName, String jobTitle, int numHoursAssigned,
            double hourlyWage, double sickDaysTaken) {
        super(employeeNumber, lastName, firstName, jobTitle);

        this.numHoursAssigned = numHoursAssigned;
        this.hourlyWage = hourlyWage;
        this.sickDaysTaken = sickDaysTaken;
    }

    /**
     * Returns the number of hours assigned to employees
     *
     * @return number of hours assigned
     */
    public int getNumHoursAssigned() {
        return numHoursAssigned;
    }

    /**
     * Returns hourly wage of employee.
     *
     * @return hourly wage
     */
    public double getHourlyWage() {
        return hourlyWage;
    }

    /**
     * Returns amount earned based on hourly wage and number of hours worked.
     *
     * @return amount earned
     */
    @Override
    public double pay() {
        // number of hours worked = number of hours assigned - number of hours lost per sick day taken
        double numHoursWorked = numHoursAssigned - sickDaysTaken * HOURS_PER_DAY;
        return hourlyWage * numHoursWorked;
    }

    /**
     * Updates number of sick days taken by employee (incremented by the amount
     * of sick days given).
     *
     * @param amount number of sick days taken (in 0.5 increments)
     */
    @Override
    public void useSickDay(double amount) {
        sickDaysTaken += amount;
    }

    /**
     * Returns the number of sick days taken by employee.
     *
     * @return number of sick days taken
     */
    @Override
    public double getSickDays() {
        return sickDaysTaken;
    }

    /**
     * Resets the number of sick days taken by employee to default value (0).
     */
    @Override
    public void resetSickDays() {
        sickDaysTaken = 0;
    }

    /**
     * Prints employee paystub (including information on hourly wage, assigned
     * hours, sick days taken, and current month pay).
     */
    @Override
    public void printPayStub() {
        System.out.println("\n--------------- PAY STUB ---------------");
        System.out.println(toString());
        System.out.printf("Hourly Wage: $%.2f", hourlyWage);
        System.out.printf("\nNumber of hours assigned: %d", numHoursAssigned);
        System.out.printf("\nSick days taken: %.1f", sickDaysTaken);
        System.out.printf("\nCurrent Month pay: $%.2f", pay());
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
        return super.toString() + ", part-time";
    }
}
