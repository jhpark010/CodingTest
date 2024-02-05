package practice.programmers.level_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice_lessons_181832 {
	public static void main(String[] args) {
		// Test Case
		int n = 10;
		
		// Answer
		Practice_lessons_181832 main = new Practice_lessons_181832();
		System.out.println(Arrays.toString(main.solution(n)));
	}
	
	int val = 1;
	int x = 0;
	int y = 0;
    
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        while(answer[x][y] == 0) {
            moveRight(answer, n);
            moveDown(answer, n);
            moveLeft(answer, n);
            moveUp(answer, n);
        }
        return answer;
    }
    
    public void moveRight(int[][] answer, int n) {
        int i = y;
        
        for (; i < n; i++) {
            if (answer[x][i] != 0) {
                break;
            }
            answer[x][i] = val++;
        }
        
        y = i - 1;
        x += 1;
    }
    
    public void moveDown(int[][] answer, int n) {
        int i = x;
        
        for (; i < n; i++) {
            if (answer[i][y] != 0) {
                break;
            }
            answer[i][y] = val++;
        }
        x = i - 1;
        y -= 1;
    }
    
    public void moveLeft(int[][] answer, int n) {
        int i = y;
        
        for (; i >= 0; i--) {
            if (answer[x][i] != 0) {
            	break;
            }
            answer[x][i] = val++;
        }
        y = i + 1;
        x -= 1;
    }
    
    public void moveUp(int[][] answer, int n) {
        int i = x;
        
        for (; i >= 0; i--) {
            if (answer[i][y] != 0) {
                break;
            }
            answer[i][y] = val++;
        }
        
        x = i + 1;
        y += 1;
    }
}


















