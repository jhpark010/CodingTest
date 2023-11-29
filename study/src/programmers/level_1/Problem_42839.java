package programmers.level_1;

import java.util.HashSet;

public class Problem_42839 {
	
	public static void main(String[] args) {
		// Test Case
		String numbers = "011";
//		String numbers = "17";
		
		// Answer
		Problem_42839 main = new Problem_42839();
		System.out.println(main.solution(numbers));

	}
	
	boolean[] visited;
	HashSet<Integer> hs;
	
	public int solution(String numbers) {
		int answer = 0;
		char[] nums = numbers.toCharArray();
		visited = new boolean[nums.length];
		hs = new HashSet<>();
		
		dfs(0, nums, "");
		
		for (int n : hs) {
			if (isPrime(n)) {
				answer ++;
			}
		}
		
		return answer;
	}
	
	public boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public void dfs (int level, char[] nums, String value) {
		if (level == nums.length) {
			return;
			
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					hs.add(Integer.parseInt(value + nums[i]));
					dfs(level + 1, nums, value + nums[i]);
					visited[i] = false;
				}
			}
		}
	}
}



















