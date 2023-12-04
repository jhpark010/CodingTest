package programmers.level_2;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem_87390 {
	public static void main(String[] args) {
		// Test Case
//		int n = 4;
//		int left = 7;
//		int right = 14;
		int n = 3;
		int left = 2;
		int right = 5;

		// Answer
		Problem_87390 p = new Problem_87390();
		System.out.println(Arrays.toString(p.solution(n, left, right)));

	}

	public int[] solution(int n, long left, long right) {
		int[] answer = new int[(int)(right - left) + 1];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Math.max((int)(left / n) + 1, (int)(left % n) + 1);
			left++;
		}
		
		
		// 실패 (모든 배열에서 값을 만들어야해서 메모리 풀)
		// solution 반환 타입 long으로 까지 변경함...
		/*
		int index = 0;
		
		for (index = 0; index < n; index++) {
			arr[index] = index + 1;
		}
		
		while (index < arr.length) {
			if (index / n != 0 && index % n == 0) {
				int tmp = index / n;
				int idx = tmp;
				
				while (tmp >= 0) {
					arr[index++] = arr[idx];
					tmp--;
				}
				
			} else {
				arr[index] = arr[index % n];
				index++;
			}
		}
		
		long[] answer = Arrays.copyOfRange(arr, (int)left, (int)(right + 1));
		*/
		
		return answer;
	}

}
