package baekjoon.Silver;

import java.util.Scanner;

public class Silver_5_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int prevSum = 0; //현재 이전의 대각선 칸의 총합
		int crossCnt = 1; // 현재 대각선 칸의 개수
		
		while(true) {
			if (n <= prevSum + crossCnt) {
				//개수가 홀수일 때 분자(감소), 분모(증가)
				if (crossCnt % 2 == 1) {
					System.out.println((crossCnt - (n - prevSum - 1)) + "/" + (n - prevSum));
					break;
				} else {
					System.out.println((n - prevSum) + "/" + (crossCnt - (n - prevSum - 1)));
					break;
				}
				
			} else {
				prevSum += crossCnt;
				crossCnt++;
			}
		}
	}
}
