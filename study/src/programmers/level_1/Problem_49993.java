package programmers.level_1;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_49993 {
	public static void main(String[] args) {
		// Test Case
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		// Answer
		Problem_49993 main = new Problem_49993();
		System.out.println(main.solution(skill, skill_trees));

	}

	public int solution(String skill, String[] skill_trees) {
		/*
		 * 가장 속도가 빠른 풀이
		 */
		int answer = 0;
		
		for (String skillTree : skill_trees) {
			int skillOrder = 0;
			boolean flag = true;
			
			for (char c : skillTree.toCharArray()) {
				if (skill.indexOf(c) == -1) {
					continue;
				} else if (skillOrder == skill.indexOf(c)) {
					skillOrder++;
				} else {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				answer++;
			}
		}
		
		
		return answer;
		
		/*
		 * 처음 풀었던 풀이
		 * 
		int answer = 0;
		char[] skillArr = skill.toCharArray();
		
		for (int i = 0; i < skill_trees.length; i++) {
			Queue<Character> q = new LinkedList<>();
			
			for (char c : skillArr) {
				q.add(c);
			}
			
			boolean flag = false;
			
			for (int j = 0; j < skill_trees[i].length(); j++) {
				if (q.contains(skill_trees[i].charAt(j))) {
					if (q.peek() != skill_trees[i].charAt(j)) {
						flag = true;
						break;
						
					} else {
						q.poll();
					}
				} else {
					continue;
				}
			}
			
			if (!flag) {
				answer++;
			}
		}
		return answer;
		*/
		
	}
	
}
