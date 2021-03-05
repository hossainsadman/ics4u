package matrix;

/**
 *
 * @author Sadman
 */
public class Matrix {

    // number of rows and columns in the matrix
    private int rows;
    private int cols;

    // 2D array to contain the elements of the matrix
    private double[][] array;

    /**
     * Initialize an empty matrix filled with null elements
     * @param row number of rows
     * @param col number of columns
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        array = new double[rows][cols];
    }

    /**
     * Initilize a matrix using a 2D array of doubles
     * @param array 2D array of doubles
     */
    public Matrix(double[][] array) {
        this.rows = array.length;
        this.cols = array[0].length;
        this.array = array;
    }

    /**
     * Initialize a matrix using a 1D array of doubles
     * @param row 1D array of doubles
     */
    public Matrix(double[] row) {
        // since a 1D array is used, the matrix only has 1 row
        this.rows = 1;
        this.cols = row.length;
        array = new double[this.rows][this.cols];
        array[0] = row;
    }

    /**
     * Initialize a matrix as a copy of another matrix
     * @param m matrix to be copied
     */
    public Matrix(Matrix m) {
        this.rows = m.rows;
        this.cols = m.cols;
        this.array = m.array;
    }

    /**
     * Return a string representation of the matrix object (with box brackets).
     */
    @Override
	public String toString() {
        // format top of matrix with spaces between '┌' and '┐'
        String str = "┌ ";
        for (int i = 0; i < cols; i++) {
            str += "  ";
        }
        str += "┐\n";

        // format matrix elements with rows beginning and ending with '│'
        for (int row = 0; row < rows; row++) {
            str += "│ ";
            for (int col = 0; col < cols; col++) {
                if ((int) array[row][col] == array[row][col]) {
                    str += (int) array[row][col] + " ";
                } else {
                    str += array[row][col] + " ";
                }
            }
            str += "│\n";
        }

        // format bottom of matrix with spaces between '└' and '┘'
        str += "└ ";
        for (int i = 0; i < cols; i++) {
            str += "  ";
        }
        str += "┘";
        return str;
    }

    /**
     * Return the number of rows in the matrix
     * @return number of rows in the matrix
     */
    public int getNumOfRows() {
        return this.rows;
    }

    /**
     * Return the number of columns in the matrix
     * @return number of columns in the matrix
     */
    public int getNumOfCols() {
        return this.cols;
    }

    /**
     * Set the elements of a row in the matrix with elements from
     * another 1D array
     * @param row index of the row to be set
     * @param rowArray 1D array containing the new elements of the row
     */
    void setRow(int row, double[] rowArray) {
        this.array[row] = rowArray;
    }

    /**
     * Set the elements of a column in the matrix with elements from
     * another 1D array
     * @param col index of the column to be set
     * @param colArray 1D array containing the new elements of the column
     */
    void setCol(int col, double[] colArray) {
        for (int row = 0; row < rows; row++) {
            array[row][col] = colArray[row];
        }
    }

    /**
     * Set the element in a specific row and column in the matrix
     * @param row index of the row of the element
     * @param col index of the column of the element
     * @param element value of the element to be set
     */
    void setElement(int row, int col, double element) {
        array[row][col] = element;
    }

    /**
     * Returns whether the dimensions (number of rows and columns) of this
     * matrix is equal to the dimensions of another matrix
     * @param m another matrix that this matrix is being compared to
     * @return whether the dimensions of this matrix is equal to the
     * dimensions of m
     */
    public boolean equalDimensions(Matrix m) {
        if (rows == m.rows && cols == m.cols) {
            return true;
        }
        return false;
    }

    /**
     * Returns whether the dimensions (number of rows and columns) and values
     * of elements of this matrix are equal to dimensions and elements of
     * another matrix
     * @param m another matrix that this matrix is being compared to
     * @return whether the dimensions and elements of this matrix are equal to that of m
     */
    public boolean equals(Matrix m) {
        // if the matrices do not have the same dimensions, they cannot be
        // equal
        if (!equalDimensions(m)) {
            return false;
        }

        // if the elements of the matrices differ at any row or column, they
        // cannot be equal
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (array[row][col] != m.array[row][col]) {
                    return false;
                }
            }
        }

        // if no differences have been found, the matrices are equal
        return true;
    }

    /**
     * Return a matrix with a constant added to each element in this matrix
     * @param d constant to be added to each element
     * @return
     */
    public Matrix add(double d) {
        Matrix m = new Matrix(this);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] += d;
            }
        }
        return m;
    }

    /**
     * Return the sum of this matrix and another matrix, where each element is
     * the sum of the elements at the same row and column in both matrices
     * @param m another matrix to be summed with this matrix
     * @return
     */
    public Matrix sum(Matrix m) {
        Matrix sum = new Matrix(this);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum.array[row][col] += m.array[row][col];
            }
        }
        return sum;
    }

    /**
     * Return the sum of elements in a row
     * @param row index of the row
     * @return
     */
    double sumRow(int row) {
        double sum = 0;
        for (int col = 0; col < cols; col++) {
            sum += array[row][col];
        }
        return sum;
    }

    /**
     * Return the sum of elements in a column
     * @param col index of the column
     * @return
     */
    double sumCol(int col) {
        double sum = 0;
        for (int row = 0; row < rows; row++) {
            sum += array[row][col];
        }
        return sum;
    }

    /**
     * Return the product of this matrix with another matrix, whether the number of rows is equal to the number of rows of this matrix and the number of columns is equal to the number of rows of the other matrix
     * @param m another matrix to be multiplied with this matrix
     * @return
     */
    public Matrix product(Matrix m) {
        Matrix product = new Matrix(rows, m.cols);
        for (int row = 0; row < product.rows; row++) {
            for (int col = 0; col < product.cols; col++) {
                product.setElement(row, col, sumRow(row) + m.sumCol(col));
            }
        }
        return product;
    }

    public void plusEquals(double d) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] += d;
            }
        }
    }

    public void plusEquals(Matrix m) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] += m.array[row][col];
            }
        }
    }

    public void timesEquals(double d) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] *= d;
            }
        }
    }

    public boolean isSquare() {
        if (rows == cols) {
            return true;
        }
        return false;
    }

    public Matrix getTranspose() {
        Matrix transpose = new Matrix(cols, rows);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transpose.setElement(col, row, array[row][col]);
            }
        }
        return transpose;
    }

}
