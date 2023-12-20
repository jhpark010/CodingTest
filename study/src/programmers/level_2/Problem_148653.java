package programmers.level_2;

public class Problem_148653 {
	public static void main(String[] args) {
		// Test Case
		int storey = 16;
		
		// Answer
		Problem_148653 p = new Problem_148653();
		System.out.println(p.solution(storey));

	}

	public int solution(int storey) {
		int answer = 0;
		String tmp = String.valueOf(storey);
		int[] arr = new int[tmp.length()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = tmp.charAt(i) - '0';
		}
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > 5) {
				answer += 10 - arr[i];
				
				if (i == 0) {
					answer++;
				} else {
					arr[i - 1]++;
				}
				
			} else if (arr[i] == 5 && i > 0 && arr[i - 1] >= 5) {
				answer += 5;
				arr[i - 1]++;
				
			} else {
				answer += arr[i];
			}
			
		}
		return answer;
	}
}













