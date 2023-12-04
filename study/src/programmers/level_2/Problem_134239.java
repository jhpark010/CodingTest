package programmers.level_2;

import java.util.Arrays;

public class Problem_134239 {
	public static void main(String[] args) {
		// Test Case
		int k = 5;
		int[][] ranges = {{0,0},{0,-1},{2,-3},{3,-3}};
		
		// Answer
		Problem_134239 p = new Problem_134239();
//		System.out.println(p.solution(brown, yellow));
		System.out.println(Arrays.toString(p.solution(k, ranges)));

	}

	
	// 클라츠 추측
	// 입력된 수가 짝수라면 2로 나누고 홀수라면 3을 곱하고 1을 더한다.
	// 1이 될때 까지 반복
	
	public double[] solution(int k, int[][] ranges) {
		double[] answer = new double[ranges.length];
		int collatzCnt = collatzCnt(k);
		double[] yValue = new double[collatzCnt + 1];
		
		yValue[0] = k;
		
		for (int i = 1; i <= collatzCnt; i++) {
			if (yValue[i - 1] % 2 == 0) {
				yValue[i] = yValue[i - 1] / 2;
			} else {
				yValue[i] = (yValue[i - 1] * 3) + 1;
			}
		}
		
		double[] areaValue = new double[collatzCnt + 1];
		areaValue[0] = 0;
		
		for (int i = 1; i < areaValue.length; i++) {
			areaValue[i] = (yValue[i - 1] + yValue[i]) / 2;
		}
		
		double[] accuAreaValue = new double[collatzCnt + 1];
		
		for (int i = 1; i < accuAreaValue.length; i++) {
			accuAreaValue[i] = accuAreaValue[i - 1] + areaValue[i];
		}
		
		for (int i = 0; i < ranges.length; i++) {
			int start = ranges[i][0];
			int end = collatzCnt + ranges[i][1];
			
			if (start < end) {
				answer[i] = accuAreaValue[end] - accuAreaValue[start];
				
			} else if(start > end) {
				answer[i] = -1.0;
				
			} else {
				answer[i] = 0.0;
			}
		}
		
		return answer;
	}
	
	public int collatzCnt(int k) {
		int cnt = 0;
		
		while (k > 1) {
			if (k % 2 == 0) {
				k = k / 2;
			} else {
				k = (k * 3) + 1;
			}
			cnt ++;
		}
		
		return cnt;
	}
	
}













