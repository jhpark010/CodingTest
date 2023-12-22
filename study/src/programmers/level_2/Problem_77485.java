package programmers.level_2;

import java.util.Arrays;

public class Problem_77485 {
	public static void main(String[] args) {
		// Test Case
//		int rows = 6;
//		int columns = 6;
		int rows = 3;
		int columns = 3;
//		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}}; 
		int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}; 
		

		// Answer
		Problem_77485 p = new Problem_77485();
		System.out.println(Arrays.toString(p.solution(rows, columns, queries)));

	}

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] board = new int[rows + 1][columns + 1];
		int val = 1;
		
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				board[i][j] = val++; 
			}
		}
		
		for (int i = 0; i < queries.length; i++) {
			answer[i] = solve(queries[i], board);
		}
		
		return answer;
	}
	
	
	public int solve(int[] query, int[][] board) {
		int min = Integer.MAX_VALUE;
		int x1 = query[0];
		int y1 = query[1];
		int x2 = query[2];
		int y2 = query[3];
		
		//좌로 시작할 때 처음 값
		int first = board[x1][y2];
		
		// 시계 반대 방향 순서로 진행 (시작 윗변)
		// y2 -> y1로 이동(윗쪽 변)
		for (int i = y2; i > y1; i--) {
			board[x1][i] = board[x1][i - 1];
			min = Math.min(min, board[x1][i]);
		}
		
		// x1 -> x2로 이동(왼쪽 변)
		for (int i = x1; i < x2; i++) {
			board[i][y1] = board[i + 1][y1];
			min = Math.min(min, board[i][y1]);
		}
		
		// y1 -> y2로 이동(아래쪽 변)
		for (int i = y1; i < y2; i++) {
			board[x2][i] = board[x2][i + 1];
			min = Math.min(min, board[x2][i]);
		}
		
		// x2 -> x1 + 1 이동 (오른쪽 변)
		for (int i = x2; i > x1 + 1; i--) {
			board[i][y2] = board[i - 1][y2];
			min = Math.min(min, board[i][y2]);
		}
		
		board[x1 + 1][y2] = first;
		min = Math.min(board[x1 + 1][y2], min);
		
		return min;
	}
	
}





