package programmers.level_1;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_92335 {
	public static void main(String[] args) {
		// Test Case
		int n = 437674;
//		int n = 110011;
		int k = 3;
		
		// Answer
		Problem_92335 p = new Problem_92335();
		System.out.println(p.solution(n, k));

	}

	public int solution(int n, int k) {
		int answer = 0;
		List<String> list = init(n, k);
		
		for (String s : list) {
			if (isPrime(Long.parseLong(s))) answer++;
		}
		
		return answer;
	}
	
	public List<String> init(int n, int k) {
		StringTokenizer st = new StringTokenizer(getBinary(n, k), "0");
		List<String> list = new ArrayList<>();
		
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}
		
		return list;
	}
	
	public String getBinary(int n, int k) {
		StringBuilder sb = new StringBuilder();
		
		while (n > 0) {
			sb.append(n % k);
			n = n / k;
		}
		
		return sb.reverse().toString();
	}
	
	
	public boolean isPrime(long n) {
		if (n == 1) return false;
		
		for (int i = 2; i * i <= n; i++) 
			if (n % i == 0) return false;
		
		return true;
	}
	
	/*
	public int solution(int n, int k) {
		int answer = 0;
		
		String s = Integer.toString(n, k);
		char[] cArr = s.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] != '0') {
				sb.append(cArr[i]);
				
				if (i == cArr.length - 1) {
					if (cArr[i] != '0') {
						if (isPrime(Long.parseLong(sb.toString()))) {
							answer++;
						}
					}
				}
				
			} else {
				if (!sb.toString().equals("")) {
					if (isPrime(Long.parseLong(sb.toString()))) {
						answer++;
					}
				}
				sb = new StringBuilder();
			}
		}
		
		return answer;
	}
	 */
	
	
}









