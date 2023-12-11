package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver_4_9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		while (n-- > 0) {
			Stack<String> s = new Stack<>();
			String[] arr = br.readLine().split("");
			boolean flag = true;
			
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("(")) {
					s.push(arr[i]);
					
				} else {
					if (s.isEmpty() || s.peek().equals(")")) {
						flag = false;
						break;
					} else {
						s.pop();
					}
				}
			}
			
			if (flag && s.isEmpty()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
}
