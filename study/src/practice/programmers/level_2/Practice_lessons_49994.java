package practice.programmers.level_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Practice_lessons_49994 {
	public static void main(String[] args) {
		// Test Case
		String dirs = "LRLRLRLRLRLR";
//		String dirs = "ULURRDLLU";
//		String dirs = "LULLLLLLU";
		
		// Answer
		Practice_lessons_49994 main = new Practice_lessons_49994();
		System.out.println(main.solution(dirs));
		
	}
	
	public int solution(String dirs) {
		return solve(dirs);
	}
	
	public int solve(String dirs) {
		// x1y1x2y2, x2y2x1y1 저장
		// 가능 방향 뿐만 아니라 LRLR 같은 경우도 생각해야함. answer = 1
		// 기존 소스코드는 방향만 신경씀 ex. LURDL
		Set<String> set = new HashSet<>();
		Map<String, int[]> map = new HashMap<>();
		
		map.put("U", new int[] {1, 0});
		map.put("D", new int[] {-1, 0});
		map.put("L", new int[] {0, -1});
		map.put("R", new int[] {0, 1});
		
		String[] dir = dirs.split("");
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < dir.length; i++) {
			String s = dir[i];
			int tmpX = map.get(s)[0];
			int tmpY = map.get(s)[1];
			
			x += tmpX;
			y += tmpY;
			
			if (x < -5 || x > 5) {
				x -= tmpX;
				continue;
			}
			
			if (y < -5 || y > 5) {
				y -= tmpY;
				continue;
			}
			
			System.out.println(x + ", " + y + ", " + s);

			set.add(x + "" + y + "" + (x - tmpX) + "" + (y - tmpY));
			set.add((x - tmpX) + "" + (y - tmpY) + "" + x + "" + y);
		}
		
		System.out.println(set.size() / 2);
		
		return 0;
	}
	
	/*
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	
	public int solve(String dirs) {
		String[][] visited = new String[11][11];
		
		for (String[] tmp : visited) {
			Arrays.fill(tmp, "");
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {5, 5});
		
		String[] dir = dirs.split("");
		int cnt = 0;
		
		for (int i = 0; i < dir.length; i++) {
			int[] tmp = q.poll();
			String s = dir[i];
			int nx = 0;
			int ny = 0;
			
			if (s.equals("L")) {
				nx = tmp[0];
				ny = tmp[1] - 1;
				
			} else if (s.equals("U")) {
				nx = tmp[0] - 1;
				ny = tmp[1];
				
			} else if (s.equals("R")) {
				nx = tmp[0];
				ny = tmp[1] + 1;
				
			} else if (s.equals("D")) {
				nx = tmp[0] + 1;
				ny = tmp[1];
			}
			
			if (nx >= 0 && nx < 11 && ny >= 0 && ny < 11) {
				if (!visited[nx][ny].contains(s)) {
					visited[nx][ny] += s;
					System.out.println(nx + "," + ny);
					q.add(new int[] {nx, ny});
					cnt++;
				} else {
					q.add(new int[] {nx, ny});
				}
			} else {
				q.add(tmp);
			}
		}
		
		return cnt;
	}
	 */
}


















