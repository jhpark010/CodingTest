package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver_4_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Silver_4_4949 main = new Silver_4_4949();
		
		while (true) {
			String str = br.readLine();
			
			if (str.equals(".")) {
				break;
			}
			
			sb.append(main.solve(str)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public String solve(String str) {
		Stack<Character> s = new Stack<>();
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[') {
				s.push(str.charAt(i));
				
			} else if (str.charAt(i) == ')') {
				if (s.isEmpty() || s.peek() != '(') {
					return "no";
					
				} else {
					s.pop();
				}
				
			} else if (str.charAt(i) == ']') {
				if (s.isEmpty() || s.peek() != '[') {
					return "no";
					
				} else {
					s.pop();
				}
			}
		}
		
		if (s.isEmpty()) {
			return "yes";
		} else {
			return "no";
		}
	}
}
