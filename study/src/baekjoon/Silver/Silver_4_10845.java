package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Silver_4_10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		
		while (n-- > 0) {
			list.add(br.readLine());
		}
		
		Queue<Integer> q = new LinkedList<>();
		int backNum = -1;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).contains(" ")) {
				q.add(Integer.parseInt(list.get(i).split(" ")[1]));
				
			} else {
				String word = list.get(i);
				
				if (word.equals("front")) {
					sb.append((q.isEmpty() == true ? -1 : q.peek())).append("\n");
				} else if (word.equals("back")) {
					sb.append((q.isEmpty() == true ? -1 : backNum)).append("\n");
				} else if (word.equals("size")) {
					sb.append(q.size()).append("\n");
				} else if (word.equals("empty")) {
					sb.append((q.isEmpty() == true ? 1 : 0)).append("\n");
				} else if (word.equals("pop")) {
					sb.append((q.isEmpty() == true ? -1 : q.poll())).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
