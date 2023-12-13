package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver_2_1260 {
	static int[][] graph;
	static boolean[] visited;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		DFS(v);
		System.out.println();
		BFS(v);
		
		
	}
	
	public static void DFS(int start) {
		System.out.print(start + " ");
		visited[start] = true;
		
		for (int i = 1; i <= n; i++) {
			if (graph[start][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}
	}
	
	public static void BFS(int start) {
		String ans = start + " ";
		visited = new boolean[n + 1];
		visited[start] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			
			for (int i = 1; i <= n; i++) {
				if (graph[tmp][i] == 1 && !visited[i]) {
					visited[i] = true;
					ans += i + " ";
					q.add(i);
				}
			}
		}
		System.out.println(ans);
	}
}	

















	
	
	
	
	
	
	



