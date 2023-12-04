package programmers.level_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_131704 {
	public static void main(String[] args) {
		// Test Case
//		int[] order = {5, 4, 3, 2, 1};
		int[] order = {4, 3, 1, 2, 5};
		
		// Answer
		Problem_131704 main = new Problem_131704();
		System.out.println(main.solution(order));

	}

	public int solution(int[] order) {
		int max = order.length;
		List<Integer> truck = new ArrayList<>();
		Stack<Integer> sub = new Stack<>();
		int idx = 0;
		
		for (int i = 1; i <= max; i++) {
			if (order[idx] == i) {
				truck.add(i);
				idx++;
				
				while(!sub.isEmpty() && sub.peek() == order[idx]) {
					truck.add(sub.pop());
					idx++;
				}
				
			} else {
				sub.push(i);
			}
		}
		
//		while(!sub.isEmpty() && sub.peek() == order[idx]) {
//			truck.add(sub.pop());
//			idx++;
//		}
		
		
		
		return truck.size();
	}
	
}













