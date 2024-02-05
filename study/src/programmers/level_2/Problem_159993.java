package programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_159993 {
	public static void main(String[] args) {
		Problem_159993 main = new Problem_159993();
		String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
		
		System.out.println(main.solution(maps));
	}
	
	public int solution(String[] maps) {
        char[][] maze = new char[maps.length][maps[0].length()];
        int[] lever = new int[2];
        int[] start = new int[2];
        int[] exit = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            char[] tmp = maps[i].toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (tmp[j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (tmp[j] == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
                
                maze[i][j] = tmp[j];
            }
        }
        
        int answer = -1;
        int leverCost = leverToStart(start, lever, maze);
        
        if (leverCost != -1) {
            int exitCost = exitToLever(exit, lever, leverCost, maze);
            
            if (exitCost != -1) answer = exitCost;
        }
        
        return answer;
    }
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int leverToStart(int[] start, int[] lever, char[][] maze) {
        int[][] cost = new int[maze.length][maze[0].length];
        boolean findFlag = false;
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            
            if (maze[tmp[0]][tmp[1]] == 'L') {
                findFlag = true;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                
                if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[nx].length) continue;
                if (maze[nx][ny] == 'X') continue;
                
                cost[nx][ny] = cost[tmp[0]][tmp[1]] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        
        if (findFlag) return cost[lever[0]][lever[1]];
        else return -1;
    }
    
    public int exitToLever(int[] exit, int[] lever, int leverCost, char[][] maze) {
        int[][] cost = new int[maze.length][maze[0].length];
        cost[lever[0]][lever[1]] = leverCost;
        boolean findFlag = false;
        Queue<int[]> q = new LinkedList<>();
        q.add(lever);
        
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            
            if (maze[tmp[0]][tmp[1]] == 'E') {
                findFlag = true;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                
                if (nx < 0 || nx >= maze.length || ny < 0 || ny >= maze[nx].length) continue;
                if (maze[nx][ny] == 'X') continue;
                
                cost[nx][ny] = cost[tmp[0]][tmp[1]] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        
        if (findFlag) return cost[exit[0]][exit[1]];
        else return -1;
    }
}
