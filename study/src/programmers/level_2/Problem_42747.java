package programmers.level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_42747 {
	public static void main(String[] args) {
		// Test Case
//		int[] citations = {3, 4};
//		int[] citations = {3, 0, 6, 1, 5};
		int[] citations = {6, 5, 5, 5, 3, 2, 1, 0};
		
		// Answer
		Problem_42747 p = new Problem_42747();
		System.out.println(p.solution(citations));
		
	}
	
	public int solution(int[] citations) {
        List<Integer> list = new ArrayList<>();
        
        for (int n : citations) {
        	list.add(n);
        }
        
        Collections.sort(list);
        int max = 0;
        
        for (int i = list.size() - 1; i >= 0; i--) {
        	int min = Math.min(list.get(i), list.size() - i);
        	if (max < min) {
        		max = min;
        	}
        }
        
		return max;
    }
	
}

















