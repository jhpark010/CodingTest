package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_2_18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] field = new int[n][m];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				field[i][j] = num;
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
		}
		
		int answerTime = Integer.MAX_VALUE;
		int answerHeight = 0;
		
		for (int floor = min; floor <= max; floor++) {
			int block = b;
			int time = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					int diff = field[i][j] - floor;
					
					// 필드 값이 층보다 클 경우 diff만큼 제거
					if (diff > 0) {
						block += Math.abs(diff);
						time += diff * 2;
						
					// 필드 값이 층보다 작을 경우 diff만큼 블럭 추가
					} else if (diff < 0) {
						block -= Math.abs(diff);
						time += Math.abs(diff);
					}
				}
			}
			
			// block을 모두 소모하여 음수일 경우는 최적의 답이 되지 못함
			if (block >= 0) {
				// 최저에서 최고 층으로 이동하기 때문에 (<)이 아닌 (<=)
				if (time <= answerTime) {
					answerTime = time;
					answerHeight = floor;
				}
			}
		}
		
		System.out.println(answerTime + " " + answerHeight);
	}
}
