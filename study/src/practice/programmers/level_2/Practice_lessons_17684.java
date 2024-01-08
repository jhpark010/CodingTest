package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice_lessons_17684 {
	public static void main(String[] args) {
		// Test Case
		String msg = "KAKAO";
		// Answer
		Practice_lessons_17684 p = new Practice_lessons_17684();
		System.out.println(Arrays.toString(p.solution(msg)));
		
	}
	
	public int[] solution(String msg) {
		Map<String, Integer> map = new HashMap<>();
		List<Integer> nList = new ArrayList<>();
		String[] arr = msg.split("");
		
		for (int i = 1; i <= 26; i++) {
			map.put(String.valueOf((char) (64 + i)), i);
		}
		
		for (int i = 0; i < arr.length - 1; i++) {
			String cur = arr[i];
			String next = arr[i + 1];
			
			if (!map.containsKey(cur + next)) {
				map.put(cur + next, map.size() + 1);
				nList.add(map.get(cur));
				
			} else {
				arr[i + 1] = cur + next;
			}
		}
		
		if (map.containsKey(arr[arr.length - 1])) {
			nList.add(map.get(arr[arr.length - 1]));
		}
		
		return nList.stream().mapToInt(Integer::intValue).toArray();
	}
	
}


















