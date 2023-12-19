package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold_5_7576 {
	static int[][] box;
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int x, y, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		box = new int[x][y];
		
		int zeroCnt = 0;
		Queue<Coor> q = new LinkedList<>();
		
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < y; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());

				if (box[i][j] == 0) zeroCnt++;
				else if (box[i][j] == 1) q.add(new Coor(i, j));
			}
		}
		
		if (zeroCnt == 0) {
			System.out.println(0);
			
		} else {
			BFS(q);
			if (isCheck()) {
				System.out.println(cnt - 1);
			} else {
				System.out.println(-1);
			}
		}
	}
	
	public static void BFS(Queue<Coor> q) {
		while(!q.isEmpty()) {
			int len = q.size();
			
			for (int i = 0; i < len; i++) {
				Coor c = q.poll();
				
				for (int j = 0; j < 6; j++) {
					int nx = dx[j] + c.x;
					int ny = dy[j] + c.y;
					
					if (nx < 0 || nx >= x || ny < 0 || ny >= y) continue;
					if (box[nx][ny] != 0) continue;
					
					box[nx][ny] = box[c.x][c.y] + 1;
					cnt = box[nx][ny];
					q.add(new Coor(nx, ny));
					
				}
			}
		}
	}
	
	public static boolean isCheck() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (box[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	static class Coor {
		int x;
		int y;
		
		Coor (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

















	
	
	
	
	
	
	



