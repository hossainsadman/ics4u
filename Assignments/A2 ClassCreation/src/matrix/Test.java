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

        // 2D array for constructing a Matrix object
        double[][] m1Array = {
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5},
            {1,2,3,4,5}
        };

        // create Matrix using 2D constructor
        Matrix m1 = new Matrix(m1Array);
        System.out.println("Create Matrix 1 using the 2D array constructor:");
        System.out.println(m1.toString());

        // Matrix methods (get number of rows and columns, whether Matrix is square)
        System.out.println("\nNumber of rows in Matrix 1: " + m1.getNumOfRows());
        System.out.println("Number of columns in Matrix 1: " + m1.getNumOfCols());
        System.out.println("\nMatrix 1 is a square matrix (# of rows = # of columns): " + m1.isSquare());

        // methods to calculate sum of a row and a column in a Matrix
        int row2 = 0;
        System.out.printf("\nSum of row %d: %.2f\n", row2 + 1, m1.sumRow(row2));

        int col2 = 0;
        System.out.printf("Sum of column %d: %.2f\n", col2 + 1, m1.sumCol(col2));

        // Add a constant to each element in a Matrix
        double add = 10;
        System.out.printf("\nAdd %.2f to each element in Matrix 1:\n", add);
        m1.plusEquals(add);
        System.out.println(m1.toString());

        // Multiply each element by a constant in a Matrix
        double multiply = 2.5;
        System.out.printf("\nMultiply each element in Matrix 1 by %.2f:\n", multiply);
        m1.timesEquals(multiply);
        System.out.println(m1.toString());

        // Get the transpose of a Matrix
        System.out.println("\nTranspose of Matrix 1:");
        Matrix m2 = m1.getTranspose();
        System.out.println(m2.toString());

        // Compare attributes of a Matrix and its transpose (dimensions and equality:
        // same dimensions and same elements in the same locations)
        System.out.println("\nMatrix 1 and its transpose have the same dimensions: " + m1.equalDimensions(m2));
        System.out.println("Matrix 1 and its transpose are equal (same dimensions and same elements): " + m1.equals(m2));

        // Add 2 matrices
        System.out.println("\nSum of Matrix 1 and its transpose:");
        Matrix m3 = m1.sum(m2);
        System.out.println(m3.toString());

        // Multiply 2 matrices
        System.out.println("\nProduct of Matrix 1 and its transpose:");
        Matrix m4 = m1.product(m2);
        System.out.println(m4.toString());

        // create Matrix using copy constructor
        System.out.println("\nCreate a copy of Matrix 1 (as a new object):");
        Matrix m5 = new Matrix(m1);
        System.out.println(m5.toString());
        System.out.println("\nMatrix 1 and its copy have the same dimensions: " + m1.equalDimensions(m5));
        System.out.println("Matrix 1 and its copy are equal (same dimensions and same elements): " + m1.equals(m5));

        System.out.println("\n-----------------------------------------");

        // Create Matrix using 1D array constructor
        System.out.println("\nCreate Matrix 2 using the 1D array constructor:");
        double[] m6Array = {11.1,11.1,11.1,11.1,11.1};
        Matrix m6 = new Matrix(m6Array);
        System.out.println(m6.toString());

        // Set 1D array as a specific row in a Matrix
        int row3 = 0;
        System.out.printf("\nSet row %d in Matrix 1 to be the array used to make Matrix 2:\n", row3 + 1);
        m1.setRow(row3, m6Array);
        System.out.println(m1.toString());

        // Set 1D array as a specific column in a Matrix
        int col3 = 0;
        System.out.printf("\nSet column %d in Matrix 1 to be the array used to make Matrix 2:\n", col3 + 1);
        m1.setCol(col3, m6Array);
        System.out.println(m1.toString());

        // Set a new element at a specific row and column in a Matrix
        int row4 = m1.getNumOfRows() - 1;
        int col4 = m1.getNumOfCols() - 1;
        double element = 99.9;
        System.out.printf("\nSet the element at row %d and column %d in Matrix 1 to be element %.3f:\n", row4 + 1, col4 + 1, element);
        m1.setElement(row4, col4, element);
        System.out.println(m1.toString());

    }

}
