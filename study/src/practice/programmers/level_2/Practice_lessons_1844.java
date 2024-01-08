package practice.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Practice_lessons_1844 {
	public static void main(String[] args) {
		// Test Case
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		// Answer
		Practice_lessons_1844 main = new Practice_lessons_1844();
		System.out.println(main.solution(maps));
		
	}
	
	//start = (0, 0) / end = (4, 4);
	
	public int solution(int[][] maps) {
        int maxX = maps.length;
        int maxY = maps[0].length;
        
		return bfs(maxX, maxY, maps);
	}
	
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	
	public int bfs(int maxX, int maxY, int[][] maps) {
		int[][] dist = new int[maxX][maxY];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		dist[0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + tmp[0];
				int ny = dy[i] + tmp[1];
				
				if (nx < 0 || nx >= maxX || ny < 0 || ny >= maxY) continue;
				if (maps[nx][ny] != 1 || dist[nx][ny] != 0) continue;
				
				q.add(new int[] {nx, ny});
				dist[nx][ny] = dist[tmp[0]][tmp[1]] + 1;
			}
		}
		
		return dist[maxX - 1][maxY - 1] == 0 ? -1 : dist[maxX - 1][maxY - 1];
	}
	
}


















