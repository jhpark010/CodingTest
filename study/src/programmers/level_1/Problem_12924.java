package programmers.level_1;

import java.util.Arrays;

public class Problem_12924 {
	public static void main(String[] args) {
		// Test Case
		int n = 15;

		// Answer
		Problem_12924 p = new Problem_12924();
		System.out.println(p.solution(n));

	}

	public int solution(int n) {
		int answer = 0;
		int lt = 1;
		int rt = 1;
		int sum = 0;
		
		for (; rt <= n; rt++) {
			sum += rt;
		
			if (sum == n) {
				answer ++;
			}
			
			while (sum > n) {
				sum -= lt++;
				
				if (sum == n) {
					answer ++;
				}
			}
		}
		return answer;
	}
}













