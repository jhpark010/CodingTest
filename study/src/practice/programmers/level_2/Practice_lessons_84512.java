package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.List;

public class Practice_lessons_84512 {
	public static void main(String[] args) {
		// Test Case
//		String word = "AAAAE";
		String word = "I";
		
		// Answer
		Practice_lessons_84512 main = new Practice_lessons_84512();
		System.out.println(main.solution(word));
		
	}
	
	public int solution(String word) {
		int answer = 0;
		dfs(0, "");
		answer = list.indexOf(word) + 1;
		return answer;
	}
	
	char[] arr = {'A', 'E', 'I', 'O', 'U'};
	List<String> list = new ArrayList<>();
	
	public void dfs(int level, String word) {
		if (word.length() > 0) {
			list.add(word);
		}
		
		if (level == arr.length) {
			return;
		} else {
			for (int i = 0; i < arr.length; i++) {
				dfs(level + 1, word  + arr[i]);
			}
		}
	}
	
}


















