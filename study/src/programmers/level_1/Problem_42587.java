package programmers.level_1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem_42587 {
	public static void main(String[] args) {
		// Test Case
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		// Answer
		Problem_42587 p = new Problem_42587();
		System.out.println(p.solution(priorities, location));
	}
	
	public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int id = 0;
        
        for (int n : priorities) {
            q.offer(new Process(id++, n));
            pq.offer(n);
        }
        
        int order = 0;
        
        while (!pq.isEmpty()) {
        	int max = pq.poll();
        	
        	while (!q.isEmpty()) {
        		Process p = q.poll();
        		
        		if (p.value == max) {
        			order ++;
        			if (p.id == location) {
        				return order;
        			}
        			break;
        		} else {
        			q.offer(p);
        		}
        	}
        }
		
		return order; 
	}
	
	class Process {
        int id;
        int value;
        
        Process(int id, int value) {
            this.id = id;
            this.value = value;
        }
    }
}

















