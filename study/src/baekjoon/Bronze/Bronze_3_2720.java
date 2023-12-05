package baekjoon.Bronze;

import java.util.Scanner;

public class Bronze_3_2720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = {25, 10, 5, 1};
		int[][] result = new int[n][4];
		
		for (int i = 0; i < n; i++) {
			int[] coins = new int[4];
			int price = sc.nextInt();
			int prev = 0;
			
			while (prev != price) {
				for (int j = 0; j < arr.length; j++) {
					if (prev + arr[j] <= price) {
						prev += arr[j];
						coins[j]++;
						break;
					}
				}
			}
			
			result[i] = coins;
		}
		
		for (int[] coins : result) {
			for (int coin : coins) {
				System.out.print(coin + " ");
			}
			System.out.println();
		}
	}
}












