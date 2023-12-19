package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Silver_3_9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Map<String, Integer> map = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				String key = br.readLine().split(" ")[1];
				
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
			
			int result = 1;
			
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				result *= (entry.getValue() + 1);
			}
			
			sb.append(result - 1).append("\n");
		}
		System.out.println(sb);
	}
	
//	public static int combi(int n, int r) {
//		if (n == r || r == 0) {
//			return 1;
//		} else {
//			return combi(n - 1, r) + combi(n - 1, r - 1);
//		}
//	}
}
