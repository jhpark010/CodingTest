package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver_5_11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int size = Integer.parseInt(st.nextToken());
		int order = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= size; i++) {
			q.add(i);
		}
		
//		int cnt = 1;
		sb.append("<");
		
		while (q.size() != 1) {
			for (int i = 0; i < order - 1; i++) {
				q.add(q.poll());
			}
			sb.append(q.poll()).append(", ");
			
//			if (cnt == order) {
//				sb.append(q.poll()).append(", ");
//				cnt = 1;
//				
//			} else {
//				q.add(q.poll());
//				cnt++;
//			}
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb);
	}
}
