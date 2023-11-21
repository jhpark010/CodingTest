package programmers.level_1;

import java.math.BigInteger;

public class Problem_12945 {
	public static void main(String[] args) {
		// Test Case
		int n = 100000;
		
		// Answer
		Problem_12945 p = new Problem_12945();
		System.out.println(p.solution(n));

	}

	public long solution(int n) {
		long[] arr = new long[100001];
		arr[1] = 1 % 1234567;
		arr[2] = 1 % 1234567;
		
		for (int i = 3; i <= n; i++) { 
			arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
		}
		
		int answer = (int)arr[n];
		
		return answer;
	}
}













