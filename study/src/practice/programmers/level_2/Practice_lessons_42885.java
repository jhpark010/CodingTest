package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_42885 {
	public static void main(String[] args) {
		// Test Case
		int[] people = {70, 50, 80};
//		int[] people = {30, 30, 30, 40};
		int limit = 80;
		
		// Answer
		Practice_lessons_42885 p = new Practice_lessons_42885();
		System.out.println(p.solution(people, limit));
		
	}
	
	public int solution(int[] people, int limit) {
		Arrays.sort(people);
		int lt = 0;
		int rt = people.length - 1;
		int answer = 0;
		
		while (lt <= rt) {
			if (people[lt] + people[rt] <= limit) {
				answer++;
				lt++;
				rt--;
				
			} else {
				rt--;
				answer++;
			}
		}
		
		return answer;
	}
	
}


















