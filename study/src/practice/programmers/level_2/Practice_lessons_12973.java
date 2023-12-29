package practice.programmers.level_2;

import java.util.Stack;

public class Practice_lessons_12973 {
	public static void main(String[] args) {
		// Test Case
		String s = "cdcd";
		
		// Answer
		Practice_lessons_12973 p = new Practice_lessons_12973();
		System.out.println(p.solution(s));
		
	}
	
	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		
		for (int i = 1; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}
		
		if (!stack.isEmpty()) {
			return 0;
		}
		
		return 1;
	}
	
}


















