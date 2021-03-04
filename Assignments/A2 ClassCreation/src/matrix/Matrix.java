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
        this.rows = array.length;
        this.cols = array[0].length;
        this.array = array;
    }

    public Matrix(double[] row) {
        this.rows = row.length;
        this.cols = 1;
        array = new double[rows][1];
        array[0] = row;
    }

    @Override
	public String toString() {
        String str = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if ((int) array[row][col] == array[row][col]) {
                    str += (int) array[row][col] + " ";
                } else {
                    str += array[row][col] + " ";
                }
            }
            str += "\n";
        }
        return str.trim();
    }

    int getNumOfRows() {
        return this.rows;
    }

    void setRow(int row, double[] rowArray) {
        this.array[row] = rowArray;
    }

    int getNumOfCols() {
        return this.cols;
    }

    void setCol(int col, double[] colArray) {
        for (int row = 0; row < rows; row++) {
            array[row][col] = colArray[row];
        }
    }

    void setElement(int row, int col, double element) {
        array[row][col] = element;
    }

    boolean equalDimensions(Matrix m) {
        if (rows == m.rows && cols == m.cols) {
            return true;
        }
        return false;
    }

    static boolean equalDimensions(Matrix m1, Matrix m2) {
        if (m1.rows == m2.rows && m1.cols == m2.cols) {
            return true;
        }
        return false;
    }

    boolean equals(Matrix m) {
        if (!equalDimensions(m)) {
            return false;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (array[row][col] != m.array[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean equals(Matrix m1, Matrix m2) {
        if (!equalDimensions(m1, m2)) {
            return false;
        }

        for (int row = 0; row < m1.rows; row++) {
            for (int col = 0; col < m1.cols; col++) {
                if (m1.array[row][col] != m2.array[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    void add(double d) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] += d;
            }
        }
    }

    void add(Matrix m) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] += m.array[row][col];
            }
        }
    }

    void subtract(double d) {
        add(-d);
    }

    void subtract(Matrix m) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] -= m.array[row][col];
            }
        }
    }

    void multiply(double d) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] *= d;
            }
        }
    }

    static Matrix multiply(Matrix m1, Matrix m2) {
        Matrix m = new Matrix(m1.rows, m2.cols);
        for (int row = 0; row < m.rows; row++) {
            for (int col = 0; col < m.cols; col++) {
                m.setElement(row, col, m1.sumRow(row) + m2.sumCol(col));
            }
        }
        return m;
    }

    void divide(double d) {
        multiply(1/d);
    }

    double sumRow(int row) {
        double sum = 0;
        for (int col = 0; col < cols; col++) {
            sum += array[row][col];
        }
        return sum;
    }

    double sumCol(int col) {
        double sum = 0;
        for (int row = 0; row < rows; row++) {
            sum += array[row][col];
        }
        return sum;
    }

    boolean isSquare() {
        if (rows == cols) {
            return true;
        }
        return false;
    }

    static boolean isSquare(Matrix m) {
        if (m.rows == m.cols) {
            return true;
        }
        return false;
    }

    Matrix getTranspose() {
        Matrix transpose = new Matrix(cols, rows);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transpose.setElement(col, row, array[row][col]);
            }
        }
        return transpose;
    }

    static Matrix getTranspose(Matrix m) {
        Matrix transpose = new Matrix(m.cols, m.rows);
        for (int row = 0; row < m.rows; row++) {
            for (int col = 0; col < m.cols; col++) {
                transpose.setElement(col, row, m.array[row][col]);
            }
        }
        return transpose;
    }

}
