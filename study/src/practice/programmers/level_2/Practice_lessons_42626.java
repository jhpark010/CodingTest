package practice.programmers.level_2;

import java.util.PriorityQueue;

public class Practice_lessons_42626 {
	public static void main(String[] args) {
		// Test Case
		int[] scoville = {1,2,3,9,10,12};
		int k = 7;
		
		// Answer
		Practice_lessons_42626 main = new Practice_lessons_42626();
		System.out.println(main.solution(scoville, k));
		
	}
	
	public int solution(int[] scoville, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int s : scoville) {
			pq.add(s);
		}
		
		int answer = 0;
		int min = 0;
		
		while(pq.peek() < k && pq.size() >= 2) {
			int n1 = pq.poll();
			int n2 = pq.poll();

			pq.add(n1 + (n2 * 2));
			min = pq.peek();
			answer ++;
		}
		
		if (min < k) {
			return -1;
		}
		
		return answer;
	}
	
}


















