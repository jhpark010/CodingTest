package programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_1844 {
	public static void main(String[] args) {
		// Test Case
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		// Answer
		Problem_1844 p = new Problem_1844();
		System.out.println(p.solution(maps));
		
	}
	
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	int[][] newMaps;
	int[][] copyMaps;
	
	public int solution(int[][] maps) {
		newMaps = new int[maps.length + 1][maps[0].length + 1];
		copyMaps = new int[maps.length + 1][maps[0].length + 1];
		
		for (int i = 1; i < newMaps.length; i++) {
			for (int j = 1; j < newMaps[i].length; j++) {
				newMaps[i][j] = maps[i - 1][j - 1];
			}
		}
		
		int answer = bfs(1, 1);
		
		return answer;
    }
	
	public int bfs (int x, int y) {
		Queue<Coor> q = new LinkedList<>();
		q.offer(new Coor(x, y));
		newMaps[x][y] = 0;
		copyMaps[x][y] = 1;
		
		while(!q.isEmpty()) {
			Coor tmp = q.poll();
			
			for (int i = 0; i < dx.length; i ++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if (nx >= 1 && nx < newMaps.length && ny >= 1 && ny < newMaps[0].length
						&& newMaps[nx][ny] == 1) {
					copyMaps[nx][ny] = copyMaps[tmp.x][tmp.y] + 1;
					newMaps[nx][ny] = 0;
					q.offer(new Coor(nx, ny));
				}
			}
		}
		
		int answer = copyMaps[newMaps.length - 1][newMaps[0].length - 1];
		
		return answer == 0 ? -1 : answer;
	}
	
	class Coor {
		int x;
		int y;
		
		Coor (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

















