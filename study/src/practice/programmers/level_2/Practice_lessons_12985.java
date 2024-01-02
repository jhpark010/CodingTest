package practice.programmers.level_2;

public class Practice_lessons_12985 {
	public static void main(String[] args) {
		// Test Case
		int n = 16;
		int a = 4;
		int b = 5;
		
		// Answer
		Practice_lessons_12985 p = new Practice_lessons_12985();
		System.out.println(p.solution(n, a, b));
		
	}
	
	public int solution(int n, int a, int b) {
		int answer = 1;
		
		while (Math.abs(a - b) != 1 || Math.max(a, b) % 2 != 0) {
			a = (a % 2) == 0 ? a / 2 : (a + 1) / 2;
			b = (b % 2) == 0 ? b / 2 : (b + 1) / 2;
			answer++;
		}
		
		return answer;
	}
	
}


















