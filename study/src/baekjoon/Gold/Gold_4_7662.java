package baekjoon.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Gold_4_7662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if (st.nextToken().equals("I")) {
					int num = Integer.parseInt(st.nextToken());
					
					map.put(num, map.getOrDefault(num, 0) + 1);
					
				} else {
					//D일 경우
					int num = Integer.parseInt(st.nextToken());
					
					if (map.isEmpty()) {
						continue;
					} else {
						int value;
						if (num == 1) {
							value = map.lastKey();
							
						} else {
							value = map.firstKey();
						}
						
						if (map.put(value, map.get(value) - 1) == 1) {
							map.remove(value);
						}
					}
				}
			}
			
			if (map.isEmpty()) {
				sb.append("EMPTY").append("\n");
			} else {
				int first = map.firstKey();
				int last = map.lastKey();
				
				sb.append(last).append(" ").append(first).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}

















	
	
	
	
	
	
	



