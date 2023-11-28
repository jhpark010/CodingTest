package programmers.level_1;

import java.util.HashMap;
import java.util.HashSet;

public class Problem_17679 {
	public static void main(String[] args) {
		// Test Case
//		int m = 4;
//		int n = 5;
		int m = 6;
		int n = 6;
//		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		
		
		// Answer
		Problem_17679 main = new Problem_17679();
		System.out.println(main.solution(m, n, board));

	}

	
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] newBoard = new char[m][n];
		
		for (int i = 0; i < board.length; i ++) {
			newBoard[i] = board[i].toCharArray();
		}
		
		while (true) {
			int cnt = checkBoard(m, n, newBoard);
			
			if (cnt == 0) {
				break;
			}
			
			answer += cnt;
			destroyBlock(m, n, newBoard);
		}
		
		
		return answer;
	}
	
	public void destroyBlock(int x, int y, char[][] board) {
		for (int c = 0; c < y; c++) {
			for (int r = x - 1; r >= 0; r--) {
				if (board[r][c] == '.') {
					for (int nr = r - 1; nr >= 0; --nr) {
						if (board[nr][c] != '.') {
							board[r][c] = board[nr][c];
							board[nr][c] = '.';
							break;
						}
					}
				}
			}
		}
//		for (int c = 0; c < y; c++) {
//			for (int r = 0; r < x; r++) {
//				if (board[r][c] != '.') {
//					for (int t = r + 1; t < x; t++) {
//						if (board[t][c] == '.') {
//							board[t][c] = board[r][c];
//							board[r][c] = '.';
//							break;
//						}
//					}
//				}
//			}
//		}
	}
	
	
	public int checkBoard(int x, int y, char[][] board) {
		boolean[][] visited = new boolean[x][y];
		int cnt = 0;
		
		//원소마다 [2][2] 검사하기 때문에 각 행과 열에 -1
		for (int i = 0; i < x - 1; i++) {
			for (int j = 0; j < y - 1; j++) {
				if(board[i][j] == '.') continue;
				checkFourBlock(i, j, visited, board);
			}
		}
		
		for (int r = 0; r < x; r++) {
			for (int c = 0; c < y; c++) {
				if (visited[r][c]) {
					cnt ++;
					board[r][c] = '.';
				}
			}
		}
		
		return cnt;
	}
	
	public void checkFourBlock(int x, int y, boolean[][] visited, char[][] board) {
		char value = board[x][y];
		
		for (int r = x; r <= x + 1; r++) {
			for (int c = y; c <= y + 1; c++) {
				if (board[r][c] != value) {
					return;
				}
			}
		}
		
		for (int r = x; r <= x + 1; r++) {
			for (int c = y; c <= y + 1; c++) {
				visited[r][c] = true;
			}
		}
	}
	
}













