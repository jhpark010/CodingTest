package programmers.level_2;

public class Problem_12985 {
	public static void main(String[] args) {
		// Test Case
		int n = 16;
		int a = 1;
		int b = 2;
		
		// Answer
		Problem_12985 p = new Problem_12985();
		System.out.println(p.solution(n, a, b));

	}

	public int solution(int n, int a, int b) {
		int answer = 0;
        while(true) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer ++;

            if (a == b) {
                break;
            }
        }

        return answer;
	}
	
}













