package collection.arraylist;

import java.util.ArrayList;

public class AL04SeaerchNum {
public static void main(String[] args) {
	ArrayList<String> names = new ArrayList<String>();
	names.add("Qtya");
	names.add("Mayank");
	names.add("Sima");
	names.add("Gita");
   	for(String i: names) {
   		System.out.println(i);
   	}
	if(names.contains("Gita")) {
		System.out.println("Name found in the list");
	}else {
		System.out.println("Name not found");
	}
}
}
