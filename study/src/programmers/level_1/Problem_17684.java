package programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_17684 {
	public static void main(String[] args) {
		// Test Case
//		String msg = "KAKAO";
//		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		String msg = "ABABABABABABABAB";
		
		// Answer
		Problem_17684 p = new Problem_17684();
		System.out.println(Arrays.toString(p.solution(msg)));

	}

	public int[] solution(String msg) {
		List<Integer> answer = new ArrayList<>();
		Map<String, Integer> alpha = new HashMap<>();
		
		for (int i = 1; i <= 26; i++) {
			alpha.put(String.valueOf((char) (i + 64)), i);
		}
		
		String[] arr = msg.split("");
		
		for (int i = 0; i < arr.length - 1; i++) {
			String cur = arr[i];
			String next = arr[i + 1];
			
			if (!alpha.containsKey(cur + next)) {
				answer.add(alpha.get(cur));
				alpha.put(cur + next, alpha.size() + 1);
			} else {
				arr[i + 1] = cur + next;
			}
		}
		
		if (alpha.containsKey(arr[arr.length - 1])) {
			answer.add(alpha.get(arr[arr.length - 1]));
		}
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
}









