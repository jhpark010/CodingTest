package baekjoon.Bronze;

import java.util.Scanner;

public class Bronze_2_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 1;
		int answer = 1;
		int cnt = 1;
		
		while (num < n) {
			answer ++;
			num = num + (6 * cnt++);
		}
		
		System.out.println(answer);
	}
}











