package programmers.level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Problem_67257 {
	public static void main(String[] args) {
		// Test Case
		String expression = "100-200*300-500+20";
		

		// Answer
		Problem_67257 p = new Problem_67257();
		System.out.println(p.solution(expression));

	}

	public long solution(String expression) {
		long answer = Long.MIN_VALUE;
		Stack<String> s = new Stack<>();
		String tmp = "";
		
		for (int i = expression.length() - 1; i >= 0; i--) {
			if (expression.charAt(i) == '*' ||
					expression.charAt(i) == '-' ||
					expression.charAt(i) == '+') {
				s.push(tmp);
				s.push(String.valueOf(expression.charAt(i)));
				tmp = "";
				
			} else {
				tmp = String.valueOf(expression.charAt(i)) + tmp;
			}
		}
		
		s.push(tmp);
		
		
		// 연산자 우선순위
		List<Long> resultList = new ArrayList<>();
		
		// + > - > *
		Stack<String> copy = (Stack<String>) s.clone();
		
		plus(copy);
		minus(copy);
		multi(copy);

		resultList.add(Math.abs(Long.parseLong(copy.pop())));
		
		// + > * > -
		copy = (Stack<String>) s.clone();
		
		plus(copy);
		multi(copy);
		minus(copy);

		resultList.add(Math.abs(Long.parseLong(copy.pop())));
		
		// - > + > *
		copy = (Stack<String>) s.clone();
		
		minus(copy);
		plus(copy);
		multi(copy);

		resultList.add(Math.abs(Long.parseLong(copy.pop())));
		
		// - > * > +
		copy = (Stack<String>) s.clone();
		
		minus(copy);
		multi(copy);
		plus(copy);

		resultList.add(Math.abs(Long.parseLong(copy.pop())));
		
		// * > - > +
		copy = (Stack<String>) s.clone();
		
		multi(copy);
		minus(copy);
		plus(copy);

		resultList.add(Math.abs(Long.parseLong(copy.pop())));
		
		// * > + > -
		copy = (Stack<String>) s.clone();
		
		multi(copy);
		plus(copy);
		minus(copy);

		resultList.add(Math.abs(Long.parseLong(copy.pop())));
		
		return Collections.max(resultList);
	}
	
	public void plus(Stack<String> s) {
		Stack<String> tmp = new Stack<>();
		
		while(!s.isEmpty()) {
			if (s.size() >= 2) {
				String left = s.pop();
				String mid = s.pop();
				
				if (mid.equals("+")) {
					long val = Long.parseLong(left) + Long.parseLong(s.pop());
					s.push(String.valueOf(val));
					
				} else {
					tmp.push(left);
					tmp.push(mid);
					
				}
			} else {
				while(!s.isEmpty()) {
					tmp.push(s.pop());
				}
			}
		}
		
		while(!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
	}
	
	public void minus(Stack<String> s) {
		Stack<String> tmp = new Stack<>();

		while (!s.isEmpty()) {
			if (s.size() >= 2) {
				String left = s.pop();
				String mid = s.pop();

				if (mid.equals("-")) {
					long val = Long.parseLong(left) - Long.parseLong(s.pop());
					s.push(String.valueOf(val));
					
				} else {
					tmp.push(left);
					tmp.push(mid);
				}
			} else {
				while (!s.isEmpty()) {
					tmp.push(s.pop());
				}
			}
		}

		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
	}
	
	public void multi(Stack<String> s) {
		Stack<String> tmp = new Stack<>();

		while (!s.isEmpty()) {
			if (s.size() >= 2) {
				String left = s.pop();
				String mid = s.pop();

				if (mid.equals("*")) {
					long val = Long.parseLong(left) * Long.parseLong(s.pop());
					s.push(String.valueOf(val));
					
				} else {
					tmp.push(left);
					tmp.push(mid);
				}
			} else {
				while (!s.isEmpty()) {
					tmp.push(s.pop());
				}
			}
		}

		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
	}
}
