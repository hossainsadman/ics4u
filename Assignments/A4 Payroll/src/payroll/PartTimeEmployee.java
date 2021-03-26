package payroll;

public class PartTimeEmployee extends Employee {
    static final private int HOURS_PER_DAY = 7;

    private int numHoursAssigned;
    private double hourlyWage;
    private double sickDaysTaken;

    public PartTimeEmployee(String employeeNumber, String lastName, String firstName, String jobTitle, int numHoursAssigned, double hourlyWage, double sickDaysTaken) {
        super(employeeNumber, lastName, firstName, jobTitle);

        this.numHoursAssigned = numHoursAssigned;
        this.hourlyWage = hourlyWage;
        this.sickDaysTaken = sickDaysTaken;
    }

    public int getNumHoursAssigned() {
        return numHoursAssigned;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    @Override
    public double pay() {
        return hourlyWage * (numHoursAssigned - sickDaysTaken * HOURS_PER_DAY);
    }

    @Override
    public void useSickDay(double amount) {
        System.out.printf("New sick days taken: %.1f\n", amount);
        sickDaysTaken += amount;
    }

    @Override
    public double getSickDays() {
        return sickDaysTaken;
    }

    @Override
    public void resetSickDays() {
        sickDaysTaken = 0;
    }

    @Override
    public void printPayStub() {
        System.out.println("\n--------------- PAY STUB ---------------");
        // System.out.printf("\nEmployee: %s, %s %s, %s, full-time", employeeNumber, firstName, lastName, jobTitle);
        // System.out.printf("\n%s, full-time", this.toString(), jobTitle);
        System.out.println(toString());
        System.out.printf("Hourly Wage: $%.2f", hourlyWage);
        System.out.printf("\nNumber of hours assigned: $d", numHoursAssigned);
        System.out.printf("\nSick days taken: %.1f", sickDaysTaken);
        System.out.printf("\nCurrent Month pay: $%.2f", pay());
        System.out.println("\n----------------------------------------\n");
    }

    @Override
    public String toString() {
        return super.toString() + ", part-time";
    }
}
