package matrix;

/**
 *
 * @author Sadman
 */
public class Matrix {

    private int rows;
    private int cols;
    private double[][] array;

    /**
     * Initialize an empty matrix with null elements
     * @param row number of rows
     * @param col number of columns
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        array = new double[rows][cols];
    }

    public Matrix(double[][] array) {
        this.array = array;
    }

    int getNumOfRows() {
        return this.rows;
    }

    int getNumOfCols() {
        return this.cols;
    }

    void setRow(int row) {
        this.rows = row;
    }

    void setCol(int col) {
        this.cols = col;
    }

    void setElement(int row, int col, double element) {
        array[row][col] = element;
    }

    boolean equals(Matrix m) {
        if (rows != m.rows || cols != m.cols) {
            return false;
        }

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] != m.array[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean equals(Matrix m1, Matrix m2) {
        if (m1.rows != m2.rows || m1.cols != m2.cols) {
            return false;
        }

        for (int row = 0; row < m1.array.length; row++) {
            for (int col = 0; col < m1.array[row].length; col++) {
                if (m1.array[row][col] != m2.array[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    void add(double d) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] += d;
            }
        }
    }

    void subtract(double d) {
        add(-d);
    }

    void multiply(double d) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] *= d;
            }
        }
    }

    void divide(double d) {
        multiply(1/d);
    }

    boolean isSquare() {
        if (rows == cols) {
            return true;
        }
        return false;
    }

    boolean isSquare(Matrix m) {
        if (m.rows == m.cols) {
            return true;
        }
        return false;
    }

}
