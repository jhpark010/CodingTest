package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver_1_1074 {
	static int answer = 0;
	static int N, r, c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		solve(0, 0, (int)Math.pow(2, N));
	}
	
	
	public static void solve(int x, int y, int size) {
		// 사이즈가 1x1 일때 까지 반복
		if (size == 1) {
			System.out.println(answer);
			return;
		}
		
		int newSize = size / 2;
		
		// (r, c)가 중앙값인 newSize 보다 작으므로 왼쪽 위
		if (r < x + newSize && c < y + newSize) {
			solve(x, y, newSize);
			
		}
		// (r, c) 중 중앙값인 newSize 보다 r은 작고, c는 같거나 크므로 작으므로 오른쪽 위
		else if (r < x + newSize && c >= y + newSize) {
			answer += (size * size) / 4;
			solve(x, y + newSize, newSize);
			
		}
		// (r, c) 중 중앙값인 newSize는 r과 같거나 크고 c는 보다 작으므로 왼쪽 아래
		else if (r >= x + newSize && c < y + newSize) {
			answer += (size * size) / 4 * 2;
			solve(x + newSize, y, newSize);
			
		}
		// (r, c) 중 중앙값인 newSize는 r과 같거나 크고 c도 같거나 크므로 오른쪽 아래
		else if (r >= x + newSize && c >= y + newSize) {
			answer += ((size * size) / 4) * 3;
			solve(x + newSize, y + newSize, newSize);
		}
		
	}
}















