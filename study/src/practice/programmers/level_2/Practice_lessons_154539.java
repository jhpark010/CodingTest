package practice.programmers.level_2;

import java.util.Arrays;
import java.util.Stack;

public class Practice_lessons_154539 {
	public static void main(String[] args) {
		// Test Case
		int[] numbers = {2, 3, 3, 5};
//		int[] numbers = {9, 1, 5, 3, 6, 2};
		
		// Answer
		Practice_lessons_154539 main = new Practice_lessons_154539();
		System.out.println(Arrays.toString(main.solution(numbers)));
		
	}
	
	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Stack<Integer> s = new Stack<>();
		
		Arrays.fill(answer, -1);
		s.push(0);
		
		for (int i = 1; i < numbers.length; i++) {
			while(!s.isEmpty()) {
				int idx = s.pop();
				
				if (numbers[i] > numbers[idx]) {
					answer[idx] = numbers[i];
				} else {
					s.push(idx);
					break;
				}
			}
			s.push(i);
		}
		
		/*
		for (int i = 0; i < numbers.length; i++) {
			int cur = numbers[i];
			int n = -1;
			
			for (int j = i + 1; j < numbers.length; j++) {
				if (cur < numbers[j]) {
					n = numbers[j];
					break;
				}
			}
			answer[i] = n;
		}
		*/
		return answer;
	}
	
}


















