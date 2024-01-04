package practice.programmers.level_2;

import java.util.HashMap;
import java.util.Map;

public class Practice_lessons_42578 {
	public static void main(String[] args) {
		// Test Case
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		// Answer
		Practice_lessons_42578 p = new Practice_lessons_42578();
		System.out.println(p.solution(clothes));
		
	}
	
	/*
	 * 조건부 확률 : 카테고리 a가 발생할 확률 * 카테고리 b가 발생할 확률 = 일어날 확률(경우의 수)
	 */
	
	public int solution(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();
		
		for (String[] arr : clothes) {
			map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
		}
		
		int answer = 1;
		
		for (int a : map.values()) {
			answer *= (a + 1);
		}
		
		answer -= 1;
		
		return answer;
	}
	
}


















