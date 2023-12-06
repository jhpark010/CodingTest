package baekjoon.Bronze;

import java.util.Scanner;

public class Bronze_1_2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int days = (V - B) / (A - B);
		
		if ((V - A) % (A - B) != 0) {
			days++;
		}
		
		System.out.println(days);
	}
}











