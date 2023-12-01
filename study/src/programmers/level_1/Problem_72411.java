package programmers.level_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem_72411 {
	
	public static void main(String[] args) {
		// Test Case
//		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2, 3, 4};
		String[] orders = {"XYZ", "XWY", "WXA"};
//		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//		int[] course = {2, 3, 5};
		
		// Answer
		Problem_72411 main = new Problem_72411();
		System.out.println(Arrays.toString(main.solution(orders, course)));

	}
	
	
	HashMap<String, Integer> map;
	int max;
	
	public String[] solution(String[] orders, int[] course) {
		PriorityQueue<String> pq = new PriorityQueue<>();
		
		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			max = Integer.MIN_VALUE;
			
			for (int j = 0; j < orders.length; j++) {
				char[] cTmp = orders[j].toCharArray();
				Arrays.sort(cTmp);
				combi(0, 0, course[i], "", cTmp);
			}
			
			if (max < 2) continue;
			
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				if (max == entry.getValue()) {
					pq.add(entry.getKey());
				}
			}
		}
		
		String[] answer = new String[pq.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = pq.poll();
		}
		
		return answer;
		
		
		/*
		 * 1. course 원소에 따라 조합을 구한다.
		 * ex) course[1] = 2 --> orders 원소마다 2Cn 구하여 hashMap에 저장한 후
		 * 크기가 max인 값을 배열에 넣는다.
		
		List<String> answer = new ArrayList<>();
		
		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();
			
			for (int j = 0; j < orders.length; j++) {
				char[] cTmp = orders[j].toCharArray();
				Arrays.sort(cTmp);
				combi(0, 0, course[i], "", cTmp);
			}
			
			List<Map.Entry<String, Integer>> sortList = new ArrayList<>(map.entrySet());
			
			sortList.sort(new Comparator<Map.Entry<String, Integer>>() {
				@Override
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
					return o2.getValue() - o1.getValue();
				}
			});
			
			if (sortList.isEmpty() || sortList.get(0).getValue() == 1) {
				continue;
			}
			
			int max = sortList.get(0).getValue();
			answer.add(sortList.get(0).getKey());
			
			for (int k = 1; k < sortList.size(); k++) {
				if (max == sortList.get(k).getValue()) {
					answer.add(sortList.get(k).getKey());
					
				} else {
					break;
				}
			}
		}
		Collections.sort(answer);
		
		return answer.toArray(new String[answer.size()]);
		 */
    }
	
	public void combi(int depth ,int r, int limit, String value, char[] order) {
		if (depth == limit) {
			map.put(value, map.getOrDefault(value, 0) + 1);
			max = Math.max(max, map.get(value));
			return;
			
		} else {
			for (int i = r; i < order.length; i++) {
				combi(depth + 1, i + 1, limit, value + order[i], order);
			}
		}
	}
}

























