package intt;

import java.util.*;

public class FishSanctuary {
    public static void main(String[] args) {
        int[] replies = readArrayFromInput();
        int result = getNumFishes(replies);
        System.out.println(result);
    }

    public static int[] readArrayFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the survey replies separated by spaces:");
        String[] tokens = scanner.nextLine().split(" ");
        int[] intArray = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            intArray[i] = Integer.parseInt(tokens[i]);
        }
        scanner.close();
        return intArray;
    }

    public static int getNumFishes(int[] replies) {
        // Count the frequency of each reply
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int reply : replies) {
            countMap.put(reply, countMap.getOrDefault(reply, 0) + 1);
        }

        int totalFishes = 0;

        // Calculate the minimum number of fishes needed
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int reply = entry.getKey();   // Each unique response
            int count = entry.getValue(); // Count of fishes giving this response

            // The group size for each reply is reply + 1
            int groupSize = reply + 1;

            // The number of groups required for these fishes
            // We need to divide the count of fishes by the group size
            // and round up to the next whole group if there are leftovers
            int groups = (count + groupSize - 1) / groupSize; 

            // Calculate the number of fishes for these groups
            totalFishes += groups * groupSize;
        }

        return totalFishes;
    }
}
