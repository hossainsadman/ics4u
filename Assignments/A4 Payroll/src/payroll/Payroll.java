package payroll;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Payroll {
    private ArrayList<Employee> staffList;

    public Payroll() {
        staffList = new ArrayList<>();
    }

    public void listAllEmployees() {
        System.out.println("All Employees:");
        for (Employee employee : staffList) {
            System.out.println(employee.toString());
        }
    }

    public Employee getEmployee(String id) {
        for (Employee employee : staffList) {
            if (employee.employeeNumber.equals(id)) {
                return employee;
            }
        }
        System.out.println("Employee " + id + " not found!");
        return null;
    }

    public void enterSickDay(String id, double amount) {
        Employee employee = getEmployee(id);
        if (employee != null) {
            employee.useSickDay(amount);
        }
    }

    public void printEmployeePayStub(String id) {
        Employee employee = getEmployee(id);
        if (employee != null) {
            employee.printPayStub();
        }
    }

    public void printAllPayStubs() {
        System.out.println("All Employee Pay Stubs:");
        for (Employee employee : staffList) {
            employee.printPayStub();
        }
    }

    public void yearlySickDayReset() {
        for (Employee employee : staffList) {
            if (employee instanceof FullTimeEmployee) {
                employee.resetSickDays();
            }
        }
    }

    public void monthlySickDayReset() {
        for (Employee employee : staffList) {
            if (employee instanceof PartTimeEmployee) {
                employee.resetSickDays();
            }
        }
    }

    public void saveStaffList(String filename) {
        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(filename));

            for (Employee employee : staffList) {
                w.write(employee.employeeNumber + ",");
                w.write(employee.lastName + ",");
                w.write(employee.firstName + ",");
                w.write(employee.jobTitle + ",");

                if (employee instanceof FullTimeEmployee) {
                    w.write("full-time" + ",");
                    w.write(employee.pay() + ",");
                    w.write(employee.getSickDays() + "");

                } else if (employee instanceof PartTimeEmployee) {
                    w.write("part-time" + ",");
                    w.write(((PartTimeEmployee) employee).getNumHoursAssigned() + ",");
                    w.write(((PartTimeEmployee) employee).getHourlyWage() + ",");
                    w.write(((PartTimeEmployee) employee).getSickDays() + "");
                }

                w.newLine();
            }
            w.close();
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }

    public boolean loadStaffList(String filename) {
        staffList = new ArrayList<>();

        try {
            Scanner s = new Scanner(new File(filename));

            Employee employee = null;
            String[] line;

            while (s.hasNextLine()) {
                line = s.nextLine().split(",");

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
