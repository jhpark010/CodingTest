package programmers.level_1;

import java.util.Arrays;

public class Problem_77885 {
	public static void main(String[] args) {
		// Test Case
		long[] numbers = {3, 1523};
		
		// Answer
		Problem_77885 main = new Problem_77885();
		System.out.println(Arrays.toString(main.solution(numbers)));

	}

	public long[] solution(long[] numbers) {
		long[] answer = new long[numbers.length];
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				answer[i] = numbers[i] + 1;
			} else {
				String s = Long.toBinaryString(numbers[i]);
				int idx = -1;
				
				for (int j = s.length() - 1; j >= 0; j--) {
					if (s.charAt(j) == '0') {
						idx = s.length() - j - 1;
						break;
					}
				}
				
				if (idx == -1) {
					idx = s.length();
				}
				
				StringBuilder sb = new StringBuilder();
				sb.append(1);
				
				for (int n = 1; n <= idx; n++) {
					sb.append(0);
				}
				
				long value = Long.parseLong(sb.toString(), 2) / 2;
				
				answer[i] = Long.parseLong(s, 2) + Long.parseLong(sb.toString(), 2) - value; 
			}
		}
		
//		StringBuilder a = new StringBuilder(Long.toString(numbers[0], 2));
//		long na = numbers[0] + 1;
//		
//		while(true) {
//			StringBuilder naSb = new StringBuilder(Long.toBinaryString(na));
//			
//			if (isValid(a.reverse().toString(), naSb.reverse().toString())) {
//				answer[0] = na;
//				break;
//			}
//			
//			na++;
//		}
//		
//		StringBuilder b = new StringBuilder(Long.toString(numbers[1], 2));
//		long nb = numbers[1] + 1;
//		
//		while(true) {
//			StringBuilder nbSb = new StringBuilder(Long.toBinaryString(nb));
//			
//			if (isValid(b.reverse().toString(), nbSb.reverse().toString())) {
//				answer[1] = nb;
//				break;
//			}
//			
//			nb++;
//		}
		
		return answer;
	}
	
//	public boolean isValid(String n, String value) {
//		int cnt = 0;
//		
//		for (int i = 0; i < value.length(); i++) {
//			if (i < n.length() && n.charAt(i) == value.charAt(i)) {
//				cnt ++;
//			}
//		}
//		
//		if (value.length() - cnt <= 2) {
//			return true;
//		}
//		
//		return false;
//	}
	
}













