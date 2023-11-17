package programmers.level_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_42584 {
	public static void main(String[] args) {
		// Test Case
		int[] prices = {1, 2, 3, 2, 3};
		
		// Answer
		Problem_42584 p = new Problem_42584();
		System.out.println(Arrays.toString(p.solution(prices)));
		
	}
	
	public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Queue<Integer> q = new LinkedList<>();
        
        for (int price : prices) {
        	q.add(price);
        }
        
        int idx = 0;
        
        while (!q.isEmpty()) {
        	int tmp = q.poll();
        	int cnt = 0;
        	for (int n : q) {
        		cnt ++;
        		if (tmp > n) {
        			break;
        		}
        	}
        	
        	ans[idx++] = cnt;
        }
        
        return ans;
    }
}

















