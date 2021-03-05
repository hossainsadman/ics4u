package matrix;

/**
 *
 * @author Sadman
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[][] a = {
            {1,2,3,4,5},
            {3,4,6,7,8},
            {3,4,6,7,8},
            {3,4,6,7,8},
            {3,4,6,7,8}
        };
        double[] b = {1,2,3,4};
        Matrix m = new Matrix(a);
        System.out.println("Transpose:");
        System.out.println(m.getTranspose().toString());

    }

}
