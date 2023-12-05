package baekjoon.Bronze;

import java.util.Scanner;

public class Bronze_3_2903 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		/*
		 * 다른 풀이
		 */
		System.out.println((int)Math.pow(Math.pow(2, n) + 1, 2));
		
		
		/*
		 * 아래는 내 풀이
		 */
		int[] arr = new int[15 + 1];
		arr[0] = 4;
		
		for (int i = 1; i <= n; i++) {
			int prev = (int) Math.sqrt(arr[i - 1]);
			arr[i] = (int) Math.pow((prev * 2) - 1, 2);
		}
		
		System.out.println(arr[n]);
	}
}












