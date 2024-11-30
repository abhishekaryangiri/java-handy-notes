package basicproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array0201CombineArrayandShort {
	//print
public static void main(String[] args) {
	int[] nums1 = {1,2,3,0,0,0,0};
	int[] nums2 = {2,5,6,7};
	
	 List<Integer> combList = new ArrayList<>();
	 
	 for( int num : nums1) {
		 if(num !=0) {
			 combList.add(num);
		 }
	 }
	 for(int num : nums2) {
		 if(num!=0) {
			 combList.add(num);
		 }
	 }
	 
	 int[] op = combList.stream().mapToInt(Integer::intValue).toArray();
	 
	 Arrays.sort(op);
	 System.out.println(Arrays.toString(op));
	
	 
}
}
