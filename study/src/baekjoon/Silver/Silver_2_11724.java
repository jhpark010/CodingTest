package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver_2_11724 {
	static int[] arr;
	
	public static int find(int v) {
		if (arr[v] == v) {
			return v;
		} else {
			return arr[v] = find(arr[v]);
		}
	}
	
	public static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		
		if (fa != fb) arr[fa] = fb;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			arr[i] = i;
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a, b);
		}
		
		for (int i = 1; i < n + 1; i++) {
			find(i);
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 1; i < n + 1; i++) {
			set.add(arr[i]);
		}
		
		System.out.println(set.size());
		
	}
}















