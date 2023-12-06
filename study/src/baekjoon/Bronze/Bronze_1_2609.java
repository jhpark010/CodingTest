package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bronze_1_2609 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		StringBuilder sb = new StringBuilder();
		int gcd = gcd(a, b);
		
		sb.append(gcd).append("\n");
		sb.append((a * b) / gcd);
		
		System.out.println(sb.toString());
		
	}
	
	public static int gcd(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
	
//	public static int lcm(int a, int b) {
//		return (a * b) / gcd(a, b);
//	}
}











