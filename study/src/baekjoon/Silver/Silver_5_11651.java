package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Silver_5_11651 {
	public static void main(String[] args) throws IOException {
//		new Silver_5_11651().solution();
		
		/*
		 * 아래 코드는 다른 방법
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] xy = new int[n][2];
		StringTokenizer st = null;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(xy, (a1, a2) -> {
			if (a1[1] == a2[1]) {
				return a1[0] - a2[0];
			} else {
				return a1[1] - a2[1];
			}
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			sb.append(xy[i][0]).append(" ").append(xy[i][1]).append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Coor> list = new ArrayList<>();
		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.add(new Coor(x, y));
		}
		Collections.sort(list);
		
		for (Coor c : list) {
			System.out.println(c.toString());
		}
	}
	
	class Coor implements Comparable<Coor>{
		int x;
		int y;
		
		Coor (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Coor c) {
			if (this.y == c.y) {
				return this.x - c.x;
			} else {
				return this.y - c.y;
			}
		}
		
		@Override
		public String toString() {
			return this.x + " " + this.y;
		}
	}
	
}
