package programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem_178870 {
	
	public static void main(String[] args) {
		// Test Case
//		int[] sequence = {1,2,3,4,5};
//		int k = 7;
//		int[] sequence = {1, 1, 1, 2, 3, 4, 5};
//		int k = 5;
		int[] sequence = {2, 2, 2, 2, 2, 2};
		int k = 6;
//		int[] sequence = {1,2,2,3,3,4};
//		int k = 8;
		
		// Answer
		Problem_178870 main = new Problem_178870();
		System.out.println(Arrays.toString(main.solution(sequence, k)));

	}
	
	public int[] solution(int[] sequence, int k) {
		int[] answer = new int[] {0, sequence.length - 1};
		int sum = sequence[0];
		int lt = 0;
		int rt = 1;
		
		while (lt < rt) {
			if (sum == k) {
				if (rt - 1 - lt < answer[1] - answer[0]) {
					answer[0] = lt;
					answer[1] = rt - 1;
				}
				sum -= sequence[lt++];
				
			} else if (sum > k) {
				sum -= sequence[lt++];
			} else if (rt < sequence.length) {
				sum += sequence[rt++];
			} else {
				break;
			}
		}
		
		return answer;
	}
	
	/*
	public int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];
		int len = sequence.length;
		int left = 0;
		int right = len;
		int sum = 0;
		
		for (int L = 0, R = 0; L < len; L ++) {
			while(R < len && sum < k) {
				sum += sequence[R++];
			}
			
			if (sum == k) {
				int range = R - L - 1;
				
				if ((right - left) > range) {
					left = L;
					right = R - 1;
				}
				
			}
			
			sum -= sequence[L];
		}
		
		answer[0] = left;
		answer[1] = right;
		
		return answer;
	}
	*/
}

























