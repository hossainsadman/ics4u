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
public class Vowels_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        Read in the file SISTERSCLEAN.TXT and determine the percentage of 
//        vowels reasonable.
        
        BufferedReader in = null;
        BufferedWriter out = null;
        int char_;
        
        String[] vowels = {"A","E","I","O","U"};
        int[] vowelFreq = {0,0,0,0,0};
        int letters = 0;
        
        try {
            
            in = new BufferedReader(new FileReader("src/SISTERSCLEAN.TXT"));
            out = new BufferedWriter(new FileWriter("src/vowelFreq.txt"));
            
            char_ = in.read();
            while (char_ != -1) {
                if (char_ == 65 || char_ == 97) {
                    vowelFreq[0]++;
                } else if (char_ == 69 || char_ == 101) {
                    vowelFreq[1]++;
                } else if (char_ == 73 || char_ == 105) {
                    vowelFreq[2]++;
                } else if (char_ == 79 || char_ == 111) {
                    vowelFreq[3]++;
                } else if (char_ == 85 || char_ == 117) {
                    vowelFreq[4]++;
                }
                System.out.println(char_);
                
                if (char_ != 32) {
                    letters++;
                }
                
                char_ = in.read();
            }
            
            out.write("Percentage of Each Vowel in SISTERSCLEAN.TXT:\n\n");
            for (int i = 0; i < vowels.length; i++) {
                out.write(" " + vowels[i] + ": " + (double) vowelFreq[i]/letters * 100 + "%\n");
            }
            
            in.close();
            out.close();   
            
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
    }
    
}
