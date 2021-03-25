package _3_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sadman
 */
public class ReadWrite_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Read the file sisters.txt one character at a time and append each 
//        character to a new file sistersCopy.txt. Ensure that the output file 
//        exactly matches the input file.
        
        BufferedReader in = null;
        BufferedWriter out = null;
        String line;
        
        try {
            
            in = new BufferedReader(new FileReader("src/sisters.txt"));
            out = new BufferedWriter(new FileWriter("src/sistersCopy.txt"));
            
            line = in.readLine();
            while (line != null) {
                out.write(line + "\n");
                line = in.readLine();
            }
            
            in.close();
            out.close();   
            
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }
    
}
