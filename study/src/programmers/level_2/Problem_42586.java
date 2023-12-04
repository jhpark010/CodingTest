package programmers.level_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_42586 {
	public static void main(String[] args) {
		// Test Case
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
//		int[] progresses = {50, 90, 99, 99, 80, 90, 40};
//		int[] speeds = {1, 1, 1, 1, 1, 1, 1};
		
		// Answer
		Problem_42586 p = new Problem_42586();
		for (int n : p.solution(progresses, speeds)) {
			System.out.print(n + " ");
		}
	}
	
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < speeds.length; i++) {
			int cnt = 0;
			
			while (progresses[i] < 100) {
				progresses[i] += speeds[i];
				cnt ++;
			}
			q.offer(cnt);
		}
		
		int firstData = q.poll();
		int datas = 1;
		
		while (!q.isEmpty()) {
			if (firstData >= q.peek()) {
				datas += 1;
				q.poll();
			} else {
				answer.add(datas);
				datas = 1;
				firstData = q.poll();
			}
		}
		
		answer.add(datas);
		
		return answer.stream().mapToInt(Integer::intValue).toArray(); 
	}
}

















