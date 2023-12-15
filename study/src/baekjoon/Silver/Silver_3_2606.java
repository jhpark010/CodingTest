	package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_3_2606 {
	static int[] dp;
	
	public static int find(int a) { 
		if (dp[a] == a) {
			return a;
		} else {
			return dp[a] = find(dp[a]);
		}
	}
	
	public static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		
		if (fa != fb) dp[fa] = fb;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
		}
		
		int M = Integer.parseInt(br.readLine());
		
		while(M-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		int answer = 0;
		
		for (int i = 2; i <= N; i++) {
			if (find(1) == find(i)) {
				answer++;
			}
		}
		System.out.println(answer);
	}		
}















