package programmers.level_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_138476 {
	public static void main(String[] args) {
		// Test Case
//		int k = 4;
		int k = 3;
//		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
		int[] tangerine = {1, 1, 1, 1, 2, 2, 3};
//		int[] tangerine = {1000, 2000, 2000, 1000};
		
		
		// Answer
		Problem_138476 p = new Problem_138476();
		System.out.println(p.solution(k, tangerine));

	}

	public int solution(int k, int[] tangerine) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < tangerine.length; i++) {
			map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
		}
		
		List<Integer> cntList = new ArrayList<>();
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			cntList.add(entry.getValue());
		}
		
		Collections.sort(cntList, Collections.reverseOrder());
		
		int sum = 0;
		
		for (int cnt : cntList) {
			answer ++;
			sum += cnt;
			if (sum >= k) {
				break;
			}
		}
		
		
		/*
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < tangerine.length; i++) {
			map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
		}
		
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
			
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		
		int sum = 0;
		for (Map.Entry<Integer, Integer> entry : entryList) {
			answer ++;
			sum += entry.getValue();
			if (sum >= k) {
				break;
			}
		}
		*/
		
		return answer;
	}
}













