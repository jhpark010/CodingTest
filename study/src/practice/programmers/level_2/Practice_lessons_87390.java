package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_87390 {
	public static void main(String[] args) {
		// Test Case
		int n = 3;
		long left = 2;
		long right = 5;
		
		// Answer
		Practice_lessons_87390 p = new Practice_lessons_87390();
		System.out.println(Arrays.toString(p.solution(n, left, right)));
		
	}
	
	public int[] solution(int n, long left, long right) {
		int[] answer = new int[(int)(right - left + 1)];
		
		for (int i = 0; i < answer.length; i++) {
			int row = (int) (i + left) / n + 1;
			int col = (int) (i + left) % n + 1;
			answer[i] = Math.max(row, col);
		}
		
		return answer;
	}
	
}


















