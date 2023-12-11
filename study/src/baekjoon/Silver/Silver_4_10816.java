package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_4_10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		int[] arr = new int[20000001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(n1-- > 0) {
			arr[Integer.parseInt(st.nextToken()) + 10000000]++;
		}
		
		int n2 = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		while(n2-- > 0) {
			sb.append(arr[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
		}
		
		System.out.println(sb);
	}
}
