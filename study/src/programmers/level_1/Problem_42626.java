package programmers.level_1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Problem_42626 {
	public static void main(String[] args) {
		// Test Case
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 100;
		
		// Answer
		Problem_42626 p = new Problem_42626();
		System.out.println(p.solution(scoville, K));
		
	}
	
	public int solution(int[] scoville, int K) {
		int answer = 0;
        PriorityQueue<Integer> q = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        
        //런타임 에러 발생
//        for (int value : scoville) {
//            q.add(value);
//        }
        
        int minScoville = 0;
        
        while(K > minScoville && !q.isEmpty()) {
			int val1 = q.poll();
			int val2 = q.poll();
			q.offer(val1 + (val2 * 2));
			minScoville = q.peek();
			answer++;
        }
        
        if (minScoville < K) {
        	answer = -1;
        }
        
        return answer;
    }
}

















