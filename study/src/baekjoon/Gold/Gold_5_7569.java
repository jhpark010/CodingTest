package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 3차원 배열 써서 작성
 */

public class Gold_5_7569 {
	static int[][][] box;
	static int[] dx = {-1, 0, 1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	static int x, y, h, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		box = new int[h][x][y];
		int zeroCnt = 0;
		Queue<Coor> q = new LinkedList<>();
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < x; j++) {
				st = new StringTokenizer(br.readLine());
				
				for (int k = 0; k < y; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					
					if (box[i][j][k] == 0) zeroCnt++;
					else if (box[i][j][k] == 1) {
						q.add(new Coor(i, j, k));
					}
				}
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
					int nz = dz[j] + c.z;
					
					if (nx < 0 || nx >= x || ny < 0 || ny >= y || nz < 0 || nz >= h) continue;
					if (box[nz][nx][ny] != 0) continue;
					
					box[nz][nx][ny] = box[c.z][c.x][c.y] + 1;
					cnt = box[nz][nx][ny];
					q.add(new Coor(nz, nx, ny));
					
				}
			}
		}
	}
	
	public static boolean isCheck() {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < x; j++) {
				for (int k = 0; k < y; k++) {
					if (box[i][j][k] == 0) return false;
				}
			}
		}
		return true;
	}
	
	static class Coor {
		int z;
		int x;
		int y;
		
		Coor (int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}
}

















	
	
	
	
	
	
	



