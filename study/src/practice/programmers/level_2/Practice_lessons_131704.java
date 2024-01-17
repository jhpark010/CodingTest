package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Practice_lessons_131704 {
	public static void main(String[] args) {
		// Test Case
//		int[] order = {4, 3, 1, 2, 5};
		int[] order = {5, 4, 3, 2, 1};
		
		// Answer
		Practice_lessons_131704 main = new Practice_lessons_131704();
		System.out.println(main.solution(order));
		
	}
	
	public int solution(int[] order) {
		int max = order.length;
		List<Integer> main = new ArrayList<>();
		Stack<Integer> sub = new Stack<>();
		int idx = 0;
		
		for (int i = 1; i <= max; i++) {
			if (order[idx] == i) {
				main.add(i);
				idx++;
				
				while (!sub.isEmpty() && order[idx] == sub.peek()) {
					main.add(sub.pop());
					idx++;
				}
				
			} else {
				sub.push(i);
			}
		}
		
		
		return main.size();
	}
	
	/*
	 * 아래 소스코드 채점 결과 : 80점 ---- 8 / 10
	 */
	/*
	public int solution(int[] order) {
        int max = 0;
        for (int o : order) {
            max = Math.max(o, max);
        }
        int n = 1;
        
        List<Integer> main = new ArrayList<>();
        Stack<Integer> sub = new Stack<>();
        int i = 0;
        
        for (; i < order.length; i++) {
            if (n > max) break;
            
            if (order[i] == n) {
                main.add(n++);
                
            } else {
                while(n <= max) {
                    if (!sub.isEmpty() && sub.peek() == order[i]) {
						main.add(sub.pop());
						break;
                    } else {
                    	sub.push(n++);
                    }
                }
            }
        }
        
        if (!sub.isEmpty()) {
        	for (int j = i - 1; j < order.length; j++) {
        		if (sub.peek() == order[j]) {
        			main.add(sub.pop());
        		} else {
        			break;
        		}
        	}
        }
        return main.size();
	}
	*/
}


















