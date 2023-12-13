package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver_2_1012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			int[][] board = new int[h][w];
			
			for (int i = 1; i <= cnt; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				board[x][y] = 1;
			}
			
			int answer = 0;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (board[i][j] == 1) {
						solve(board, i, j);
						answer++;
					}
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void solve(int[][] board, int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];
				
				if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[nx].length
						&& board[nx][ny] == 1) {
					board[nx][ny] = 0;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
}















