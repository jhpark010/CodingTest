package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_43165 {
	public static void main(String[] args) {
		// Test Case
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		// Answer
		Practice_lessons_43165 p = new Practice_lessons_43165();
		System.out.println(p.solution(numbers, target));
		
	}
	
	int answer = 0;
	
	public int solution(int[] numbers, int target) {
		dfs(numbers, 0, 0, target, 0);
		
		return answer;
	}
	
	public void dfs(int[] numbers, int level, int sum, int target, int idx) {
		if (level > numbers.length) {
			return;
		}
		
		if (numbers.length == level) {
			if (sum == target) {
				answer++;
			}
			
		} else {
			dfs(numbers, level + 1, sum + numbers[idx], target, idx + 1);
			dfs(numbers, level + 1, sum - numbers[idx], target, idx + 1);
		}
	}
	
}


















