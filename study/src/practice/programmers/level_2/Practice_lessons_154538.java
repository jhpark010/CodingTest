package practice.programmers.level_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice_lessons_154538 {
	public static void main(String[] args) {
		// Test Case
//		int x = 10;
//		int y = 40;
//		int n = 5;
		int x = 2;
		int y = 10;
		int n = 3;
		
		// Answer
		Practice_lessons_154538 main = new Practice_lessons_154538();
		System.out.println(main.solution(x, y, n));
		
	}
	
	final static int MAX = 1000001;
	
	public int solution(int x, int y, int n) {
        int[] arr = new int[y + 1];
        Arrays.fill(arr, MAX);
        arr[x] = 0;
        
        for (int i = x; i <= y; i++) {
            if (arr[i] != MAX) {
                int one = i + n;
                int two = i * 2;
                int three = i * 3;
                
                if (one <= y && arr[i] + 1 < arr[one]) {
                    arr[one] = arr[i] + 1;
                }
                
                if (two <= y && arr[i] + 1 < arr[two]) {
                    arr[two] = arr[i] + 1;
                }
                
                if (three <= y && arr[i] + 1 < arr[three]) {
                    arr[three] = arr[i] + 1;
                }
            }
        }
        
        return arr[y] == MAX ? -1 : arr[y];
    }
}


















