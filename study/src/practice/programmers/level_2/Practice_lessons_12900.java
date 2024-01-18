package practice.programmers.level_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice_lessons_12900 {
	public static void main(String[] args) {
		// Test Case
		int n = 9;
		
		// Answer
		Practice_lessons_12900 main = new Practice_lessons_12900();
		System.out.println(main.solution(n));
		
	}
	
	public int solution(int n) {
        long[] arr = new long[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }

        return (int)arr[n];
	}
}


















