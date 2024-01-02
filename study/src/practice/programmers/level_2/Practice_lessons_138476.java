package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice_lessons_138476 {
	public static void main(String[] args) {
		// Test Case
		int k = 4;
		int[] tangerine = {1,3,2,5,4,5,2,3};
		
		// Answer
		Practice_lessons_138476 p = new Practice_lessons_138476();
		System.out.println(p.solution(k, tangerine));
		
	}
	
	public int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < tangerine.length; i++) {
			map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
		}
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
			@Override
			public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
				return m2.getValue() - m1.getValue();
			}
		});
		
		int answer = 0;
		
		for (int i = 0; i < list.size(); i++) {
			k -= list.get(i).getValue();
			answer++;
			
			if (k <= 0) {
				break;
			}
		}
		return answer;
	}
	
}


















