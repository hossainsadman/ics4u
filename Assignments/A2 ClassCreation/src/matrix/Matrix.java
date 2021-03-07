package matrix;

/**
 * A class that defines matrices as 2D arrays. Operations include: addition of
 * constant, addition of a matrix, multiplication by a constant, multiplication
 * by a matrix, shortcut addition (+=) and shortcut multiplication (*=) of both
 * constants and matrices.
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
     * Instantiate an empty matrix (filled with null elements)
     *
     * @param rows number of rows of the matrix
     * @param cols number of columns of the matrix
     */
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        array = new double[rows][cols];
    }

    /**
     * Instantiate a matrix using a 2D array of doubles
     *
     * @param array 2D array of doubles
     */
    public Matrix(double[][] array) {
        this.rows = array.length;
        this.cols = array[0].length;
        this.array = array;
    }

    private double[][] copy2DArray(double[][] array) {
        double[][] copy = new double[array.length][array[0].length];
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                copy[row][col] = array[row][col];
            }
        }
        return copy;
    }

    /**
     * Instantiate a matrix using a 1D array of doubles
     *
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
     * Instantiate a matrix as a copy of another matrix
     *
     * @param m matrix to be copied
     */
    public Matrix(Matrix m) {
        this.rows = m.rows;
        this.cols = m.cols;
        this.array = copy2DArray(m.array);
    }

    /**
     * Return a string representation of the matrix object (with box brackets).
     */
    @Override
    public String toString() {
        // create an array to contain each line of the output string
        String[] strings = new String[rows + 2];

        // set the top left corner in the first line
        strings[0] = "┌ ";
        // set the bottom left corner in the last line
        strings[strings.length - 1] = "└ ";

        // initialize the spaces required for the top and bottom lines (between
        // the corners
        int spacesRequired = 0;

        for (int row = 0; row < rows; row++) {

            // set the spaces required for the current line to be 0
            int currentSpaces = 0;

            // set the leftmost bracket at the start of each line
            strings[row + 1] = "│ ";

            for (int col = 0; col < cols; col++) {
                // append the current element to the string for the current row
                strings[row + 1] += array[row][col] + " ";
                // increment the spaces required for the current line by the
                // number of places taken up by the current element
                currentSpaces += Double.toString(array[row][col]).length() + 1;
            }

            // set the rightmost bracket at the end of each line
            strings[row + 1] += "│";

            // if the spaces taken up by the current row is greater than the
            // spaces required for the top and bottom, set that to be the spaces
            // required for the top and bottom lines
            if (currentSpaces > spacesRequired) {
                spacesRequired = currentSpaces;
            }
        }

        // add the required number of spaces in the first and last lines (so
        // that the box bracket symbols line up)
        for (int i = 0; i < spacesRequired; i++) {
            strings[0] += " ";
            strings[strings.length - 1] += " ";
        }

        // set the top right corner in the first line
        strings[0] += "┐";
        // set the bottom right corner in the last line
        strings[strings.length - 1] += "┘";

        // initialize the string for output (as an empty string)
        String str = "";

        // for each string in the array containing the output lines, append it
        // to the output string (separated by new lines)
        int i;
        for (i = 0; i < strings.length - 1; i++) {
            str += strings[i] + "\n";
        }
        str += strings[i];

        return str;
    }

    /**
     * Return the number of rows in the matrix
     *
     * @return number of rows in the matrix
     */
    public int getNumOfRows() {
        return this.rows;
    }

    /**
     * Return the number of columns in the matrix
     *
     * @return number of columns in the matrix
     */
    public int getNumOfCols() {
        return this.cols;
    }

    /**
     * Set the elements of a row in the matrix with elements from another 1D
     * array
     *
     * @param row      index of the row to be set
     * @param rowArray 1D array containing the new elements of the row
     */
    void setRow(int row, double[] rowArray) {
        this.array[row] = rowArray;
    }

    /**
     * Set the elements of a column in the matrix with elements from another 1D
     * array
     *
     * @param col      index of the column to be set
     * @param colArray 1D array containing the new elements of the column
     */
    void setCol(int col, double[] colArray) {
        for (int row = 0; row < rows; row++) {
            array[row][col] = colArray[row];

        }
    }

    /**
     * Set the element in a specific row and column in the matrix
     *
     * @param row     index of the row of the element
     * @param col     index of the column of the element
     * @param element value of the element to be set
     */
    void setElement(int row, int col, double element) {
        array[row][col] = element;
    }

    /**
     * Returns whether the dimensions (number of rows and columns) of this
     * matrix is equal to the dimensions of another matrix
     *
     * @param m another matrix that this matrix is being compared to
     *
     * @return whether the dimensions of this matrix is equal to the dimensions
     *          of m
     */
    public boolean equalDimensions(Matrix m) {
        if (rows == m.rows && cols == m.cols) {
            return true;
        }
        return false;
    }

    /**
     * Returns whether the dimensions (number of rows and columns) and values of
     * elements of this matrix are equal to dimensions and elements of another
     * matrix
     *
     * @param m another matrix that this matrix is being compared to
     *
     * @return whether the dimensions and elements of this matrix are equal to
     *          that of m
     */
    public boolean equals(Matrix m) {
        // if the matrices do not have the same dimensions, they cannot be
        // equal
        if (!equalDimensions(m)) {
            return false;
        }

        // if the elements of the matrices differ at any row or column, the
        // matrices cannot be equal
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
     *
     * @param d constant to be added to each element
     *
     * @return a new matrix with the constant added to each element
     */
    public Matrix add(double d) {
        // instantiate a copy of this matrix
        Matrix m = new Matrix(this);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // add the constant to each element in the copy
                m.array[row][col] += d;
            }
        }
        return m;
    }

    /**
     * Return the sum of this matrix and another matrix, where each element is
     * the sum of the elements at the same row and column in both matrices
     *
     * @param m another matrix to be summed with this matrix
     *
     * @return a new matrix that is the sum of the 2 matrices
     */
    public Matrix sum(Matrix m) {
        // instantiate a copy of this matrix
        Matrix sum = new Matrix(this);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // add to each element in the copy the corresponding
                // element in matrix m
                sum.array[row][col] = array[row][col] + m.array[row][col];
            }
        }
        return sum;
    }

    /**
     * Return the sum of elements in a row
     *
     * @param row index of the row
     *
     * @return sum of the elements in the row
     */
    public double sumRow(int row) {
        double sum = 0;
        for (int col = 0; col < cols; col++) {
            sum += array[row][col];
        }
        return sum;
    }

    /**
     * Return the sum of elements in a column
     *
     * @param col index of the column
     *
     * @return sum of the elements in the column
     */
    public double sumCol(int col) {
        double sum = 0;
        for (int row = 0; row < rows; row++) {
            sum += array[row][col];
        }
        return sum;
    }

    /**
     * Return the product of this matrix with another matrix, whether the
     * number of rows is equal to the number of rows of this matrix and the
     * number of columns is equal to the number of rows of the other matrix
     *
     * @param m another matrix to be multiplied with this matrix
     *
     * @return product of the 2 matrices
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

    /**
     * Add a constant to each element of the matrix
     *
     * @param d constant to be added to each element
     */
    public void plusEquals(double d) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // add the constant to each element
                array[row][col] += d;
            }
        }
    }

    /**
     * Set this matrix to be the sum of itself and another matrix (add each
     * element in another matrix to the element in the same location in this
     * matrix)
     *
     * @param m another matrix to be added to this
     */
    public void plusEquals(Matrix m) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] += m.array[row][col];
            }
        }
    }

    /**
     * Multiply each element of the matrix by a constant
     *
     * @param d constant to multiply each element by
     */
    public void timesEquals(double d) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // multiply each element by the constant
                array[row][col] *= d;
            }
        }
    }

    /**
     * Return whether the matrix is square (has the same number of rows and
     * columns)
     *
     * @return boolean of whether the matrix is square
     */
    public boolean isSquare() {
        if (rows == cols) {
            return true;
        }
        return false;
    }

    /**
     * Return a new matrix that is a transpose of this matrix (where the rows
     * and columns of the original matrix are switched)
     *
     * @return a new matrix that is a transpose of the original
     */
    public Matrix getTranspose() {
        // instantiate an empty matrix with number of rows and columns switched
        Matrix transpose = new Matrix(cols, rows);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // for each element in the original matrix, set the corresponding
                // element in the transpose to have its row and column switched
                transpose.setElement(col, row, array[row][col]);
            }
        }
        return transpose;
    }

}
