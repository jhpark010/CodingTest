package practice.programmers.level_2;

public class Practice_lessons_12924 {
	public static void main(String[] args) {
		// Test Case
		int n = 15;
		
		// Answer
		Practice_lessons_12924 p = new Practice_lessons_12924();
		System.out.println(p.solution(n));
		
	}
	
	public int solution(int n) {
		int lt = 1;
		
		if (n == 1) {
			return 1;
		}
		
		int sum = lt;
		int answer = 0;
		
		for (int rt = 2; rt <= n; rt++) {
			sum += rt;
			
			if (sum == n) {
				answer++;
			}
			
			while (sum > n) {
				sum -= lt++;
				
				if (sum == n) {
					answer++;
				}
			}
		}
		
		return answer;
	}
	
}


















