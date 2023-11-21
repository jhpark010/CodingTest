package programmers.level_1;

public class Problem_12953 {
	public static void main(String[] args) {
		// Test Case
//		int[] arr = {2,6,8,14};
		int[] arr = {1, 2, 3};
		
		// Answer
		Problem_12953 p = new Problem_12953();
//		System.out.println(p.solution(brown, yellow));
		System.out.println(p.solution(arr));

	}

	// 유클리드 호제법 사용
	// 최소 공배수는 a와 b의 곱을 최대 공약수로 나눈 값
	
	public int solution(int[] arr) {
		int answer = 0;
		
		if (arr.length == 1) {
			return arr[0];
			
		} else {
			answer = arr[0];
			
			for (int i = 1; i < arr.length; i ++) {
//				answer = answer * arr[i] / gcd(answer, arr[i]);
				answer = lcm(answer, arr[i]);
			}
		}
		
		return answer;
	}
	
	public int gcd(int a, int b) {
		if (a % b == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}
	}
	
	public int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	
}













