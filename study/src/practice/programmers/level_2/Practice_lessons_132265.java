package practice.programmers.level_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Practice_lessons_132265 {
	public static void main(String[] args) {
		// Test Case
		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
//		int[] topping = {1, 2, 3, 1, 4};
		
		// Answer
		Practice_lessons_132265 main = new Practice_lessons_132265();
		System.out.println(main.solution(topping));
		
	}
	
	public int solution(int[] topping) {
		int answer = 0;
		Map<Integer, Integer> first = new HashMap<>();
		Map<Integer, Integer> second = new HashMap<>();
		
		for (int one : topping) {
			first.put(one, first.getOrDefault(one, 0) + 1);
		}
		
		for (int two : topping) {
			first.put(two, first.get(two) - 1);
			second.put(two, second.getOrDefault(two,  0) + 1);
			
			if (first.get(two) == 0) {
				first.remove(two);
			}
			
			if (first.size() == second.size()) {
				answer++;
			}
		}
		
		return answer;
	}
	
}


















