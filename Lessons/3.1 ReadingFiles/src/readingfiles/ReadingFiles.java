package readingfiles;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFiles {

    /*
    Exercises.
    There are two files in this project in the src folder. You can view them
    in NetBeans, but don't change them! Don't forget to CLOSE the files when 
    you are done with them! (There is a lot of opening and closing -- this is 
    done on purpose for practice.)
     */
    public static void main(String[] args) {
        // note the forward slash rather than back slash in the file path
        File words = new File("src/words.txt");
        // change the line below to open numbers.txt
        File numbers = new File("src/numbers.txt");
        
        Scanner reader = null;        
        String line;

        // Exercise 0: Open the file words.txt and print each line
        System.out.println("Exercise 0");
        
        try {
            reader = new Scanner(words);
            while (reader.hasNext()) {
                line = reader.nextLine();
                System.out.println(line);
                
            }
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
        // close the file after each exercise when done
        
        reader.close();

        // Exercise 1: Open the file words.txt and print each 
        //             word on its own line
        System.out.println("\nExercise 1");
        
        try {
            reader = new Scanner(words);
            while (reader.hasNext()) {
                line = reader.next();
                System.out.println(line);
            }
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
        
        reader.close();

        // Exercise 2: Open the file words.txt and add each 
        //             word to an ArrayList of Strings
        System.out.println("\nExercise 2");

        ArrayList<String> wordList = new ArrayList<>();
        try {
            reader = new Scanner(words);
            while (reader.hasNext()) {
                line = reader.next();
                wordList.add(line);
            }
            System.out.println(wordList.toString());
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
        
        reader.close();
        
        // Exercise 3: Open the file numbers.txt and find and
        //             print the sum of the integers
        System.out.println("\nExercise 3");
        
        try {
            reader = new Scanner(numbers);
            int sum = 0;
            while (reader.hasNext()) {
                line = reader.next();
                sum += Integer.parseInt(line);
//                System.out.println(Integer.parseInt(line));
//                System.out.println("Sum: " + sum);                
            }
            System.out.println("Sum: " + sum);
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
        
        reader.close();
        
        // Exercise 4: Open the file numbers.txt and add each 
        //             integer to an ArrayList<Integer>; print the list;
        //             compute and print the sum of the ArrayList
        System.out.println("\nExercise 4");
        
        ArrayList<Integer> intList = new ArrayList<>();
        try {
            reader = new Scanner(numbers);
            int sum = 0;
            
            while (reader.hasNext()) {
                int num = Integer.parseInt(reader.next());
                intList.add(num);
                sum += num;                
            }
            
            System.out.println(intList.toString());
            System.out.println("Sum: " + sum);
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }

        reader.close();
        
        // Exercise 5: Open the file numbers.txt and add them
        //             to a 3x10 array of int, where the first row of the file
        //             is the first row of the array, etc. Print the array.
        System.out.println("\nExercise 5");
        
        try {
            reader = new Scanner(numbers);
            int[][] array = new int[3][10];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 10; j++) {
                    array[i][j] = Integer.parseInt(reader.next());
                }                
            }
            System.out.println(Arrays.deepToString(array));
        } catch (IOException iox) {
            System.out.println(iox.getMessage());
        }
        
        reader.close();
    }

}
