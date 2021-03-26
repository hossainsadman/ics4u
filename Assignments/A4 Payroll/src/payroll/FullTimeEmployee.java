package payroll;

public class FullTimeEmployee extends Employee {
    static final private int YEARLY_SICK_DAYS = 20;
    static final private int MONTHS = 12;

    private int yearlySalary;
    private double sickDaysLeft;

    public FullTimeEmployee(String employeeNumber, String lastName, String firstName, String jobTitle, int yearlySalary, double sickDaysLeft) {
        super(employeeNumber, lastName, firstName, jobTitle);

        this.yearlySalary = yearlySalary;
        this.sickDaysLeft = sickDaysLeft;
    }

    @Override
    public double pay() {
        return yearlySalary;
    }

    @Override
    public void useSickDay(double amount) {
        if (sickDaysLeft - amount >= 0) {
            sickDaysLeft -= amount;
            System.out.printf("New sick days taken: %.1f\n", amount);
        } else {
            System.out.println("Insufficient sick days left!");
        }
    }

    @Override
    public double getSickDays() {
        return sickDaysLeft;
    }

    @Override
    public void resetSickDays() {
        sickDaysLeft = YEARLY_SICK_DAYS;
    }

    @Override
    public void printPayStub() {
        System.out.println("\n--------------- PAY STUB ---------------");
        // System.out.printf("\nEmployee: %s, %s %s, %s, full-time", employeeNumber, firstName, lastName, jobTitle);
        // System.out.printf("\n%s, full-time", this.toString(), jobTitle);
        System.out.println(toString());
        System.out.printf("Yearly Salary: $%.2f", (double) yearlySalary);
        System.out.printf("\nCurrent Month pay: $%.2f", (double) yearlySalary/MONTHS);
        System.out.printf("\nSick days left: %.1f", sickDaysLeft);
        System.out.println("\n----------------------------------------");
    }

    @Override
    public String toString() {
        return super.toString() + ", full-time";
    }
}
