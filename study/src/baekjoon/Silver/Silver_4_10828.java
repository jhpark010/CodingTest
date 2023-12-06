package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Silver_4_10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		List<String> list = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			list.add(br.readLine());
		}
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			
			if (str.contains(" ")) {
				String[] arr = str.split(" ");
				
				s.push(Integer.parseInt(arr[1]));
				
			} else {
				if (str.equals("pop")) {
					if (s.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(s.pop());
					}
				} else if (str.equals("size")) {
					System.out.println(s.size());
					
				} else if (str.equals("empty")) {
					if (s.isEmpty()) {
						System.out.println(1);
					} else {
						System.out.println(0);
					}
					
				} else if (str.equals("top")) {
					if (s.isEmpty()) {
						System.out.println(-1);
					} else {
						System.out.println(s.peek());
					}
				}
			}
		}
	}
}
