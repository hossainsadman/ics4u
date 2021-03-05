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

    public Matrix(Matrix m) {
        this.rows = m.rows;
        this.cols = m.cols;
        this.array = m.array;
    }

    @Override
	public String toString() {
        String str = "┌ ";
        for (int i = 0; i < cols; i++) {
            str += "  ";
        }
        str += "┐\n";
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
        str += "└ ";
        for (int i = 0; i < cols; i++) {
            str += "  ";
        }
        str += "┘";
        return str;
    }

    public int getNumOfRows() {
        return this.rows;
    }

    public int getNumOfCols() {
        return this.cols;
    }

    void setRow(int row, double[] rowArray) {
        this.array[row] = rowArray;
    }

    void setCol(int col, double[] colArray) {
        for (int row = 0; row < rows; row++) {
            array[row][col] = colArray[row];
        }
    }

    void setElement(int row, int col, double element) {
        array[row][col] = element;
    }

    public boolean equalDimensions(Matrix m) {
        if (rows == m.rows && cols == m.cols) {
            return true;
        }
        return false;
    }

    public boolean equals(Matrix m) {
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

    public Matrix add(double d) {
        Matrix m = new Matrix(this);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                array[row][col] += d;
            }
        }
        return m;
    }

    public Matrix sum(Matrix m) {
        Matrix sum = new Matrix(this);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum.array[row][col] += m.array[row][col];
            }
        }
        return sum;
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
