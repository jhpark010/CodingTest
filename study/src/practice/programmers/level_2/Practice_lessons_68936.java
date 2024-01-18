package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_68936 {
	public static void main(String[] args) {
		// Test Case
		int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		
		// Answer
		Practice_lessons_68936 main = new Practice_lessons_68936();
		System.out.println(Arrays.toString(main.solution(arr)));
		
	}
	
	public int[] solution(int[][] arr) {
		quad(0, 0, arr.length, arr);
		return new int[] {zeroCnt, oneCnt};
	}
	
	int oneCnt = 0;
	int zeroCnt = 0;
	
	public void quad(int x, int y, int size, int[][] arr) {
		if (size == 1) {
			if (arr[x][y] == 1) {
				oneCnt++;
			} else {
				zeroCnt++;
			}
		} else {
			int base = arr[x][y];
			boolean breakFlag = false;
			
			root : for (int i = x; i < size + x; i++) {
				for (int j = y; j < size + y; j++) {
					if (base != arr[i][j]) {
						breakFlag = true;
						break root;
					}
				}
			}
			
			if (!breakFlag) {
				if (base == 1) {
					oneCnt++;
				} else {
					zeroCnt++;
				}
			} else {
				int mid = size / 2;
				
				//1사분면
				quad(x, y + mid, mid, arr);
				//2사분면
				quad(x, y, mid, arr);
				//3사분면
				quad(x + mid, y, mid, arr);
				//2사분면
				quad(x + mid, y + mid, mid, arr);
			}
		}
	}
}


















