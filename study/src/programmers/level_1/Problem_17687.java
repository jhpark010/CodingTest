package programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_17687 {
	public static void main(String[] args) {
		// Test Case
		int n = 16;
		int t = 4;
		int m = 2;
		int p = 1;
		
		// Answer
		Problem_17687 main = new Problem_17687();
		System.out.println(main.solution(n, t, m, p));

	}

	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i <= 16; i++) {
			if (i >= 10 && i <= 15) {
				System.out.println((char) (i + 55));
			} else {
				//i가 10이상부터(10 ~ 15 제외)는 한자리씩 나눠서
				System.out.println(getBinary(n, i));
			}
		}
		
		return "";
	}
	
	public String getBinary(int n, int num) {
		StringBuilder sb = new StringBuilder();
		if (num == 0) {
			sb.append(0);
		} else {
			while (num > 0) {
				sb.append(num % n);
				num = num / n;
			}
		}
		
		return sb.reverse().toString();
	}
}









