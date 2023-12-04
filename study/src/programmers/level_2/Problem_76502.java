package programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem_76502 {
	public static void main(String[] args) {
		// Test Case
		String s = "[](){}";

		// Answer
		Problem_76502 p = new Problem_76502();
		System.out.println(p.solution(s));

	}

	public int solution(String s) {
		int answer = 0;
		Queue<Character> q = new LinkedList<>();

		for (char c : s.toCharArray()) {
			q.add(c);
		}

		for (int i = 0; i < s.length(); i++) {
			Queue<Character> copy = new LinkedList<>();
			Stack<Character> stack = new Stack<>();
			
			for (char c : q) {
				copy.add(c);
			}

			for (int j = 0; j < s.length(); j++) {
				char c = copy.poll();

				if (!stack.isEmpty()) {
					char stackC = stack.peek();

					if (c == ')' && stackC == '(') {
						stack.pop();
					} else if (c == '}' && stackC == '{') {
						stack.pop();
					} else if (c == ']' && stackC == '[') {
						stack.pop();

					} else {
						stack.push(c);
					}

				} else {
					stack.push(c);
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
