package programmers.level_1;

import java.util.Arrays;

public class Problem_12914 {
	public static void main(String[] args) {
		// Test Case
		int n = 1000;
		
		// Answer
		Problem_12914 p = new Problem_12914();
//		System.out.println(p.solution(brown, yellow));
		System.out.println(p.solution(n));

	}

	public long solution(int n) {
		long[] arr = new long[2001];
		arr[1] = 1;
		arr[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			arr[i] = (arr[i - 2] + arr[i - 1]) % 1234567;
		}
		
		return arr[n];
	}
}













