package intt;

import java.util.*;

public class WordSorter {
    public static void main(String[] args) {
        String programInput = readFromInput();
        String programOutput = getSortedString(programInput);
        System.out.println(programOutput);
    }

    private static String readFromInput() {
        // Reading the input from STDIN
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the sentence with embedded numbers:");
        String inString = input.nextLine();
        input.close();
        return inString;
    }

    private static String getSortedString(String str) {
        // Split the input string into words
        String[] words = str.split(" ");

        // Create a map to store the words and their positions
        TreeMap<Integer, String> sortedWords = new TreeMap<>();

        // Loop through each word to extract the number and store in the map
        for (String word : words) {
            String numStr = word.replaceAll("[^0-9]", ""); // Extract number from word
            int position = Integer.parseInt(numStr); // Convert number to integer
            String cleanWord = word.replaceAll("[0-9]", ""); // Remove the number from the word
            sortedWords.put(position, cleanWord); // Map the position to the word
        }

        // Join the sorted words into a sentence
        return String.join(" ", sortedWords.values());
    }
}
