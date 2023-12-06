package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Silver_5_2751 {
	/*
	 * 직접 푼 풀이
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i <= n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	/*
	 * counting sort 를 활용한 아래 풀이 (메모리, 속도면에서 월등)
	 */
	/*
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		boolean[] arr = new boolean[2000001];
		
		for (int i = 1; i <= n; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]) {
				sb.append((i - 1000000)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	*/
}
