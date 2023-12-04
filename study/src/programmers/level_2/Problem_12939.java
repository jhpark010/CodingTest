package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem_12939 {
	public static void main(String[] args) {
		// Test Case
		String s = "-1 -1";
		
		// Answer
		Problem_12939 p = new Problem_12939();
		System.out.println(p.solution(s));
		
	}
	
	List<String> answerList;
	boolean[] visited;
	
	public String solution(String s) {
		String[] arr = s.split(" ");
		int[] iArr = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			iArr[i] = Integer.parseInt(arr[i]);
		}
		
		Arrays.sort(iArr);
		
		String answer = iArr[0] + " " + iArr[iArr.length - 1];
		
		
        return answer;
	}
	
}


















