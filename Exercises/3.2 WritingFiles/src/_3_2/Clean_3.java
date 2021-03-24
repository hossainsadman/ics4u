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
public class Clean_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Repeat Exercise 2, but do not write any printable characters that are 
//        not letters, excluding spaces, before writing. Output the file to 
//        SISTERSCLEAN.TXT.
        
        BufferedReader in = null;
        BufferedWriter out = null;
        int char_;
        
        try {
            
            in = new BufferedReader(new FileReader("src/sisters.txt"));
            out = new BufferedWriter(new FileWriter("src/SISTERSCLEAN.TXT"));
            
            char_ = in.read();
            while (char_ != -1) {
                if ((char_ >= 65 && char_ <= 90) || (char_ >= 92 && char_ <= 127) || char_ == 32) {
                    out.write((char) char_);
                }
                char_ = in.read();
            }
            
            in.close();
            out.close();   
            
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }
    
}
