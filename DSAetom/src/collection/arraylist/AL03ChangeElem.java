package collection.arraylist;

import java.util.ArrayList;

public class AL03ChangeElem {
	public static void main(String[] args) {
		ArrayList<Integer> qtya = new ArrayList<>(); 
		qtya.add(100);
		qtya.add(50);
		qtya.add(80);
		
		qtya.set(1, 200);//updating data at specific index
		System.out.println(qtya);
		System.out.println(qtya.size());//know size of list
	}

}
