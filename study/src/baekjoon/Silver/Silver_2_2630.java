package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_2_2630 {
	static int[][] board;
	static int whiteCnt = 0;
	static int blueCnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boardRecursion(0, 0, N);
		
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
		
	}
	
	public static void boardRecursion(int x, int y, int size) {
		// 1. 전체가 모두 같은 색상으로 되어있는지 체크
		if (isSameColor(x, y, size)) {
			// 2. 전체가 같은 색상이면 white, blue 개수 +1
			if (board[x][y] == 0) {
				whiteCnt++;
			} else {
				blueCnt++;
			}
			return;
		}
		
		// 3. 전체가 같은 색상이 아닐 경우 변의 길이 / 2 만큼 분할
		int half = size / 2;
		
		//제2사분면
		boardRecursion(x, y, half);
		
		//제1사분면 (y 증가)
		boardRecursion(x, y + half, half);
		
		//제3사분면 (x 증가)
		boardRecursion(x + half, y, half);
		
		//제4사분면 (x, y 증가)
		boardRecursion(x + half, y + half, half);
	}
	
	public static boolean isSameColor(int x, int y, int size) {
		// 처음 색상 값 저장
		int base = board[x][y];
		
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (base != board[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}















