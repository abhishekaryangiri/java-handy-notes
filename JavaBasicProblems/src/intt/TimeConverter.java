package intt;

import java.util.Scanner;

public class TimeConverter {
    public static void main(String[] args) {
        // Read input in the format "mm:ss"
        String programInput = readFromInput();

        // Convert the input into total seconds
        int programOutput = getMovieLength(programInput);

        // Print the result
        System.out.println(programOutput);
    }

    private static String readFromInput() {
        // Reading input from STDIN
        Scanner input = new Scanner(System.in);
        String inString = input.next();
        input.close();
        return inString;
    }

    private static int getMovieLength(String time) {
        // Split the input string into minutes and seconds
        String[] parts = time.split(":");
        int minutes = Integer.parseInt(parts[0]); // Extract minutes
        int seconds = Integer.parseInt(parts[1]); // Extract seconds

        // Convert to total seconds
        return minutes * 60 + seconds;
    }
}
