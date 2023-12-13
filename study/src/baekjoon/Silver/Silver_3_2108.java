package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver_3_2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		double sum = 0;
		int[] arr = new int[n];
		int[] check = new int[8001];
		StringBuilder sb = new StringBuilder();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			max = Math.max(max, num);
			min = Math.min(min, num);
			arr[i] = num;
			check[num + 4000]++;
			sum += num;
		}
		
		Arrays.sort(arr);
		
		sb.append(Math.round(sum / n)).append("\n");
		sb.append(arr[arr.length / 2]).append("\n");
		
		int maxCnt = Integer.MIN_VALUE;
		int thirdNum = 0;
		boolean flag = false;
		
		for (int i = 0; i < arr.length; i++) {
			if (check[arr[i] + 4000] > maxCnt) {
				thirdNum = arr[i];
				maxCnt = check[arr[i] + 4000];
				flag = true;
			} else if (check[arr[i] + 4000] == maxCnt && thirdNum < arr[i]
					&& flag == true) {
				thirdNum = arr[i];
				flag = false;
			}
		}
		sb.append(thirdNum).append("\n");
		sb.append(max - min).append("\n");
		
		System.out.println(sb);
		
	}
}
