package practice.programmers.level_2;

public class Practice_lessons_12980 {
	public static void main(String[] args) {
		// Test Case
		int N = 5000;
		
		// Answer
		Practice_lessons_12980 p = new Practice_lessons_12980();
		System.out.println(p.solution(N));
		
	}
	
	public int solution(int N) {
		int answer = 0;
		
		while(N != 0) {
			if (N % 2 != 0) {
				answer ++;
			}
			N /= 2;
		}
		
		return answer;
	}
	
}


















