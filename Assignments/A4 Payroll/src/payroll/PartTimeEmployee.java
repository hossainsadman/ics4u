package payroll;

/**
 * Represents a part-time employee object, with assigned hours, hourly wage, and
 * a number of sick days taken.
 * 
 * @author Sadman
 */
public class PartTimeEmployee extends Employee {
    
    // number of hours worked by each employee per day
    final private int HOURS_PER_DAY = 7;

    // number of hours of work assigned to employee
    private int numHoursAssigned;
    private double hourlyWage;
    // number of sick days taken by employee
    private double sickDaysTaken;

    /**
     * 
     * Instantiates a part-time employee object with the given identifiers
     * (including number of hours assigned, hourly wage, and number of sick days
     * taken).
     * 
     * @param employeeNumber
     * @param lastName
     * @param firstName
     * @param jobTitle
     * @param numHoursAssigned
     * @param hourlyWage
     * @param sickDaysTaken 
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
     * Return the number of hours assigned to employee
     * 
     * @return number of hours assigned
     */
    public int getNumHoursAssigned() {
        return numHoursAssigned;
    }

    /**
     * Return hourly wage of employee
     * 
     * @return hourly wage
     */
    public double getHourlyWage() {
        return hourlyWage;
    }

    /**
     * Return amount earned based on hourly wage and number of hours worked
     * 
     * @return amount earned
     */
    @Override
    public double pay() {
        // number of hours worked is equal to the number of hours assigned 
        // subtracted by the number of hours lost by each sick day taken
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
        System.out.printf("New sick days taken: %.1f\n", amount);
    }

    /**
     * Return the number of sick days taken by employee.
     * 
     * @return number of sick days taken
     */
    @Override
    public double getSickDays() {
        return sickDaysTaken;
    }

    /**
     * Reset the number of sick days taken by employee to default value (0).
     */
    @Override
    public void resetSickDays() {
        sickDaysTaken = 0;
    }

    /**
     * Print employee paystub (including information on hourly wage, assigned
     * hours, sick days taken, and current month pay).
     */
    @Override
    public void printPayStub() {
        System.out.println("\n--------------- PAY STUB ---------------");
        System.out.println(toString());
        System.out.printf("Hourly Wage: $%.2f", hourlyWage);
        System.out.printf("\nNumber of hours assigned: $d", numHoursAssigned);
        System.out.printf("\nSick days taken: %.1f", sickDaysTaken);
        System.out.printf("\nCurrent Month pay: $%.2f", pay());
        System.out.println("\n----------------------------------------\n");
    }

    /**
     * Return employee information formatted to a string, including employment
     * status.
     * 
     * @return employee information as a string
     */
    @Override
    public String toString() {
        return super.toString() + ", part-time";
    }
}
