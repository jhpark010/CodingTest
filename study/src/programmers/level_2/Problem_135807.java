package programmers.level_2;

public class Problem_135807 {
	public static void main(String[] args) {
		// Test Case
//		int[] arrayA = {10, 17};
//		int[] arrayB = {5, 20};
		int[] arrayA = {10, 20};
		int[] arrayB = {5, 17};

		// Answer
		Problem_135807 p = new Problem_135807();
		System.out.println(p.solution(arrayA, arrayB));

	}

	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		
		if (arrayA.length == 1 & arrayB.length == 1) {
			if (arrayA[0] == arrayB[0]) {
				answer = arrayA[0]; 
			}
			
		} else {
			int a = arrayA[0];
			int b = arrayB[0];
			
			for (int i = 1; i < arrayA.length; i++) {
				a = gcd(a, arrayA[i]);
				b = gcd(b, arrayB[i]);
			}
			
			
			if (!isDivisible(arrayA, b)) {
				if (answer < b) {
					answer = b;
				}
			}
			
			if (!isDivisible(arrayB, a)) {
				if (answer < a) {
					answer = a;
				}
			}
			
		}
		
		return answer;
	}
	
	public boolean isDivisible(int[] arr, int gcd) {
		for (int num : arr) {
			if (num % gcd == 0) {
				return true;
			}
		}
		return false;
	}
	
	public int gcd(int a, int b) { 
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
	
}



