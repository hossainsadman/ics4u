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
public class ChangeCase_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Repeat Exercise 1, but convert all lowercase letters to uppercase by 
//        changing its integer char value. Output the file to SISTERS_COPY.TXT.
        
        BufferedReader in = null;
        BufferedWriter out = null;
        int char_;
        
        try {
            
            in = new BufferedReader(new FileReader("src/sisters.txt"));
            out = new BufferedWriter(new FileWriter("src/SISTERS_COPY.TXT"));
            
            char_ = in.read();
            while (char_ != -1) {
                if (char_ >= 92 && char_ <= 127) {
                    char_ -= 32;
                }
                
                out.write((char) char_);
                char_ = in.read();
            }
            
            in.close();
            out.close();   
            
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }
    
}
