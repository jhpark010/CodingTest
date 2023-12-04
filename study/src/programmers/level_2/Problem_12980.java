package programmers.level_2;

import java.util.Arrays;
import java.util.Stack;

public class Problem_12980 {
	public static void main(String[] args) {
		// Test Case
		int n = 5000;
		
		// Answer
		Problem_12980 p = new Problem_12980();
//		System.out.println(p.solution(brown, yellow));
		System.out.println(p.solution(n));

	}

	public int solution(int N) {
		int answer = 0;
		
		while (N != 0) {
			if (N % 2 == 0) {
				N = N / 2;
				
			} else {
				N = N - 1;
				answer ++;
			}
		}
		
		return answer;
	}
	
}













