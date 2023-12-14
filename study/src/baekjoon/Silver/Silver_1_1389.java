package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver_1_1389 {
	static boolean[] visited;
	static int N, M, answer;
	static int min = Integer.MAX_VALUE;
	static List<ArrayList<Integer>> list;
	
	static class Info {
		int idx;
		int cost;
		
		Info (int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for (int i = 1; i <= N; i++) {
			solve(i);
		}
		
		System.out.println(answer);
	}
	
	public static void solve(int start) {
		boolean[] visited = new boolean[N + 1];
		visited[start] = true;
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(start, 0));
		int sum = 0;
		
		while (!q.isEmpty()) {
			Info now = q.poll();
			
			for (int next : list.get(now.idx)) {
				if (!visited[next]) {
					visited[next] = true;
					sum += now.cost + 1;
					q.add(new Info(next, now.cost + 1));
				}
			}
		}
		
		if (sum < min) {
			min = sum;
			answer = start;
		}
	}
}















