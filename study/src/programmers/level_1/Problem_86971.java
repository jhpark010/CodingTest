package programmers.level_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_86971 {
	
	public static void main(String[] args) {
		// Test Case
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		// Answer
		Problem_86971 main = new Problem_86971();
		System.out.println(main.solution(n, wires));

	}
	
	//양방향 인접리스트로 구현
	List<ArrayList<Integer>> list;
	boolean[] visited;
	
	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		list = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int[] wire : wires) {
			list.get(wire[0]).add(wire[1]);
			list.get(wire[1]).add(wire[0]);
		}
		
		for (int i = 0; i < wires.length; i++) {
			visited = new boolean[n + 1];
			int a = wires[i][0];
			int b = wires[i][1];
			
			list.get(a).remove(Integer.valueOf(b));
			list.get(b).remove(Integer.valueOf(a));
			
			int cnt = dfs(1);
			answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
			
			list.get(a).add(Integer.valueOf(b));
			list.get(b).add(Integer.valueOf(a));
			
		}
		
		return answer;
	}
	
	public int dfs(int index) {
		visited[index] = true;
		int cnt = 1;
		
		for (int i = 0; i < list.get(index).size(); i++) {
			if (!visited[list.get(index).get(i)]) {
				cnt += dfs(list.get(index).get(i));
			}
		}
		
		return cnt;
	}
}

























