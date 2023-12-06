package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Silver_2_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		List<Character> list = new ArrayList<>();
		
		boolean flag = false;
		int cur = 1;
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (cur <= num) {
				while(cur <= num) {
					stack.push(cur++);
					list.add('+');
				}
				
				stack.pop();
				list.add('-');
				
			} else {
				int tmp = 0;
				
				while (tmp != num) {
					if (stack.isEmpty()) {
						flag = true;
						break;
					}
					
					tmp = stack.pop();
					list.add('-');
				}
				
				if (flag) break;
			}
		}
		
		if (flag) {
			System.out.println("NO");
		} else {
			StringBuilder sb = new StringBuilder();
			for (char c : list) {
				sb.append(c).append("\n");
			}
			
			System.out.println(sb.toString());
		}
	}
}
