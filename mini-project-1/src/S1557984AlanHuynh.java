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

public class S1557984AlanHuynh {
    public static void main(String[] args) {
        try (Scanner s1557984Scanner = new Scanner(System.in)) {

            System.out.println("Welcome to Alan's North Melbourne Web!");

            String s1557984InputText;
            int s1557984Torelance = 5;
            do {
                System.out.print("Please enter your review: ");
                // Use trim() to remove any leading/trailing whitespace or only space entry
                s1557984InputText = s1557984Scanner.nextLine().trim(); 

                if (s1557984InputText.isEmpty()) {
                    // Add new line to make it look nicer :D
                    System.err.println("Review cannot be empty. Please try again.\n"); 

                    s1557984Torelance--;

                    if (s1557984Torelance == 0) {
                        System.err.println("Too many invalid entries. Exiting...");
                        System.exit(1);
                    }
                }

            } while (s1557984InputText.isEmpty());

            String s1557984Breakdown = calculateVowels(s1557984InputText);

            System.out.println(s1557984Breakdown);
        }
    }
    
    private static String calculateVowels(String text) {

        int s1557984TotalVowels = 0;
        // Use StringBuilder for easier string concatenation
        StringBuilder s1557984Breakdown = new StringBuilder();
    
        String[] words = text.split(" ");
        for (String word : words) {
            // Count the number of vowels in each word
            int s1557984NumVowels = 0;
            
            for (char s1557984C : word.toCharArray()) {
                if (isVowel(s1557984C)) {
                    s1557984NumVowels++;
                }
            }

            s1557984Breakdown.append(s1557984NumVowels).append(" + ");
            s1557984TotalVowels += s1557984NumVowels;
        }
    
        if (s1557984Breakdown.length() > 0) {
            // Remove the last " + " and add the total count
            s1557984Breakdown.setLength(s1557984Breakdown.length() - 3);
            s1557984Breakdown.append(" = ").append(s1557984TotalVowels);
        }
    
        return s1557984Breakdown.toString();
    }
    
    private static boolean isVowel(char s1557984C) {
        return "AEIOUaeiou".indexOf(s1557984C) != -1;
    }    
}
