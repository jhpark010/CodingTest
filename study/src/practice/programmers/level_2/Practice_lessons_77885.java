package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_77885 {
	public static void main(String[] args) {
		// Test Case
//		long[] numbers = {1, 7};
		long[] numbers = {7, 23};
		
		// Answer
		Practice_lessons_77885 main = new Practice_lessons_77885();
		System.out.println(main.solution(numbers));
		
	}
	
	public long[] solution(long[] numbers) {
        long[] answer = new long[2];
        
        for (int i = 0; i < numbers.length; i++) {
        	if (numbers[i] % 2 == 0) {
        		answer[i] = numbers[i] + 1;
        		
        	} else {
        		String tmp = Long.toBinaryString(numbers[i]);
        		boolean isExist = false;
        		
        		for (int j = tmp.length() - 1; j >= 0; j--) {
        			if (tmp.charAt(j) == '0') {
        				isExist = true;
        				tmp = tmp.substring(0, j) + "10" + tmp.substring(j + 2, tmp.length());
        				break;
        			}
        		}
        		
        		// 111, 11 과 같이 2진수가 모두 1인 경우
        		// ex) 111 -> 0111 -> 1111
        		if (!isExist) {
        			tmp = "10" + tmp.substring(1);
        		}
        		
        		answer[i] = Long.parseLong(tmp, 2);
        	}
        }
        return answer;
	}
}


















