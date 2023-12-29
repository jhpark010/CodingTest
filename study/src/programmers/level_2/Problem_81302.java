package programmers.level_2;

import java.util.Arrays;

public class Problem_81302 {
	public static void main(String[] args) {
		// Test Case
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		
		// Answer
		Problem_81302 p = new Problem_81302();
		System.out.println(Arrays.toString(p.solution(places)));

	}

	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		
		for (int i = 0; i < 5; i++) {
			char[][] room = new char[5][5];
			
			for (int j = 0; j < 5; j++) {
				room[j] = places[i][j].toCharArray(); 
			}
			
			if (isPossible(room)) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}
		
		return answer;
	}
	
	public boolean isPossible(char[][] room) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (room[i][j] == 'P') {
					// 상하좌우 1칸
					int[] dxOne = {-1, 0, 1, 0};
					int[] dyOne = {0, 1, 0, -1};
					
					for (int k = 0; k < 4; k++) {
						int nx = dxOne[k] + i;
						int ny = dyOne[k] + j;
						
						if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && room[nx][ny] == 'P') {
							return false;
						}
					}
					
					// 상하좌우 2칸
					int[] dxTwo = {-2, 0, 2, 0};
					int[] dyTwo = {0, 2, 0, -2};
					
					for (int k = 0; k < 4; k++) {
						int nx = dxTwo[k] + i;
						int ny = dyTwo[k] + j;
						
						if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 
								&& room[nx][ny] == 'P' && room[(i + nx) / 2][(j + ny) / 2] == 'O') {
							return false;
						}
					}
					
					// 대각선
					int[] dxCross = {-1, -1, 1, 1};
					int[] dyCross = {-1, 1, 1, -1};
					
					for (int k = 0; k < 4; k++) {
						int nx = dxCross[k] + i;
						int ny = dyCross[k] + j;
						
						if (nx >= 0 && nx < 4 && nx + i >= 0 && nx + i < 4 
								&& ny >= 0 && ny < 4 && ny + j >= 0 && ny + j < 4 
								&& room[nx][ny] == 'P'
								&& (room[nx + i][ny] == 'O' || room[nx][ny + j] == 'O')) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
}	



