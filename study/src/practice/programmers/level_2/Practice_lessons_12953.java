package practice.programmers.level_2;

public class Practice_lessons_12953 {
	public static void main(String[] args) {
		// Test Case
		int[] arr = {2,6,8,14};
		// Answer
		Practice_lessons_12953 p = new Practice_lessons_12953();
		System.out.println(p.solution(arr));
		
	}
	
	public int solution(int[] arr) {
		int answer = 0;
		
		if (arr.length == 1) {
			return arr[0];
		} else {
			answer = arr[0];
			
			for (int i = 1; i < arr.length; i++) { 
				answer = lcm(answer , arr[i]);
			}
		}
		
		return answer;
	}
	
	public int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	
	public int gcd(int a, int b) {
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
	
}


















