package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver_3_1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			Queue<Info> q = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			
			for (int i = 0; i < size; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				q.add(new Info(i, num));
				pq.add(num);
			}
			
			int cnt = 0;
			
			while (!q.isEmpty()) {
				Info tmp = q.poll();
				
				if (tmp.num == pq.peek()) {
					cnt ++;
					pq.poll();
					
					if (tmp.idx == idx) break;
					
				} else {
					q.add(tmp);
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class Info {
		int idx;
		int num;
		
		Info (int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}
}
