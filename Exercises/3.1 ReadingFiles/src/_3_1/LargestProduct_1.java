package _3_1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class LargestProduct_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        After reading the 20×20 grid of integers in grid.txt, determine the 
//        greatest product of four adjacent numbers in the same direction 
//        (up/down, left/right, diagonals) in the 20 × 20 grid. Print the answer.
        
        Scanner s = null;
        String line;
        
        try {
            s = new Scanner(new File("src/grid.txt"));
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
        
        int[][] a = new int[20][20];
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                a[i][j] = Integer.parseInt(s.next());
            }
        }
        
        int largest = 0;
        int product;
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20-4; j++) {
                product = a[i][j] * a[i][j+1] * a[i][j+2] * a[i][j+3] * a[i][j+4];
                if (product > largest) {
                    largest = product;
                }
            }
        }
        
        for (int i = 0; i < 20-4; i++) {
            for (int j = 0; j < 20; j++) {
                product = a[i][j] * a[i+1][j] * a[i+2][j] * a[i+3][j] * a[i+4][j];
                if (product > largest) {
                    largest = product;
                }
            }
        }
        
        for (int i = 0; i < 20-4; i++) {
            for (int j = 0; j < 20-4; j++) {
                product = a[i][j] * a[i+1][j+1] * a[i+2][j+2] * a[i+3][j+3] * a[i+4][j+4];
                if (product > largest) {
                    largest = product;
                }
                product = a[i][j+4] * a[i+1][j+3] * a[i+2][j+2] * a[i+3][j+1] * a[i+4][j];
                if (product > largest) {
                    largest = product;
                }
            }
        }
        
        System.out.println(largest);
        
        s.close();
    }
    
}
