package practice.programmers.level_2;

public class Practice_lessons_17687 {
	public static void main(String[] args) {
		// Test Case
//		int n = 2;
//		int t = 4;
//		int m = 2;
//		int p = 1;
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 1;
		
		// Answer
		Practice_lessons_17687 main = new Practice_lessons_17687();
		System.out.println(main.solution(n, t, m, p));
		
	}
	
	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i <= t * m; i++) {
			sb.append(Integer.toString(i, n));
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = p - 1; answer.length() < t; i += m) {
			answer.append(sb.charAt(i));
		}
		
		return answer.toString().toUpperCase();
	}
	
}


















