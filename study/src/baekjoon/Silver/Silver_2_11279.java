package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Silver_2_11279 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		while (n-- > 0) {
			int m = Integer.parseInt(br.readLine());
			
			if (m == 0 && pq.isEmpty()) {
				sb.append(0).append("\n");
			} else if (m == 0){
				sb.append(pq.poll()).append("\n");
			} else {
				pq.add(m);
			}
		}
		
		System.out.println(sb);
	}
}















