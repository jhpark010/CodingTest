package practice.programmers.level_2;

import java.util.Stack;

public class Practice_lessons_12909 {
	public static void main(String[] args) {
		// Test Case
//		String s = "(()))()";
		String s = ")()(";
		
		// Answer
		Practice_lessons_12909 p = new Practice_lessons_12909();
		System.out.println(p.solution(s));
		
	}
	
	public boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		
		if (!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}
	
}


















