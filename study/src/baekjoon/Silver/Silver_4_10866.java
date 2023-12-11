package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Silver_4_10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		
		while (n-- > 0) {
			list.add(br.readLine());
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(" ")) {
				String[] arr = list.get(i).split(" ");
				if (arr[0].equals("push_front")) {
					dq.offerFirst(Integer.parseInt(arr[1]));
					
				} else if (arr[0].equals("push_back")) {
					dq.offerLast(Integer.parseInt(arr[1]));	
				}
				
			} else {
				String word = list.get(i);
				
				if (word.equals("front")) {
					sb.append((dq.isEmpty() == true ? -1 : dq.peekFirst())).append("\n");
				} else if (word.equals("back")) {
					sb.append((dq.isEmpty() == true ? -1 : dq.peekLast())).append("\n");
				} else if (word.equals("size")) {
					sb.append(dq.size()).append("\n");
				} else if (word.equals("empty")) {
					sb.append((dq.isEmpty() == true ? 1 : 0)).append("\n");
				} else if (word.equals("pop_back")) {
					sb.append((dq.isEmpty() == true ? -1 : dq.pollLast())).append("\n");
				} else if (word.equals("pop_front")) {
					sb.append((dq.isEmpty() == true ? -1 : dq.pollFirst())).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
