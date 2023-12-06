package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze_1_10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[10001];
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(br.readLine());
			cnt[num]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] != 0) {
				for (int j = 1; j <= cnt[i]; j++) {
					sb.append(i + "\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}











