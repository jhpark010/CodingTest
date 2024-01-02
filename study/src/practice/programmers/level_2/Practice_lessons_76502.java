package practice.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Practice_lessons_76502 {
	public static void main(String[] args) {
		// Test Case
		String s = "[](){}";
		
		// Answer
		Practice_lessons_76502 p = new Practice_lessons_76502();
		System.out.println(p.solution(s));
		
	}
	
	public int solution(String s) {
		Queue<Character> q = new LinkedList<>();
		int answer = 0;
		
		for (char c : s.toCharArray()) {
			q.add(c);
		}
		
		for (int i = 0; i < s.length(); i++) {
			Queue<Character> qCopy = new LinkedList<>();
			Stack<Character> stack = new Stack<>();
			
			for (char c : q) {
				qCopy.add(c);
			}
			
			for (int j = 0; j < s.length(); j++) {
				char tmp = qCopy.poll();
				
				if (!stack.isEmpty()) {
					char sTmp = stack.peek();
					
					if (sTmp == '[' && tmp == ']') {
						stack.pop();
					} else if (sTmp == '{' && tmp == '}') {
						stack.pop();
					} else if (sTmp == '(' && tmp == ')') {
						stack.pop();
					} else {
						stack.add(tmp);
					}
					
				} else {
					stack.add(tmp);
				}
			}
			
			if (stack.isEmpty()) {
				answer++;
			}
			
			q.add(q.poll());
		}
		
		return answer;
	}
	
}


















