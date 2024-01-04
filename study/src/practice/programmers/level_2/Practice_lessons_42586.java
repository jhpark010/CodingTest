package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Practice_lessons_42586 {
	public static void main(String[] args) {
		// Test Case
		int[] progresses = {93,30,55};
		int[] speeds = {1, 30, 5};
		
		// Answer
		Practice_lessons_42586 p = new Practice_lessons_42586();
		System.out.println(Arrays.toString(p.solution(progresses, speeds)));
		
	}
	
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> q = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < progresses.length; i++) {
			double val = (100.0 - progresses[i]) / speeds[i];
			int date = (int) Math.ceil(val);
			
			if (!q.isEmpty() && q.peek() < date) {
				list.add(q.size());
				q.clear();
			}
				
			q.add(date);
		}
		
		list.add(q.size());
//		
//		int prev = q.poll();
//		int work = 1;
//		
//		while(!q.isEmpty()) {
//			if (prev >= q.peek()) {
//				work ++;
//				q.poll();
//				
//			} else {
//				list.add(work);
//				prev = q.poll();
//				work = 1;
//			}
//		}
//		
//		list.add(work);
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
	
}


















