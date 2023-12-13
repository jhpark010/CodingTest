package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver_4_18110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		long avg = Math.round(size * 0.15);
		long[] arr = new long[size];
		
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		double sum = 0;
		for (int i = (int)avg; i < size - avg; i++) {
			sum += arr[i];
		}
		
		System.out.println(Math.round(sum / (size - (avg * 2))));
	}
}
