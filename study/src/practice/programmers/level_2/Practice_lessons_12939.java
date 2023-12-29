package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_12939 {
	public static void main(String[] args) {
		// Test Case
		String s = "-1 -2 -3 -4";
		
		// Answer
		Practice_lessons_12939 p = new Practice_lessons_12939();
		System.out.println(p.solution(s));
		
	}
	
	public String solution(String s) {
		String[] arr = s.split(" ");
		int[] iArr = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			iArr[i] = Integer.parseInt(arr[i]);
		}
		
		Arrays.sort(iArr);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(iArr[0]).append(" ").append(iArr[iArr.length - 1]);
		
		return sb.toString();
	}
	
}


















