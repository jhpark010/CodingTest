package practice.programmers.level_2;

public class Practice_lessons_12945 {
	public static void main(String[] args) {
		// Test Case
		int n = 3;
		
		// Answer
		Practice_lessons_12945 p = new Practice_lessons_12945();
		System.out.println(p.solution(n));
		
	}
	
	public int solution(int n) {
		int[] fibo = new int[n + 1];
		fibo[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
		}
		
		return fibo[n];
	}
	
}


















