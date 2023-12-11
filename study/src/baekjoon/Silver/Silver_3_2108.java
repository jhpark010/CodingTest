package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver_3_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sNum = br.readLine();
		int numLen = sNum.length() * 9;
		int n = Integer.parseInt(sNum);
		int min = n - numLen;
		int answer = 0;
		
		while (min != n) {
			int tmp = 0;
			String sTmp = String.valueOf(min);
			
			for (int i = 0; i < sTmp.length(); i++) {
				tmp += sTmp.charAt(i) - '0';
			}
			
			if (n == (tmp + min)) {
				answer = min;
				break;
				
			} else {
				min++;
			}
		}
		
		/*
		 * 다른 풀이

		while (min != n) {
			int tmp = min;
			int sum = 0;
			
			while(tmp != 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			
			if (n == (sum + min)) {
				answer = min;
				break;
				
			}
			min++;
		}
		*/
		System.out.println(answer);
	}
}
