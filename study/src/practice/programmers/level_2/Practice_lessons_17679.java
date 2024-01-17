package practice.programmers.level_2;

import java.util.Optional;

public class Practice_lessons_17679 {
	public static void main(String[] args) {
		// Test Case
//		int m = 4;
//		int n = 5;
//		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		int m = 6;
		int n = 6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

		// Answer
		Practice_lessons_17679 main = new Practice_lessons_17679();
		System.out.println(main.solution(m, n, board));

	}

	public int solution(int m, int n, String[] board) {
		char[][] newBoard = new char[m][n];

		for (int i = 0; i < board.length; i++) {
			newBoard[i] = board[i].toCharArray();
		}

		int cnt = checkBoard(m, n, newBoard);

		return cnt;
	}

	public int destroyBlock(char[][] newBoard, boolean[][] visited) {
		int destroyCnt = 0;
		
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if (visited[i][j]) {
					newBoard[i][j] = '0';
					destroyCnt++;
				}
			}
		}
		return destroyCnt;
	}
	
	public int cleanBoard(int m, int n, char[][] newBoard) {
		for (int c = 0; c < n; c++) {
			for (int x = m - 1; x >= 0; x--) {
				if (newBoard[x][c] == '0') {
					int y = x - 1;
					for (; y >= 0; y--) {
						if (newBoard[y][c] != '0') {
							newBoard[x][c] = newBoard[y][c];
							newBoard[y][c] = '0';
							break;
						}
					}
				}
			}
		}
		
//		for (char[] a : newBoard) {
//			System.out.println(String.valueOf(a));
//		}
//		
//		System.out.println();
		
		return checkBoard(m, n, newBoard);
	}
	
	public int checkBoard(int m, int n, char[][] newBoard) {
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				char c = newBoard[i][j];
				if (c == '0') continue;
				
				if (c == newBoard[i][j + 1] && c == newBoard[i + 1][j] && c == newBoard[i + 1][j + 1]) {
					visited[i][j] = true;
					visited[i][j + 1] = true;
					visited[i + 1][j] = true;
					visited[i + 1][j + 1] = true;
				}
			}
		}
		
		int result = destroyBlock(newBoard, visited);
		
		if (result != 0) {
			result += cleanBoard(m, n, newBoard);
		}
		
		return result;
	}
}
