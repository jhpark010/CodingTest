package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver_2_1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("-");
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) sum += getSum(arr[i]);
			else sum -= getSum(arr[i]);
		}
		System.out.println(sum);
	}
	
	public static int getSum(String s) {
		String[] tmp = s.split("\\+");
		int sum = 0;
		
		for (String str : tmp) {
			sum += Integer.parseInt(str);
		}
		return sum;
	}
}















