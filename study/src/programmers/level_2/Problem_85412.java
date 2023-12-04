package programmers.level_2;

import java.util.ArrayList;
import java.util.List;

public class Problem_85412 {
	public static void main(String[] args) {
		// Test Case
		String word = "AAAAE";
		
		// Answer
		Problem_85412 main = new Problem_85412();
		System.out.println(main.solution(word));

	}

	String[] alpha = new String[] {"A", "E", "I", "O", "U"};
	List<String> list = new ArrayList<>();
	
	public int solution(String word) {
		int answer = 0;
		dfs(0, "");
		answer = list.indexOf(word) + 1;
		
		return answer;
	}
	
	public void dfs(int level, String word) {
		if (word.length() != 0) {
			list.add(word);
		}
		
		if (level == alpha.length) {
			return;
		} else {
			for (int i = 0; i < alpha.length; i++) {
				dfs(level + 1, word + alpha[i]);
			}
		}
	}
}









