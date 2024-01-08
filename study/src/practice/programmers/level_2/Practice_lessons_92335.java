package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.List;

public class Practice_lessons_92335 {
	public static void main(String[] args) {
		// Test Case
//		int n = 437674;
//		int k = 3;
		int n = 110011;
		int k = 10;
		
		// Answer
		Practice_lessons_92335 p = new Practice_lessons_92335();
		System.out.println(p.solution(n, k));
		
	}
	
	public int solution(int n, int k) {
		String num = Integer.toString(n, k);
		String[] nums = num.split("0");
		
		int answer = 0;
		
		for (String s : nums) {
			if (s.equals("")) continue;
			if (isPrime(Long.parseLong(s))) answer++; 
		}
		
		return answer;
	}
	
	public boolean isPrime(long num) {
		if (num == 1) return false;
		
		for (int i = 2; i <= Math.sqrt(num); i++) {			
			if (num % i == 0) return false;
		}
		
		return true;
	}
	
}


















