package baekjoon.Gold;

import java.io.IOException;
import java.util.Scanner;

public class Gold_5_1107 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int channel = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[] brokenBtn = new boolean[10];
		for (int i = 1; i <= M; i++) {
			int brokenNum = sc.nextInt();
			brokenBtn[brokenNum] = true;
		}
		
		int answer = Math.abs(channel - 100);
		
		for (int i = 0; i <= 999999; i++) {
			String sNum = String.valueOf(i);
			int len = sNum.length();
			boolean isBroken = false;
			
			for (int j = 0; j < sNum.length(); j++) {
				if (brokenBtn[sNum.charAt(j) - '0']) {
					isBroken = true;
					break;
				}
			}
			
			if (!isBroken) {
				int min = Math.abs(channel - i) + len;
				answer = Math.min(answer, min);
			}
		}
		
		System.out.println(answer);
	}
}















