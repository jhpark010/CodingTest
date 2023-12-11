package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bronze_2_2798 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(solve(arr, n, sum));
		
	}
	
	public static int solve (int[] arr, int n, int sum) {
		int curSum = 0;
		
		for (int i = 0; i < n - 2; i++) {
			if (arr[i] > sum) continue;
			
			for (int j = i + 1; j < n - 1; j++) {
				if (arr[i] + arr[j] > sum) continue;
				
				for (int k = j + 1; k < n; k++) {
					int total = arr[i] + arr[j] + arr[k];
					
					if (total == sum) {
						return total;
					}
					
					if (total < sum && curSum < total) {
						curSum = total;
					}
				}
			}
		}
		
		return curSum;
	}
}











