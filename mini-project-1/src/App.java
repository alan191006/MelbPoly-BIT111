/*
#####################################
#    Author: Alan Huynh (s1557984)  #
#    Project: Mini Porject 1        #
#    Date: August 13, 2024          #
#    OS: Fedora 34                  #
#    JDK Version: 21.0.4.7          #
#####################################
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("\nWelcome to Alan's North Melbourne Web!");

            String inputText;

            // Tolerate up to 5 invalid entries
            // After 5 invalid entries, exit the program
            int tolerance = 5;
            do {
                System.out.print("Please enter your review: ");
                // Use trim() to remove any leading/trailing whitespace or only space entry
                inputText = scanner.nextLine().trim(); 

                if (inputText.isEmpty()) {
                    // Add new line to make it look nicer :D
                    System.err.println("Review cannot be empty. Please try again.\n"); 

                    tolerance--;

                    if (tolerance == 0) {
                        System.err.println("Too many invalid entries. Exiting...");
                        System.exit(1);
                    }
                }

            } while (inputText.isEmpty());

            String breakdown = calculateVowels(inputText);

            System.out.println(breakdown);
        }
    }
    
    private static String calculateVowels(String text) {

        int totalVowels = 0;

        // Use StringBuilder for easier string concatenation
        StringBuilder breakdown = new StringBuilder();
    
        String[] words = text.split(" ");
        for (String word : words) {
            // Count the number of vowels in each word
            int numVowels = 0;
            
            for (char c : word.toCharArray()) {
                if (isVowel(c)) {
                    numVowels++;
                }
            }

            breakdown.append(numVowels).append(" + ");
            totalVowels += numVowels;
        }
    
        if (breakdown.length() > 0) {
            // Remove the last " + " and add the total count
            breakdown.setLength(breakdown.length() - 3);
            breakdown.append(" = ").append(totalVowels);
        }
    
        return breakdown.toString();
    }
    
    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }    
}
