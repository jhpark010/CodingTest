package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver_1_2178 {
	static int[][] board;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp[j] - '0'; 
			}
		}
		BFS(0, 0);
		System.out.println(board[N - 1][M - 1]);
	}
	
	public static void BFS(int x, int y) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		boolean[][] visited = new boolean[N][M];
		int[] Coor = new int[2];
		Queue<int[]> q = new LinkedList<>();
		visited[x][y] = true;
		
		q.add(Coor);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i ++) {
				int nx = dx[i] + now[0];
				int ny = dy[i] + now[1];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M
						&& !visited[nx][ny] && board[nx][ny] != 0) {
					visited[nx][ny] = true;
					board[nx][ny] = board[now[0]][now[1]] + 1;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
}















