package _3_1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Sadman
 */
public class NameScoring_2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        (You'll want to use the helpful String.split() and Collections.sort() methods.)
//        After reading names.txt (download from Classroom), which contains over five thousand first names, begin by sorting it into alphabetical order. 
//        Then work out each name score: the sum of the alphabetical value for each letter in the name, multiplied by its alphabetical position in the list. 
//        For example, when the list is sorted into alphabetical order, COLIN is worth 3 + 15 + 12 + 9 + 14 = 53, and is the 938th name in the list. 
//        So, COLIN would obtain a name score of  53 × 938 = 49714.
//        What is the total of all the name scores in the file? Print the answer.
        
        Scanner s = null;
        String line;
        
        try {
            s = new Scanner(new File("src/names.txt"));            
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
        
        line = s.nextLine();
        line = line.substring(1, line.length() - 1);
        
        ArrayList<String> a = new ArrayList<>(Arrays.asList(line.split("\",\"")));        
        Collections.sort(a);      

        int total = 0;
        for (int i = 0; i < a.size(); i++) {
            total += nameScore(a.get(i), i + 1);
        }
        
        // Test program
        System.out.println(a.get(0) + ": " + nameScore(a.get(0), 1));
        System.out.println("Total: " + total);
        
        s.close();
    }
    
    private static int nameScore(String name, int pos) {
        int score = 0;
        for (int i = 0; i < name.length(); i++) {
            score += name.charAt(i) - 64;
        }
        score *= pos;
        return score;
    }
}
