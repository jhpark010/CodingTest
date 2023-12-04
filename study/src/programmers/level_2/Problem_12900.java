package programmers.level_2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_12900 {
	public static void main(String[] args) {
		// Test Case
		int n = 5;
		
		
		// Answer
		Problem_12900 main = new Problem_12900();
		System.out.println(main.solution(n));

	}

	public int solution(int n) {
		long[] dp = new long[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
		}
		
		return (int) dp[n];
	}
	
}













