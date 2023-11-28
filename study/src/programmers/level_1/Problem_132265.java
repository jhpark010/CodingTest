package programmers.level_1;

import java.util.HashMap;
import java.util.HashSet;

public class Problem_132265 {
	public static void main(String[] args) {
		// Test Case
//		int[] topping = {1, 2, 3, 1, 4};
		int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
		// Answer
		Problem_132265 main = new Problem_132265();
		System.out.println(main.solution(topping));

	}

	/*
	 * 문제에서 형과 동생이 중복되지 않은 가지 수를 알기 위해
	 * 초기 숫자들을 key값으로 가지며 각 숫자들의 개수를 알기 위해 HashMap(first)를 사용하여
	 * 매개변수의 모든 원소들과 각 원소들의 개수를 first에 담는다.
	 * 매개변수를 넘겨받은 topping 배열의 맨 앞에서부터 하나씩 second(HashSet)으로 옮겨서
	 * 옮긴 후의 first와 second의 크기 값이 같으면 동일한 가지 수이므로 answer ++
	 * 
	 */
	
	public int solution(int[] topping) {
		int answer = 0;
		HashMap<Integer, Integer> first = new HashMap<>();
		HashSet<Integer> second = new HashSet<>();
		
		for (int i : topping) {
			first.put(i, first.getOrDefault(i, 0) + 1);
		}
		
		for (int j : topping) {
			first.put(j, first.get(j) - 1);
			second.add(j);
			
			if (first.get(j) == 0) {
				first.remove(j);
			}
			
			if (first.size() == second.size()) {
				answer ++;
			}
		}
		
		return answer;
	}
	
}
