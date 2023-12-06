package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver_4_2839 {
	static int minCnt = Integer.MAX_VALUE;
	static int[] kg = {5, 3};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if (n == 4 || n == 7) {
			System.out.println(-1);
		} else if (n % 5 == 1 || n % 5 == 3) {
			System.out.println((n / 5) + 1);
		} else if (n % 5 == 2 || n % 5 == 4) {
			System.out.println((n / 5) + 2);
		} else if (n % 5 == 0) {
			System.out.println(n / 5);
		}
	}
	
	public static void solve(int sum, int answer, int cnt) {
		if (sum > answer || cnt > minCnt) {
			return;
		}
		
		if (sum == answer) {
			minCnt = Math.min(cnt, minCnt);
			return;
			
		} else {
			for (int i = 0; i < kg.length; i++) {
				solve(sum + kg[i], answer, cnt + 1);
			}
		}
	}
}
