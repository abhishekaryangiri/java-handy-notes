package basicproblems;

public class J02FindDublicateandCount {
	public static void main(String[] args) {
		int[] arr = {1,2,3,1,2,3,1,1,1,5,6,6};
		findDublicate(arr);
	}

	public static void findDublicate(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			if(arr[i] == -1) {
				continue;//skip already counted elem
			}
			int count = 1;
			for(int j=i+1; j<n; j++) {
				if(arr[i]==arr[j]) {
					count++;
					arr[j] = -1;//mark dub as proc
				}
			}
			if(count > 1) {
				System.out.println(arr[i]+ " ---> "+count);
			}
		}
		
	}

}
