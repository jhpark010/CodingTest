package programmers.level_1;

import java.util.Stack;

public class Problem_12973 {
	public static void main(String[] args) {
		// Test Case
		String s = "cdcd";
		
		// Answer
		Problem_12973 p = new Problem_12973();
		System.out.println(p.solution(s));

	}

	public long solution(String s) {
		int answer = 1;
		Stack<Character> stack = new Stack<>();
		
		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				if (c == stack.peek()) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}
		}
		
		if (!stack.isEmpty()) {
			answer = 0;
		}
		
		
		
		return answer;
	}
}













