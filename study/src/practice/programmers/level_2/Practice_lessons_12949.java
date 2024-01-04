package practice.programmers.level_2;

public class Practice_lessons_12949 {
	public static void main(String[] args) {
		// Test Case
		int[][] arr1 = {{1,4},{3,2},{4,1}};
		int[][] arr2 = {{3,3},{3,3}};
		
		// Answer
		Practice_lessons_12949 p = new Practice_lessons_12949();
		System.out.println(p.solution(arr1, arr2));
		
	}
	
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < arr2.length; k++) {
					sum += arr1[i][k] * arr2[k][j];
				}
				answer[i][j] = sum;
			}
		}
		return answer;
	}
	
}


















