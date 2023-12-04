package programmers.level_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_118667 {
	
	public static void main(String[] args) {
		// Test Case
		int[] queue1 = {8, 8};
		int[] queue2 = {2, 8};
		
		// Answer
		Problem_118667 main = new Problem_118667();
		System.out.println(main.solution(queue1, queue2));

	}
	
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long qOneSum = Arrays.stream(queue1).sum();
		long qTwoSum = Arrays.stream(queue2).sum();
		Queue<Long> qOne = new LinkedList<>();
		Queue<Long> qTwo = new LinkedList<>();
		
		for (int n : queue1) {
			qOne.add((long) n);
		}
		
		for (int n : queue2) {
			qTwo.add((long)n);
		}
		
		boolean flag = false;
		
		// 최대 반복 횟수 설정
		int max = qOne.size() * 4;
		int cnt = 0;
		
		while (!qOne.isEmpty() && !qTwo.isEmpty() && max > cnt) {
			cnt++;
			
			if (qOneSum > qTwoSum) {
				long out = qOne.poll();
				qTwo.add(out);
				qOneSum -= out;
				qTwoSum += out;
				
				answer++;
				
			} else if (qOneSum < qTwoSum) {
				long out = qTwo.poll();
				qOne.add(out);
				qTwoSum -= out;
				qOneSum += out;
				
				answer++;
				
			} else if (qOneSum == qTwoSum){
				flag = true;
				break;
			}
		}
		
		if (!flag) {
			answer = -1;
		}
		
		return answer;
	}
}



















