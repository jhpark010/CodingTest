package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver_4_1920 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n1 = Integer.parseInt(br.readLine());
		int[] arr = new int[n1];
		
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int n2 = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n2; i++) {
			if (binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	public static int binarySearch(int[] arr, int num) {
		int lt = 0;
		int rt = arr.length;
		
		while (lt < rt) {
			int mid = (rt + lt) / 2;
			
			if (num == arr[mid]) {
				return 1;
			} else if (num < arr[mid]) {
				rt = mid - 1;
				
			} else if (num > arr[mid]) {
				lt = mid + 1;
			}
		}
		
		return -1;
	}
}
