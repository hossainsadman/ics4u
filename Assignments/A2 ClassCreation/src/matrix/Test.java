package matrix;

import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class Test {

    static Scanner s = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] m1Array = {
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5}
        };

//        System.out.print("Enter the number of rows for Matrix 1: ");
//        int row1 = Integer.parseInt(s.nextLine());
//        System.out.println("Enter the number of columns for Matrix 1 " +
//                "(note: demoing addition and multiplication of matrices " +
//                "requires number of columns to be the same as number of rows): ");
//        int col1 = Integer.parseInt(s.nextLine());

        Matrix m1 = new Matrix(m1Array);
        System.out.println("Create Matrix 1 using the 2D array constructor:");
        System.out.println(m1.toString());

        System.out.println("\nNumber of rows in Matrix 1: " + m1.getNumOfRows());
        System.out.println("Number of columns in Matrix 1: " + m1.getNumOfCols());
        System.out.println("\nMatrix 1 is a square matrix (# of rows = # of columns): " + m1.isSquare());

//        System.out.print("\nEnter the index of a row to get the sum of: ");
//        int row2 = Integer.parseInt(s.nextLine());
//        System.out.printf("Sum of row %d: %.2f\n", row2, m1.sumRow(row2));

        int row2 = 0;
        System.out.printf("\nSum of row %d: %.2f\n", row2 + 1, m1.sumRow(row2));

//        System.out.print("\nEnter the index of a column to get the sum of: ");
//        int col2 = Integer.parseInt(s.nextLine());

        int col2 = 0;
        System.out.printf("Sum of column %d: %.2f\n", col2 + 1, m1.sumCol(col2));

//        System.out.print("\nEnter the row of an element you want to set: ");
//        int row3 = Integer.parseInt(s.nextLine());
//        System.out.print("Enter the column of that element: ");
//        int col3 = Integer.parseInt(s.nextLine());
//        System.out.print("Enter the element you want to set: ");
//        double element = Double.parseDouble(s.nextLine());
//        m1.setElement(row3, col3, element);

//        System.out.print("\nEnter a constant to add to each element in Matrix 1: ");
//        double add = Double.parseDouble(s.nextLine());
        double add = 10;

        System.out.printf("\nAdd %.2f to each element in Matrix 1:\n", add);
        m1.plusEquals(add);
        System.out.println(m1.toString());

//        System.out.print("\nEnter a constant to multiply each element in Matrix 1 by: ");
//        double multiply = Double.parseDouble(s.nextLine());
        double multiply = 2.5;

        System.out.printf("\nMultiply each element in Matrix 1 by %.2f:\n", multiply);
        m1.timesEquals(multiply);
        System.out.println(m1.toString());

        System.out.println("\nTranspose of Matrix 1:");
        Matrix m2 = m1.getTranspose();
        System.out.println(m2.toString());

        System.out.println("\nMatrix 1 and its transpose have the same dimensions: " + m1.equalDimensions(m2));
        System.out.println("Matrix 1 and its transpose are equal (same dimensions and same elements): " + m1.equals(m2));

        System.out.println("\nSum of Matrix 1 and its transpose:");
        Matrix m3 = m1.sum(m2);
        System.out.println(m3.toString());

        System.out.println("\nProduct of Matrix 1 and its transpose:");
        Matrix m4 = m1.product(m2);
        System.out.println(m4.toString());

        System.out.println("\nCreate a copy of Matrix 1 (as a new object):");
        Matrix m5 = new Matrix(m1);
        System.out.println(m5.toString());
        System.out.println("\nMatrix 1 and its copy have the same dimensions: " + m1.equalDimensions(m5));
        System.out.println("Matrix 1 and its copy are equal (same dimensions and same elements): " + m1.equals(m5));

        System.out.println("\n-----------------------------------------");

        System.out.println("\nCreate Matrix 2 using the 1D array constructor:");
        double[] m6Array = {11.1,11.1,11.1,11.1,11.1};
        Matrix m6 = new Matrix(m6Array);
        System.out.println(m6.toString());

        int row3 = 0;
        System.out.printf("\nSet row %d in Matrix 1 to be the array used to make Matrix 2:\n", row3 + 1);
        m1.setRow(row3, m6Array);
        System.out.println(m1.toString());

        int col3 = 0;
        System.out.printf("\nSet column %d in Matrix 1 to be the array used to make Matrix 2:\n", col3 + 1);
        m1.setCol(col3, m6Array);
        System.out.println(m1.toString());

        int row4 = m1.getNumOfRows() - 1;
        int col4 = m1.getNumOfCols() - 1;
        double element = 99.9;
        System.out.printf("\nSet the element at row %d and column %d in Matrix 1 to be element %.3f:\n", row4 + 1, col4 + 1, element);
        m1.setElement(row4, col4, element);
        System.out.println(m1.toString());

    }

}
