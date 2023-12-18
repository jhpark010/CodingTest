package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 풀이 : https://sirobako.co.kr/detail/63
 */

public class Silver_1_6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int lcm = lcm(M, N);
			int answer = -1;
			
			for (int i = x; i <= lcm; i += M) {
				if ((i - y) % N == 0) {
					answer = i;
					break;
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
	
	public static int gcd(int a, int b) {
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
}















