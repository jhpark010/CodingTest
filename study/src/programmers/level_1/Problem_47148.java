package programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_47148 {
	
	public static void main(String[] args) {
		// Test Case
		int n = 5;
		
		// Answer
		Problem_47148 main = new Problem_47148();
		System.out.println(Arrays.toString(main.solution(n)));

	}
	
	/**
	 * 아래는 풀이 중 가장 효율이 좋을 것 같은 코드
	 */
	public int[] solution2(int n) {
		int[] answer = new int[(n * (n + 1)) / 2];
		int[][] matrix = new int[n][n];

		int x = -1, y = 0;
		int num = 1;

		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				if (i % 3 == 0) {
					++x;
				} else if (i % 3 == 1) {
					++y;
				} else if (i % 3 == 2) {
					--x;
					--y;
				}
				matrix[x][y] = num++;
			}
		}

		int k = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == 0)
					break;
				answer[k++] = matrix[i][j];
			}
		}

        return answer;
	}
	
	
	
	/**
	 * 아래는 직접 작성한 코드
	 */
	int[] dx = {1, 0, -1};
	int[] dy = {0, 1, -1};
	List<Integer> answerList = new ArrayList<>();
	
	public int[] solution(int n) {
		int[][] snail = new int[n][];
		for (int i = n; i >= 1; i--) {
			snail[i - 1] = new int[i];
		}
		
		snail[0][0] = 1;
		
		move(0, 0, snail);
		
		for (int i = 0; i < snail.length; i++) {
			for (int j = 0; j < snail[i].length; j++) {
				answerList.add(snail[i][j]);
			}
		}
		
		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public void move(int x, int y, int[][] snail) {
		Queue<int[]> q = new LinkedList<>();
		int[] arrow = new int[2];
		boolean arrowFlag = false;
		
		q.add(new int[] {x, y});
		
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int tmpX = tmp[0];
			int tmpY = tmp[1];
			
			if (arrowFlag) {
				int nx = tmpX + arrow[0];
				int ny = tmpY + arrow[1];
				
				if (nx >= 0 && nx < snail.length && ny >= 0 && ny <= nx && snail[nx][ny] == 0) {
					snail[nx][ny] = snail[tmpX][tmpY] + 1;
					q.add(new int[] {nx, ny});
					continue;
				} else {
					arrowFlag = false;
				}
			}
			
			for (int i = 0; i < dx.length; i++) {
				int nx = tmpX + dx[i];
				int ny = tmpY + dy[i];
				
				if (nx >= 0 && nx < snail.length && ny >= 0 && ny <= nx && snail[nx][ny] == 0) {
					snail[nx][ny] = snail[tmpX][tmpY] + 1;
					arrowFlag = true;
					arrow = new int[] {dx[i], dy[i]};
					
					q.add(new int[] {nx, ny});
					
					break;
				}
			}
			
		}
	}

}



















