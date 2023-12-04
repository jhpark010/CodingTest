package programmers.level_2;

public class Problem_12913 {
	public static void main(String[] args) {
		// Test Case
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
//		int[][] land = {{1, 1, 3, 1}, {2, 3, 2, 2}, {1, 4, 1, 1}};

		// Answer
		Problem_12913 main = new Problem_12913();
		System.out.println(main.solution(land));

	}

	public int solution(int[][] land) {
		int answer = 0;
		int[][] maxLand = new int[land.length + 1][4];
		
		//행
		for (int i = 1; i < maxLand.length; i++) {
			//열
			for (int j = 0; j < 4; j++) {
				//합
				for (int k = 0; k < 4; k++) {
					if (j == k) {
						continue;
					}
					
					maxLand[i][j] = Math.max(maxLand[i][j], land[i - 1][j] + maxLand[i - 1][k]);
					answer = Math.max(answer, maxLand[i][j]);
				}
			}
		}

		return answer;
	}
	
}
