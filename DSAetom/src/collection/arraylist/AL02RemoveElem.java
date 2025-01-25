package collection.arraylist;

import java.util.ArrayList;

public class AL02RemoveElem {
	public static void main(String[] args) {
		//remove element
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(10);
		nums.add(50);
		nums.add(200);
		
		nums.remove(0);///removed 0th index elem
		System.out.println(nums);
		}

}
