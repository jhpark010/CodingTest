package programmers.level_1;

import java.util.Arrays;

public class Problem_70129 {
	public static void main(String[] args) {
		// Test Case
		String s = "110010101001";

		// Answer
		Problem_70129 p = new Problem_70129();
		System.out.println(Arrays.toString(p.solution(s)));

	}

	int[] answer;
	
	public int[] solution(String s) {
		answer = new int[2];
		dfs(0, 0, s);
		
		return answer;
	}
	
	public void dfs (int cnt, int delZeroCnt, String s) {
		if (s.equals("1")) {
			answer[0] = cnt;
			answer[1] = delZeroCnt;
			return;
			
		} else {
			int beforeSize = s.length();
			int afterSize = s.replace("0", "").length();
			s = Long.toBinaryString(afterSize);
			delZeroCnt += beforeSize - afterSize;
			
			if (s.length() > 0) {
				dfs(cnt + 1, delZeroCnt, s);
			} else {
				return;
			}
		}
	}
}













