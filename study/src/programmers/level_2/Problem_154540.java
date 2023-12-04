package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_154540 {
	
	public static void main(String[] args) {
		// Test Case
		String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
		
		// Answer
		Problem_154540 main = new Problem_154540();
		System.out.println(Arrays.toString(main.solution(maps)));

	}
	
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	List<Integer> answer;
	
	public int[] solution(String[] maps) {
		answer = new ArrayList<>();
		String[][] map = new String[maps.length][maps[0].length()];
		
		for (int i = 0; i < maps.length; i++) {
			map[i] = maps[i].split("");
		}
		
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (map[x][y].equals("X")) continue;
				bfs(x, y, map);
			}
		}
		
		Collections.sort(answer);
		
		if (answer.size() == 0) answer.add(-1);
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public void bfs(int x, int y, String[][] map) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		int sum = Integer.parseInt(map[x][y]);
		map[x][y] = "X";
		
		while(!q.isEmpty()) {
			int[] coor = q.poll();
			int coorX = coor[0];
			int coorY = coor[1];
			
			for (int i = 0; i < dx.length; i++) {
				int nx = coorX + dx[i];
				int ny = coorY + dy[i];
				
				if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[nx].length && !map[nx][ny].equals("X")) {
					sum += Integer.parseInt(map[nx][ny]);
					map[nx][ny] = "X";
					q.add(new int[] {nx, ny});
				}
			}
		}
		
		answer.add(sum);
	}
}

























