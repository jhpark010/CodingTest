package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_3_11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long[] sum = new long[N];
		sum[0] = arr[0];
		
		for (int i = 1; i < N; i++) {
			sum[i] = arr[i] + sum[i - 1];
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			if (a == 0) {
				sb.append(sum[b]);
			} else {
				sb.append(sum[b] - sum[a - 1]);
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}		
}















