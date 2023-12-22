package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_12936 {
	public static void main(String[] args) {
		// Test Case
		int n = 3;
		int k = 5;

		// Answer
		Problem_12936 p = new Problem_12936();
		System.out.println(Arrays.toString(p.solution(n, k)));

	}

	public int[] solution(int n, long k) {
		int[] arr = new int[n];
		List<Integer> nList = new ArrayList<>();
		
		long facto = 1;
		for (int i = 1; i <= n; i++) {
			nList.add(i);
			facto *= i;
		}
		
		k--; // 인덱스가 0부터 시작해서
		
		int idx = 0;
		while(idx < n) {
			facto /= n - idx;
			arr[idx++] = nList.remove((int) (k / facto));
			k = k % facto;
		}
		return arr;
	}
	

	
	/*
	 * 실패 - 메모리 초과
	 */
//	public void dfs(int level, int n, int[] arr) {
//		if (level == n) {
//			list.add(Arrays.copyOf(arr, arr.length));
//			return;
//			
//		} else {
//			for (int i = 1; i <= n; i++) {
//				if (!visited[i]) {
//					visited[i] = true;
//					arr[level] = i;
//					dfs(level + 1, n, arr);
//					visited[i] = false;
//				}
//			}
//		}
//	}
}





