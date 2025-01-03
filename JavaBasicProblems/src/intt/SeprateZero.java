package intt;

public class SeprateZero {
public static void main(String[] args) {
	long num = 102300560L;
	System.out.println(moveZero(num));
}

public static long moveZero(long num) {
	String numStr = String.valueOf(num);
	int zeroCount = 0;
	
	StringBuilder nonZeroDig = new StringBuilder();
	
	for(char c:numStr.toCharArray()) {
		if (c == '0') {
			zeroCount++;
		}else {
			nonZeroDig.append(c);
		}
	}
	  // Instead of using String.repeat(), manually append '0' characters
	for(int i=0;i<zeroCount;i++) {
		nonZeroDig.append('0');
	}
	//nonZeroDig.append("0".repeat(zeroCount));
	return Long.parseLong(nonZeroDig.toString());
	
}
}
