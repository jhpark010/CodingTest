package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_2_1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		long max = 0;
		long min = 1;
		
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		
		max++;
		
		while (min < max) {
			long mid = (max + min) / 2;
			long totalLen = 0;
			
			for (int i = 0; i < k; i++) {
				totalLen += (arr[i] / mid);
			}
			
			if (totalLen < n) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		System.out.println(min);
	}
}
