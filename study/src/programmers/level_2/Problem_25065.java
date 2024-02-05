package programmers.level_2;

import java.util.ArrayList;
import java.util.List;

public class Problem_25065 {
	
	public static void main(String[] args) {
		// Test Case
		int n = 3;
		
		// Answer
		Problem_25065 main = new Problem_25065();
		System.out.println(main.solution(n));

	}
	List<int[]> list;
	
	public int[][] solution(int n) {
        list = new ArrayList<>();
        
        hanoi(1, 2, 3, n);
        
        int[][] answer = new int[list.size()][2];
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        return answer; 
    }
	
	public void hanoi(int from, int m, int to, int num) {
		if (num == 0) {
			return;
		}
		
		hanoi(from, to, m, num - 1);
		list.add(new int[] {from, to});
		hanoi(m, from, to, num - 1);
	}
}












