package practice.programmers.level_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice_lessons_0 {
	public static void main(String[] args) {
		// Test Case
		
		// Answer
		Practice_lessons_0 main = new Practice_lessons_0();
		System.out.println(main.solution());
		
	}
	
	public int solution() {
		try {
			test();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		
		return 0;
	}
	
	public void test() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		int m = Integer.parseInt(br.readLine());
//		char[] arr = br.readLine().toCharArray();
		int n = 2;
		int m = 13;
		char[] arr = "OOIOIOIOIIOII".toCharArray();
		int[] memo = new int[m];
		int answer = 0;
		
		for (int i = 1; i < m - 1; i++) {
			if (arr[i] == 'O' && arr[i + 1] == 'I') {
				memo[i + 1] = memo[i - 1] + 1;
				
				System.out.println(i + 1 - (2 * n));
				
				if (memo[i + 1] >= n && arr[i + 1 - (2 * n)] == 'I') {
					answer++;
				}
			}
		}
		System.out.println(Arrays.toString(memo));
		System.out.println(Arrays.toString(arr));
		System.out.println(answer);
	}
	
}


















