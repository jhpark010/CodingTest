package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver_3_9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] arr = new long[101];
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		arr[4] = 2;
		arr[5] = 2;
		
		for (int i = 6; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 5];
		}
		
		while (T-- > 0) {
			sb.append(arr[Integer.parseInt(br.readLine())]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
