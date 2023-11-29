package programmers.level_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_68936 {
	
	public static void main(String[] args) {
		// Test Case
		int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
//		int[][] arr = {{1,1,0,0}, {1,0,0,0}, {1,0,0,1}, {1,1,1,1}};
		
		// Answer
		Problem_68936 main = new Problem_68936();
		System.out.println(Arrays.toString(main.solution(arr)));

	}
	
	/**
	 * 풀이 참조
	 */
	
	
	int[] answer;
	
	public int[] solution(int[][] arr) {
		answer = new int[2];
		int size = arr.length;
		
		quad(arr, 0, 0, size);
		
		return answer;
	}
	
	public boolean isCheck(int[][]arr, int x, int y, int size, int value) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != value) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void quad(int[][] arr, int x, int y, int size) {
		if(isCheck(arr, x, y, size, arr[x][y])) {
			if(arr[x][y] == 0) {
				answer[0]++;
			} else if (arr[x][y] == 1) {
				answer[1]++;
			}
			
			return;
		}
		
		//사분면 분할
		quad(arr, x, y, size / 2); //4사분면
		quad(arr, x + (size / 2), y, size / 2); //3사분면
		quad(arr, x, y + (size / 2), size / 2); //1사분면
		quad(arr, x + (size / 2), y + (size / 2), size / 2); //2사분면
	}
}













