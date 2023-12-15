package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Silver_1_1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int[][] infos = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			infos[i][0] = Integer.parseInt(st.nextToken());
			infos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(infos, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[1] == b[1]) {
					return a[0] - b[0];
				} else {
					return a[1] - b[1];
				}
			}
		});
		
		int answer = 0;
		int endTime = 0;
		
		for (int i = 0; i < N; i++) {
			if (infos[i][0] >= endTime) {
				endTime = infos[i][1];
				answer++;
			}
		}
		System.out.println(answer);
	}
}















