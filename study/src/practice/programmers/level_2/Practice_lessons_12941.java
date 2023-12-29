package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_12941 {
	public static void main(String[] args) {
		// Test Case
//		int[] A = {1, 4, 2};
//		int[] B = {5, 4, 4};
		int[] A = {1, 2};
		int[] B = {3, 4};
		
		// Answer
		Practice_lessons_12941 p = new Practice_lessons_12941();
		System.out.println(p.solution(A, B));
		
	}
	
	public int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		int sum = 0;
		
		for (int i = 0; i < A.length; i++) {
			sum += (A[i] * B[B.length - i - 1]);
		}
		
		return sum;
	}
	
}


















