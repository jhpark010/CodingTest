package programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_43164 {
	public static void main(String[] args) {
		// Test Case
//		String[][] tickets = {{"ICN", "JFK"}, {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		
		// Answer
		Problem_43164 p = new Problem_43164();
//		System.out.println(p.solution(tickets));
		System.out.println(Arrays.toString(p.solution(tickets)));
		
	}
	
	List<String> answerList;
	boolean[] visited;
	
	public String[] solution(String[][] tickets) {
        answerList = new ArrayList<>();
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
		Collections.sort(answerList);
		
        return answerList.get(0).split(" ");
	}
	
	public void dfs(int level, String now, String path, String[][] tickets) {
		if (level == tickets.length) {
			answerList.add(path);
			return;
			
		} else {
			for (int i = 0; i < tickets.length; i++) {
				if (!visited[i] && now.equals(tickets[i][0])) {
					visited[i] = true;
					dfs(level + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
					visited[i] = false;
				}
			}
		}
	}
	
}


















