package programmers.level_1;

import java.util.Stack;

public class Problem_42883 {
	
	public static void main(String[] args) {
		// Test Case
		String number = "654321";
		int k = 5;
		
		// Answer
		Problem_42883 main = new Problem_42883();
		System.out.println(main.solution(number, k));

	}
	
	
	/*
	 * 스택을 활용한 풀이 간단 명료해서 다시 작성
	 */
	public String solution(String number, int k) {
		Stack<Character> stack = new Stack<>();
		char[] arr = new char[number.length() - k];
		
		for (int i = 0; i < number.length(); i++) {
			if (!stack.isEmpty() && stack.peek() < number.charAt(i)&& k > 0) {
				stack.pop();
				k--;
			}
			stack.push(number.charAt(i));
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = stack.get(i);
		}
		
		return new String(arr);
	}
	
	
	
	/*
	public String solution(String number, int k) {
		int len = number.length() - k;
		StringBuilder answer = new StringBuilder();
		int idx = 0;
		
		while (answer.length() != len) {
			int max = 0;
			int range = k + answer.length() + 1; 
			for (int i = idx; i < range; i++) {
				if (number.charAt(i) - '0' > max) {
					max = number.charAt(i) - '0';
					idx = i + 1;
				}
			}
			
			answer.append(max);
		}
		
		return answer.toString();
	}
	*/
	
}



















