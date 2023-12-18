package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Gold_5_5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			char[] actions = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			Deque<Integer> dq = new ArrayDeque<>();
			
			for (int i = 0; i < n; i++) {
				dq.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean isArrow = true; // true : 앞, false : 뒤
			boolean errorFlag = false;
			
			for (int i = 0; i < actions.length; i++) {
				if (actions[i] == 'R') {
					isArrow = !isArrow;
				} else if (actions[i] == 'D') {
					if (dq.isEmpty()) {
						errorFlag = true;
						break;
					}
					
					if (isArrow) {
						dq.pollFirst();
					} else {
						dq.pollLast();
					}
				}
			}
			
			if (errorFlag) {
				sb.append("error").append("\n");
				continue;
			} else {
				sb.append("[");
				
				if (dq.size() > 0) {
						if (isArrow) {
						sb.append(dq.pollFirst());

						while (!dq.isEmpty()) {
							sb.append(",").append(dq.pollFirst());
						}

					} else {
						sb.append(dq.pollLast());

						while (!dq.isEmpty()) {
							sb.append(",").append(dq.pollLast());
						}
					}
				}
				sb.append("]").append("\n");
			}
		}
		System.out.println(sb);
	}
}

















	
	
	
	
	
	
	



