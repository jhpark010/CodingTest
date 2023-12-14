package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver_1_1697 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[100001];
		int[] count = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(N);
		visited[N] = true;
		
		while(!q.isEmpty() && !visited[K]) {
			int now = q.poll();
			
			if (now * 2 <= K && !visited[now * 2]) {
				visited[now * 2] = true;
				count[now * 2] = count[now] + 1;
				q.add(now * 2);
			}
			
			if (now + 1 <= K && !visited[now + 1]) {
				visited[now + 1] = true;
				count[now + 1] = count[now] + 1;
				q.add(now + 1);
			}
			
			if (now - 1 >= 0 && !visited[now - 1]) {
				visited[now - 1] = true;
				count[now - 1] = count[now] + 1;
				q.add(now - 1);
			}
		}
		System.out.println(count[K]);
	}
}















