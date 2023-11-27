package programmers.level_1;

import java.util.Arrays;
import java.util.Stack;

public class Problem_154539 {
	public static void main(String[] args) {
		// Test Case
//		int[] numbers = {2, 3, 3, 5};
		int[] numbers = {9, 1, 5, 3, 6, 2};

		// Answer
		Problem_154539 main = new Problem_154539();
		System.out.println(Arrays.toString(main.solution(numbers)));

	}

	public int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Stack<Integer> stack = new Stack<>();
		
		stack.push(0);
		
		for (int i = 1; i < numbers.length; i++) {
			while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				answer[stack.pop()] = numbers[i];
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			answer[stack.pop()] = -1;
		}

		return answer;
	}
}
