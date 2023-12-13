package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_2_2775 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] arr = new int[15][15];
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 14; i ++) {
			arr[i][1] = 1;
			arr[0][i] = i;
		}
		
		for (int i = 1; i <= 14; i ++) {
			for (int j = 2; j <=14; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (t-- > 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			sb.append(arr[k][n]).append("\n");
		}
		
		System.out.println(sb);
	}
}











