/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hossain_sadman_hours;

import java.util.Scanner;

/**
 *
 * @author 333525079
 */
public class Hossain_Sadman_Hours {
    
    private static Scanner s = new Scanner(System.in);

    // get a 2d array with the hours worked by each employee per day
    private static double[][] getHours(int numEmployees, int numDays) {
        
        // initialize empty 2d array 
        double[][] hours = new double[numEmployees][numDays];
        
        // get the number of hours for each working day for each employee
        for (int i = 0; i < numEmployees; i++) {
            
            System.out.printf("Enter all the hours worked for Employee %d:\n", i);
            
            for (int j = 0; j < numDays; j++) {
                System.out.printf("day %d: ", j);
                double hour = Double.parseDouble(s.nextLine());
                hours[i][j] = hour;
            }
            
        }
        
        System.out.println();
        
        return hours;
    }
    
    // return an array for the total number of hours worked by each employee
    private static double[] totalHoursPerEmployee(double[][] hours) {
        
        // initialize empty array with length as the number of employees
        double[] totalHoursPerEmployee = new double[hours.length];
        
        // add up the number of hours worked each day for each employee
        for (int i = 0; i < hours.length; i++) {
            for (double hour : hours[i]) {
                totalHoursPerEmployee[i] += hour;
            }
        }
        
        return totalHoursPerEmployee;
        
    }
    
    // return an array for the total number of hours worked per day;
    private static double[] totalHoursPerDay(double[][] hours) {
        
        // initialize empty array with length as the number of days worked by 
        // the first employee
        double[] totalHoursPerDay = new double[hours[0].length];
        
        // for each day...
        for (int day = 0; day < totalHoursPerDay.length; day++) {
            
            // ...add up the number of hours worked by each employee
            for (double[] employeeHours : hours) {
                totalHoursPerDay[day] += employeeHours[day];
            }
        }
        
        return totalHoursPerDay;
        
    }
    
    // return the index of the greatest item in an array of doubles
    private static int indexOfGreatest(double[] array) {
        
        // set the first item in the array as the greatest
        double greatest = array[0];
        int indexOfGreatest = 0;
        
        // for each item in the array...
        for (int i = 0; i < array.length; i++) {
            
            // ...if an item in the array is found to be greater than the 
            // current greatest, set that to be the current greatest variable
            if (array[i] > greatest) {
                greatest = array[i];
                indexOfGreatest = i;
            }
        }
        
        return indexOfGreatest;
    }
    
    // return a string listing the daily hours of an employee
    private static String dailyHoursToString(double[][] hours, int employee) {
        
        String dailyHours = "";
        int i;
        
        // append the hours worked each day to the string
        for (i = 0; i < hours[employee].length - 1; i++) {
            dailyHours += hours[employee][i] + ", ";
        }
        dailyHours += hours[employee][i];
        
        return dailyHours;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // get number of employees and the number of days in the work week
        System.out.print("Enter the number of employees: ");
        int numEmployees = Integer.parseInt(s.nextLine());
        System.out.print("Enter the number of working days: ");
        int numDays = Integer.parseInt(s.nextLine());
        
        System.out.println();
        
        // create 2d array for the number of hours worked by each employee per day
        double[][] hours = getHours(numEmployees, numDays);
        // create array for the total number of hours worked by each employee
        double[] totalHoursPerEmployee = totalHoursPerEmployee(hours);
        // create array for the total number of hours worked per day
        double[] totalHoursPerDay = totalHoursPerDay(hours);
        
        // print the number of hours (daily and total) worked by each employee
        System.out.println("The hours worked:");
        for (int i = 0; i < hours.length; i++) {
            System.out.println("Employee " + i);
            System.out.println("daily hours: " + dailyHoursToString(hours, i));
            System.out.println("week total: " + totalHoursPerEmployee[i]);
            System.out.println();
        }
        
        // print the employee with the highest total number of hours worked
        System.out.printf("Highest total working hours: Employee %d, %.2f hours\n",
                indexOfGreatest(totalHoursPerEmployee), 
                totalHoursPerEmployee[indexOfGreatest(totalHoursPerEmployee)]);
       
        System.out.println();
        
        // print the day with the highest number of hours worked
        System.out.printf("Day with most hours worked: day %d, %.2f hours\n", 
                indexOfGreatest(totalHoursPerDay), 
                totalHoursPerDay[indexOfGreatest(totalHoursPerDay)]);
    }
    
}
