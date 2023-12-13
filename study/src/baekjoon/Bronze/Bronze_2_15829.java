package baekjoon.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Bronze_2_15829 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String str = br.readLine();
		BigInteger sum = new BigInteger("0");
		
		/*
		 * 풀이 보지 않았을 때 50점
		 */
		
		for (int i = 0; i < l; i++) {
			sum = sum.add(BigInteger.valueOf(str.charAt(i) - 96).multiply(BigInteger.valueOf(31).pow(i)));
		}
		System.out.println(sum.remainder(BigInteger.valueOf(1234567891)));
	}
}

/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		String str = br.readLine();
		long sum = 0;
		
		for (int i = 0; i < l; i++) {
			int a = str.charAt(i) - 96;
			sum += a * Math.pow(31, i);
		}
		
		System.out.println(sum);

 */









