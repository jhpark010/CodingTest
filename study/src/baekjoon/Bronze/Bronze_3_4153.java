package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bronze_3_4153 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[3];
			
			int zeroCnt = 0;
			
			for (int i = 0; i < 3; i++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 0) zeroCnt++;
				
				arr[i] = n;
			}
			
			if (zeroCnt == 3) break;
			
			Arrays.sort(arr);
			
			arr[0] = arr[0] * arr[0];
			arr[1] = arr[1] * arr[1];
			int sqrt = (int) Math.sqrt(arr[0] + arr[1]);
			
			
			if (sqrt == arr[2]) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
		}
		
		System.out.println(sb);
	}
}











