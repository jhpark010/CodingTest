package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bronze_2_1978 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		
		for (int i = 1; i <= n; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if (num == 1) {
				continue;
			}
			
			boolean flag = false;
			
			for (int j = 2; j < num; j ++) {
				if (num % j == 0) {
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}











