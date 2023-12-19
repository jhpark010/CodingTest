package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold_5_10026 {
	static char[][] box;
	static char[][] boxCopy;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int N, normalTotal, colorBlindTotal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		box = new char[N][N];
		boxCopy = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			
			for (int j = 0; j < N; j++) {
				box[i][j] = tmp.charAt(j);
				boxCopy[i][j] = tmp.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (box[i][j] != 'A') {
					normal(i, j);
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (boxCopy[i][j] != 'A') {
					colorBlind(i, j);
				}
			}
		}
		
		System.out.println(normalTotal);
		System.out.println(colorBlindTotal);
	}
	
	public static void normal(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		char base = box[x][y];
		q.add(new int[] {x, y});
		box[x][y] = 'A';
		
		while(!q.isEmpty()) {
			int[] coor = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + coor[0];
				int ny = dy[i] + coor[1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (box[nx][ny] != base) continue;
				
				box[nx][ny] = 'A';
				q.add(new int[] {nx, ny});
			}
		}
		normalTotal++;
	}
	
	public static void colorBlind(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		char base = boxCopy[x][y] != 'B' ? 'S' : 'B';
		q.add(new int[] {x, y});
		boxCopy[x][y] = 'A';
		
		while(!q.isEmpty()) {
			int[] coor = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + coor[0];
				int ny = dy[i] + coor[1];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (boxCopy[nx][ny] == 'A') continue;
				
				if (base == 'S' && (boxCopy[nx][ny] == 'R' || boxCopy[nx][ny] == 'G')) {
					boxCopy[nx][ny] = 'A';
					q.add(new int[] {nx, ny});
					
				} else {
					if (boxCopy[nx][ny] != base) {
						continue;
					} else {
						boxCopy[nx][ny] = 'A';
						q.add(new int[] {nx, ny});
					}
				}
				
			}
		}
		colorBlindTotal++;
	}
}

















	
	
	
	
	
	
	



