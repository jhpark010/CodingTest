package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Silver_2_1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Map<String, Integer> nameMap = new HashMap<>();
		Map<Integer, String> idxMap = new HashMap<>();
		
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			nameMap.put(name, i);
			idxMap.put(i, name);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (m-- > 0) {
			String tmp = br.readLine();
			boolean isDigit = false;
			
			for (int i = 0; i < tmp.length(); i++) {
				if (Character.isDigit(tmp.charAt(i))) {
					isDigit = true;
					break;
				}
			}
			
			if (!isDigit) {
				sb.append(nameMap.get(tmp)).append("\n");
			} else {
				sb.append(idxMap.get(Integer.parseInt(tmp))).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}















