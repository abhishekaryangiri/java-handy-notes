
package basicproblems;

import java.util.HashSet;

public class Array0202FindDublicateNumJava8 {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 50, 40, 20};
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums) {
            if (!hs.add(i)) {
                System.out.println("Duplicate No: " + i);
                break;
            }
        }
    }
}
