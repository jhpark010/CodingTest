package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_3_1929 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[n + 1];
		prime[1] = true;
		
		for (int i = 2; i * i <= n; i++) {
			if(!prime[i]) {
				for (int j = i * 2; j <= n; j += i) {
					prime[j] = true;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = m; i <= n; i++) {
			if (!prime[i]) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
