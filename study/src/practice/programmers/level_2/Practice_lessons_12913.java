package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_12913 {
	public static void main(String[] args) {
		// Test Case
		int[][] land = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
		// Answer
		Practice_lessons_12913 main = new Practice_lessons_12913();
		System.out.println(main.solution(land));
		
	}
	
	public int solution(int[][] land) {
        for (int r = 1; r < land.length; r ++) {
            for (int i = 0; i < 4; i++) {
                int max = 0;
                
                for (int j = 0; j < 4; j ++) {
                    if (i == j) continue;
                    max = Math.max(max, land[r][i] + land[r - 1][j]);
                }
                land[r][i] = max;
            }
        }
        
        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }
	
}


















