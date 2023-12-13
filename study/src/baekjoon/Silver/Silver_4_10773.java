package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver_4_10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		while (k-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0) {
				stack.pop();
			} else {
				stack.push(n);
			}
		}
		
		int sum = 0;
		
		for (int num : stack) {
			sum += num;
		}
		
		System.out.println(sum);
	}
}
