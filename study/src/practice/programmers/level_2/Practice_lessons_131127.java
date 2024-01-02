package practice.programmers.level_2;

import java.util.HashMap;
import java.util.Map;

public class Practice_lessons_131127 {
	public static void main(String[] args) {
		// Test Case
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3,2,2,2,1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
		
		
		// Answer
		Practice_lessons_131127 p = new Practice_lessons_131127();
		System.out.println(p.solution(want, number, discount));
		
	}
	
	public int solution(String[] want, int[] number, String[] discount) {
		Map<String, Integer> map = new HashMap<>();
		int answer = 0;
		
		for (int i = 0; i < discount.length; i++) {
			for (int j = 0; j < want.length; j++) {
				map.put(want[j], number[j]);
			}
			
			for (int k = i; k < i + 10; k++) {
				if (k == discount.length) break;
				
				if (map.containsKey(discount[k])) {
					map.put(discount[k], map.get(discount[k]) - 1);
					
					if (map.get(discount[k]) == 0) {
						map.remove(discount[k]);
					}
				} else {
					break;
				}
			}
			
			if (map.isEmpty()) answer++;
			
		}
		return answer;
	}
	
}


















