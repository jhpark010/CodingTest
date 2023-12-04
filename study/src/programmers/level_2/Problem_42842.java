package programmers.level_2;

import java.util.Arrays;

public class Problem_42842 {
	public static void main(String[] args) {
		// Test Case
		int brown = 8;
		int yellow = 1;
		
		// Answer
		Problem_42842 p = new Problem_42842();
//		System.out.println(p.solution(brown, yellow));
		System.out.println(Arrays.toString(p.solution(brown, yellow)));

	}

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int length = brown + yellow;
		
		for (int i = 1; i * i <= length; i++) {
			int y = 0;
			int x = 0;
			
			if (length % i == 0) {
				x = i;
				
				if (length / i != i) {
					y = (length / i);
					
				} else {
					y = x;
				}
				
				if (yellow == (y - 2) * (x - 2)) {
					answer[1] = x; //세로
					answer[0] = y; //가로
					break;
				}
			}
		}
		
		return answer;
	}
}













