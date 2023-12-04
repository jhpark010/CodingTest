package programmers.level_2;

import java.util.Arrays;

public class Problem_42746 {
	public static void main(String[] args) {
		// Test Case
		int[] numbers = {3, 50, 54, 5, 9};
		
		// Answer
		Problem_42746 p = new Problem_42746();
		System.out.println(p.solution(numbers));
		
	}
	
	public String solution(int[] numbers) {
		String[] arr = new String[numbers.length];
		int idx = 0;
		
		for (int num : numbers) {
			arr[idx++] = String.valueOf(num);
		}
		
		
		Arrays.sort(arr, (a1, a2) -> (a2 + a1).compareTo(a1 + a2));
		
		StringBuffer sb = new StringBuffer();
		
		for (String a : arr) {
			sb.append(a);
		}
        
        return sb.toString();
    }
	
}

















