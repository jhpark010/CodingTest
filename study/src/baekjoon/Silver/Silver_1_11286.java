package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Silver_1_11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});
		
		while (n-- > 0) {
			int m = Integer.parseInt(br.readLine());
			
			if (m == 0 && pq.isEmpty()) {
				sb.append(0).append("\n");
			} else if (m == 0){
				int[] tmp = pq.poll();
				
				if (tmp[1] == 0) {
					sb.append('-').append(tmp[0]).append("\n");
				} else {
					sb.append(tmp[0]).append("\n");
				}
			} else {
				if (m > 0) {
					pq.add(new int[] {Math.abs(m), 1});
				} else {
					pq.add(new int[] {Math.abs(m), 0});
				}
			}
		}
		
		System.out.println(sb);
	}
}















