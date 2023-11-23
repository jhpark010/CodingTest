package programmers.level_1;

import java.util.HashMap;

public class Problem_131127 {
	public static void main(String[] args) {
		// Test Case
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple"
				, "banana", "rice", "apple"
				, "pork", "banana", "pork"
				, "rice", "pot", "banana"
				, "apple", "banana"};

		// Answer
		Problem_131127 p = new Problem_131127();
		System.out.println(p.solution(want, number, discount));

	}

	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		HashMap<String, Integer> buyList = new HashMap<>();
		int totalCnt = 0;
		
		for (int i = 0; i < want.length; i++) {
			buyList.put(want[i], number[i]);
			totalCnt += number[i];
		}
		
		for (int i = 0; i < discount.length; i++) {
			if (i + totalCnt <= discount.length) {
				int cnt = 0;
				
				for (int j = i; j < i + totalCnt; j++) {
					if (buyList.containsKey(discount[j])) {
						cnt ++;
						buyList.put(discount[j], buyList.get(discount[j]) - 1);
						
						if (buyList.get(discount[j]) == 0) {
							buyList.remove(discount[j]);
						}
					}
				}
				
				if (cnt == totalCnt) {
					answer ++;
				}
				
				buyList = new HashMap<>();
				
				for (int k = 0; k < want.length; k++) {
					buyList.put(want[k], number[k]);
				}
				
			} else {
				break;
			}
		}
		
		
		
		return answer;
	}

}
