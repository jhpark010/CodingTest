package programmers.level_2;

import java.util.Arrays;

public class Problem_12941 {
	public static void main(String[] args) {
		// Test Case
		int[] a = {1, 4, 2};
		int[] b = {5, 4, 4};

		// Answer
		Problem_12941 p = new Problem_12941();
		System.out.println(p.solution(a, b));

	}

	public int solution(int[] A, int[] B) {
		int answer = 0;
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]);
			System.out.println(B[A.length - 1 - i]);
			answer += A[i] * B[A.length - 1 - i];
		}
		

		return answer;
	}

}













