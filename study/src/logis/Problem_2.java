package logis;

import java.util.ArrayList;
import java.util.List;

public class Problem_2 {
	/*
	 * 직사각형을 만드는데 4개의 점 중 3개의 좌표만 주어짐
	 * 
	 */
	public static void main(String[] args) {
		Problem_2 main = new Problem_2();
		int[][] v = {{1, 4}, {3, 4}, {3, 10}};
		
		main.solution(v);
	}
	
	public int[] solution(int[][] v) {
        int x = 0;
        int y = 0;
        
        if (v[0][0] == v[1][0]) {
            x = v[2][0];
        } else if (v[0][0] == v[2][0]) {
            x = v[1][0];
        } else {
            x = v[0][0];
        }

        if (v[0][1] == v[1][1]) {
            y = v[2][1];
        } else if (v[0][1] == v[2][1]) {
            y = v[1][1];
        } else {
            y = v[0][1];
        }

        return new int[]{x, y};
    }

}
