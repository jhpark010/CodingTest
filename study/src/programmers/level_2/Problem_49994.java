package programmers.level_2;

import java.util.HashSet;

public class Problem_49994 {
	public static void main(String[] args) {
		// Test Case
//		String dirs = "UDLRDURL";
//		String dirs = "ULURRDLLU";
		String dirs = "LULLLLLLU";

		// Answer
		Problem_49994 main = new Problem_49994();
		System.out.println(main.solution(dirs));

	}

	public int[] dx = { -1, 0, 1, 0 };
	public int[] dy = { 0, 1, 0, -1 };
	public int[][] board;

	public int solution(String dirs) {
		int answer = 0;
		board = new int[11][11];
		board[5][5] = 1;
		answer = move(dirs);

		return answer;
	}

	public int move(String dirs) {
		int curX = 5;
		int curY = 5;
		String[] dirArr = dirs.split("");
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < dirArr.length; i++) {
			StringBuilder tmp = new StringBuilder();
			int nextX = curX;
			int nextY = curY;

			if (dirArr[i].equals("U")) {
				nextX = curX + dx[0];

			} else if (dirArr[i].equals("R")) {
				nextY = curY + dy[1];

			} else if (dirArr[i].equals("D")) {
				nextX = curX + dx[2];

			} else if (dirArr[i].equals("L")) {
				nextY = curY + dy[3];
			}

			if (nextX < 0 || nextX >= 11 || nextY < 0 || nextY >= 11) {
				continue;
			}

			tmp.append(curX);
			tmp.append(curY);
			tmp.append(nextX);
			tmp.append(nextY);
			set.add(tmp.toString());
			
			tmp = new StringBuilder();
			
			tmp.append(nextX);
			tmp.append(nextY);
			tmp.append(curX);
			tmp.append(curY);
			set.add(tmp.toString());
			
			curX = nextX;
			curY = nextY;
		}

		return set.size() / 2;
	}
}
