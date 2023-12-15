package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver_4_1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		
		while(N-- > 0) {
			set.add(br.readLine());
		}
		
		List<String> answerList = new ArrayList<>();
		
		while(M-- > 0) {
			String str = br.readLine();
			
			if (set.contains(str)) {
				answerList.add(str);
			}
		}
		
		Collections.sort(answerList);
		int cnt = answerList.size();
		StringBuilder sb = new StringBuilder();
		
		for (String s : answerList) {
			sb.append(s).append("\n");
		}
		
		System.out.println(cnt);
		System.out.println(sb);
		
	}
}















