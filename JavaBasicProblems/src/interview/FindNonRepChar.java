package interview;

import java.util.HashMap;
import java.util.Map;

public class FindNonRepChar {
public static void main(String[] args) {
	//find non repeating char.
    String str = "abhishekak";
    Map<Character, Integer> freq = new HashMap<>();
    for(char ch:str.toCharArray()){
        freq.put(ch, freq.getOrDefault(ch, 0)+1);
        
    }
   for(char ch: freq.keySet()){
       if(freq.get(ch)==1){
           System.out.println(ch);
       }
   }
}
}
