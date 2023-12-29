package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_42842 {
	public static void main(String[] args) {
		// Test Case
//		int brown = 10;
//		int yellow = 2;
		int brown = 8;
		int yellow = 1;
		
		// Answer
		Practice_lessons_42842 p = new Practice_lessons_42842();
		System.out.println(Arrays.toString(p.solution(brown, yellow)));
		
	}
	
	public int[] solution(int brown, int yellow) {
		int total = brown + yellow;
		
		for (int row = 1; row <= total; row++) {
			if (total % row == 0) {
				int col = total / row;
				
				if (row > col) {
					continue;
				}
				
				if (yellow == (row - 2) * (col - 2)) {
					return new int[] {col, row};
				}
			}
		}
		
		return null;
	}
	
}


















