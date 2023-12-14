package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold_4_1987 {
	static char[][] board;
	static boolean[] alpha;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int R, C, max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		max = Integer.MIN_VALUE;
		alpha = new boolean[26];
		
		for (int i = 0 ;i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		alpha[board[0][0] - 'A'] = true;
		DFS(0, 0, 1);
		
		System.out.println(max);
	}
	
	public static void DFS(int x, int y, int count) {
		max = Math.max(max, count);
		
		for (int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < R && ny >= 0 && ny < C
					&& !alpha[board[nx][ny] - 'A']) {
				alpha[board[nx][ny] - 'A'] = true;
				DFS(nx, ny, count + 1);
				alpha[board[nx][ny] - 'A'] = false;
			}
			
		}
	}
}

















	
	
	
	
	
	
	



