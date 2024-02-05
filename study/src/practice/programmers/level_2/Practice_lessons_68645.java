package practice.programmers.level_2;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice_lessons_68645 {
	public static void main(String[] args) {
		// Test Case
		
		// Answer
		Practice_lessons_68645 main = new Practice_lessons_68645();
		System.out.println(Arrays.toString(main.solution(800)));
		
	}
	public int[] solution(int n) {
        int[] answer = {};
        int[][] board = new int[n][n];
        int cnt = 1;
        int x = 0;
        int y = 0;
        board[x][y] = cnt++;
        boolean check = false;
        
        while(!check) {
            while (x + 1 < n && board[x + 1][y] == 0) {
                x += 1;
                board[x][y] = cnt++;
                check = true;
            }
            
            while (y + 1 < n && board[x][y + 1] == 0) {
                y += 1;
                board[x][y] = cnt++;
                check = true;
            }
            
            while (board[x - 1][y - 1] == 0) {
                x -= 1;
                y -= 1;
                board[x][y] = cnt++;
                check = true;
            }
            
            if (!check) break;
            else check = false;
        }
        
        List<Integer> list = new ArrayList<>();
        
        for (int[] arr : board) {
            for (int num : arr) {
                if (num != 0) list.add(num);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
	
}


















