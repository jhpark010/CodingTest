package baekjoon.Gold;

import java.io.*;
import java.util.*;

/*
 * BFS
 * 참고 : https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-9019%EB%B2%88-DSLR-Java-%EC%9E%90%EB%B0%94
 * 2023/12/13 위 참고하여 풀었으나 다시 풀어볼 것.
 */

public class Gold_4_9019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//방문용
			boolean[] visited = new boolean[10000];
			//계산 로그들을 담을 배열
			String[] log = new String[10000];
			Queue<Integer> q = new LinkedList<>();
			
			
			q.add(a);
			Arrays.fill(log, "");
			visited[a] = true;
			
			while(!q.isEmpty() && !visited[b]) {
				int tmp = q.poll();
				
				int d = (tmp * 2) % 10000;
				int s = tmp == 0 ? 9999 : tmp - 1;
				int l = tmp % 1000 * 10 + tmp / 1000;
				int r = tmp % 10 * 1000 + tmp / 10;
				
				if (!visited[d]) {
					visited[d] = true;
					log[d] = log[tmp] + "D";
					q.add(d);
				}
				
				if (!visited[s]) {
					visited[s] = true;
					log[s] = log[tmp] + "S";
					q.add(s);
				}
				
				if (!visited[l]) {
					visited[l] = true;
					log[l] = log[tmp] + "L";
					q.add(l);
				}
				
				if (!visited[r]) {
					visited[r] = true;
					log[r] = log[tmp] + "R";
					q.add(r);
				}
			}
			System.out.println(log[b]);
//			sb.append(log[b]).append("\n");
		}
	}
}	

















	
	
	
	
	
	
	



