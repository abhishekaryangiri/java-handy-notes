package interview;

import java.util.Arrays;
import java.util.Comparator;

public class SortingInAssOrderUsingCustFunc {
public static void main(String[] args) {
    Integer[] arr = {89,8,33,887,67,10, 900};
    
    Arrays.sort(arr, new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return a-b;
        }
    });
    System.out.println(Arrays.toString(arr));
}
}
