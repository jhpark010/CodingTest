package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver_4_11047 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
//		Arrays.sort(arr, Collections.reverseOrder());
		
		int answer = 0;
		
		for (int i = 0; i < N; i++) {
//			if (K == 0) break;
			
			if (arr[i] <= K) {
				answer += K / arr[i];
				K %= arr[i];
			}
		}
		
		System.out.println(answer);
		
	}
	
//	public static void dfs (int sum, int cnt) {
//		if (stopFlag) {
//			return;
//		}
//		
//		if (answer < cnt || sum > K) {
//			return;
//		}
//		
//		if (sum == K) {
//			answer = Math.min(answer, cnt);
//			stopFlag = true;
//			return;
//			
//		} else {
//			for (int i = 0; i < N; i++) {
//				dfs(sum + arr[i], cnt + 1);
//			}
//		}
//	}
}
