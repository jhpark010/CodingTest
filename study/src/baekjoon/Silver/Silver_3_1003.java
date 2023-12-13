package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver_3_1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[][] arr = new int[41][2];
		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;
		
		for (int i = 2; i < arr.length; i++) {
			arr[i][0] = arr[i - 2][0] + arr[i - 1][0];
			arr[i][1] = arr[i - 2][1] + arr[i - 1][1];
		}
		
		while(n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			sb.append(arr[num][0]).append(" ").append(arr[num][1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
