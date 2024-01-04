package practice.programmers.level_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice_lessons_42587 {
	public static void main(String[] args) {
		// Test Case
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		
		// Answer
		Practice_lessons_42587 p = new Practice_lessons_42587();
		System.out.println(p.solution(priorities, location));
		
	}
	
	public int solution(int[] priorities, int location) {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 0; i < priorities.length; i++) {
			q.add(priorities[i]);
		}
		
		Arrays.sort(priorities);
		
		int answer = 0;
		int maxIdx = priorities.length - 1;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			if (tmp == priorities[maxIdx - answer]) {
				location--;
				answer++;
				
				if (location < 0) {
					break;
				}
				
			} else {
				q.add(tmp);
				location--;
				
				if (location < 0) {
					location = q.size() - 1;
				}
			}
		}
		
		return answer;
	}
	
}


















