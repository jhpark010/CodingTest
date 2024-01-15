package practice.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Practice_lessons_49993 {
	public static void main(String[] args) {
		// Test Case
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		// Answer
		Practice_lessons_49993 main = new Practice_lessons_49993();
		System.out.println(main.solution(skill, skill_trees));
		
	}
	
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<>();
        
        for (int i = 0; i < skill_trees.length; i++) {
            char[] arr = skill_trees[i].toCharArray();
            boolean flag = true;
            
            for (char c : skill.toCharArray()) q.add(c);
            
            for (int j = 0; j < arr.length; j++) {
                if (!q.isEmpty() && q.contains(arr[j])) {
                    if (q.peek() != arr[j]) {
                        flag = false;
                        break;
                    } else {
                        q.poll();
                    }
                }
            }
            if (flag) answer++;
            
            q.clear();
        }
        
        return answer;
    }
	
}


















