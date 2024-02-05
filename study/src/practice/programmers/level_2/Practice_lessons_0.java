package practice.programmers.level_2;

import java.util.HashMap;
import java.util.Map;

public class Practice_lessons_0 {
	public static void main(String[] args) {
		// Test Case
		int[][] arr = {{1, 4},{3,4},{3,10}};
		// Answer
		Practice_lessons_0 main = new Practice_lessons_0();
		System.out.println(main.solution(arr));
		
	}
	
	public int solution(int[][] v) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int[] arr : v) {
			map.put(arr[0], map.getOrDefault(arr[0], 0) + 1);
			map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
		}
		
		int n = 13;
		
		String str = String.valueOf(n);
		
		
		
		
		return 0;
	}
	
}


















