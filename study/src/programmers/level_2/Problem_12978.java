package programmers.level_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_12978 {
	public static void main(String[] args) {
		// Test Case
		int N = 5;
		int K = 3;
		int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};

		// Answer
		Problem_12978 p = new Problem_12978();
		System.out.println(p.solution(N, K, road));

	}

	public int solution(int N, int K, int[][] road) {
		int answer = 0;
		List<ArrayList<Info>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) list.add(new ArrayList<>());
		
		for (int i = 0; i < road.length; i++) {
			list.get(road[i][0]).add(new Info(road[i][0], road[i][1], road[i][2]));
			list.get(road[i][1]).add(new Info(road[i][1], road[i][0], road[i][2]));
		}
		
		answer = bfs(1, list, K, N);
		
		return answer;
	}
	
	public int bfs(int start, List<ArrayList<Info>> list, int K, int N) {
		int[] visited = new int[N + 1];
		Queue<Info> q = new LinkedList<>();
		int cnt = 1;
		
		for (int i = 2; i <= N; i++) {
			visited[i] = Integer.MAX_VALUE;
		}
		
		q.addAll(list.get(start));
		
		while(!q.isEmpty()) {
			Info tmp = q.poll();

			if (visited[tmp.end] > visited[tmp.start] + tmp.cost) {
				visited[tmp.end] = visited[tmp.start] + tmp.cost;
				q.addAll(list.get(tmp.end));
			}
		}
		
		for (int i = 2; i <= N; i++) {
			if (visited[i] <= K) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
	
	class Info {
		int start;
		int end;
		int cost;
		
		Info (int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
}



