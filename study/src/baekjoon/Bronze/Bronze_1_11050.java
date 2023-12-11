package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze_1_11050 {
	static int[][] dy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(combi(n, k));
	}
	
	public static int combi(int a, int b) {
		if (a == b || b == 0) {
			return 1;
		} else {
			return combi(a - 1, b - 1) + combi(a - 1, b);
		}
	}
}











