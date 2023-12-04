package programmers.level_2;

import java.util.Arrays;
import java.util.Stack;

public class Problem_12981 {
	public static void main(String[] args) {
		// Test Case
		int n = 5;
		String[] words = {"hello", "observe", "effect", "take"
				, "either", "recognize", "encourage", "ensure"
				, "establish", "hang", "gather", "refer"
				, "reference", "estimate", "executive"};
//		String[] words = {"tank", "kick", "know", "wheel", "land",
//				"dream", "mother", "robot", "tank"};
		
		// Answer
		Problem_12981 p = new Problem_12981();
//		System.out.println(p.solution(brown, yellow));
		System.out.println(Arrays.toString(p.solution(n, words)));

	}

	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int cycle = 1;
		int playerCnt = 1;
		Stack<String> stack = new Stack<>();
		stack.push(words[0]);
		
		for (int i = 1; i < words.length; i++) {
			playerCnt++;
			
			if (playerCnt > n) {
				playerCnt = 1;
				cycle ++;
			}
			
			String prev = stack.peek();
			
			if (stack.contains(words[i]) || prev.charAt(prev.length() - 1) != words[i].charAt(0)) {
				answer[0] = cycle;
				answer[1] = playerCnt;
				break;
				
			} else {
				stack.push(words[i]);
			}
		}
		
		
		
		return answer;
	}
}













