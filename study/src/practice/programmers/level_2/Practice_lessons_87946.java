package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practice_lessons_87946 {
	public static void main(String[] args) {
		// Test Case
		int k = 80;
		int[][] dungeons = {{80, 20},{50, 40},{30, 10}};
		
		// Answer
		Practice_lessons_87946 p = new Practice_lessons_87946();
		System.out.println(p.solution(k, dungeons));
		
	}
	List<int[]> list;
	boolean[] visited;
	int answer = 0;
	
	public int solution(int k, int[][] dungeons) {
		list = new ArrayList<>();
		visited = new boolean[dungeons.length];
		
		for (int[] dungeon : dungeons) {
			list.add(dungeon);
		}
		
		dfs(k, 0, 0);
		
		return answer;
	}
	
	public void dfs(int k, int level, int cnt) {
		if (k < 0) {
			return;
		}
		
		if (level == list.size()) {
			answer = Math.max(answer, cnt);
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (!visited[i] && k >= list.get(i)[0]) {
					visited[i] = true;
					dfs(k - list.get(i)[1], level + 1, cnt + 1);
//					dfs(k, level + 1, cnt);
					visited[i] = false;
				}
			}
		}
	}
	
}


















