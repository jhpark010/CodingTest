package programmers.level_2;

import java.util.Arrays;

public class Problem_12985 {
	public static void main(String[] args) {
		// Test Case
		int[] people = {50, 40, 40, 50, 40};
		int limit = 120;
		
		// Answer
		Problem_12985 p = new Problem_12985();
//		System.out.println(p.solution(brown, yellow));
		System.out.println(p.solution(people, limit));

	}

	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		
		int lt = 0;
		int rt = people.length - 1;
		
		while (lt <= rt) {
			if (people[lt] + people[rt] > limit) {
				rt --;
				answer ++;
				
			} else {
				lt ++;
				rt --;
				answer ++;
			}
		}
		
		
		return answer;
	}
	
}













