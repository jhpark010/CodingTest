package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Problem_87946 {
	public static void main(String[] args) {
		// Test Case
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
//		int[][] dungeons = {{7,3},{5,4},{1,1}};
//		int[][] dungeons = {{9,2},{10,3},{7,3},{5,4},{1,1}};
		
		

		// Answer
		Problem_87946 p = new Problem_87946();
		System.out.println(p.solution(k, dungeons));

	}

	int answer = Integer.MIN_VALUE;
	boolean[] visited;
	
	public int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		
		dfs(0, dungeons, k);
		
		return answer;
	}
	
	public void dfs(int cnt, int[][] dungeons, int stamina) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && stamina >= dungeons[i][0]) {
				visited[i] = true;
				dfs(cnt + 1 , dungeons, stamina - dungeons[i][1]);
				visited[i] = false;
			}
		}
		
		answer = Math.max(answer, cnt);
	}
	
//	class Info {
//		int stamina;
//		int decrease;
//		
//		Info(int stamina, int decrease) {
//			this.stamina = stamina;
//			this.decrease = decrease;
//		}
//	}

}
