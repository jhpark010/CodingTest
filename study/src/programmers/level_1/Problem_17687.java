package programmers.level_1;

public class Problem_17687 {
	public static void main(String[] args) {
		// Test Case
		int n = 16;
		int t = 16; //미리 구할 숫자의 갯수
		int m = 2; //인원
		int p = 1; //순서
		
		// Answer
		Problem_17687 main = new Problem_17687();
		System.out.println(main.solution(n, t, m, p));

	}

	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; sb.length() < t * m; i ++) {
			sb.append(Integer.toString(i, n));
		}
		
		for (int i = p - 1; answer.length() < t; i += m) {
			answer.append(sb.charAt(i));
		}
		
		return answer.toString().toUpperCase();
	}
}









