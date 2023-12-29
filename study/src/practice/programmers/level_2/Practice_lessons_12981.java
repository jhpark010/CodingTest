package practice.programmers.level_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice_lessons_12981 {
	public static void main(String[] args) {
		// Test Case
//		int n = 5;
		int n = 3;
//		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		
		// Answer
		Practice_lessons_12981 p = new Practice_lessons_12981();
		System.out.println(Arrays.toString(p.solution(n, words)));
		
	}
	
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		Set<String> set = new HashSet<>();
		String prevStr = words[0];
		set.add(prevStr);
		
		for (int i = 1; i < words.length; i++) {
			if (prevStr.charAt(prevStr.length() - 1) == words[i].charAt(0)
					&& !set.contains(words[i])) {
				prevStr = words[i];
				set.add(words[i]);
			} else {
				return new int[] {(i % n) + 1, (i / n) + 1};
			}
		}
		
		return answer;
	}
	
}


















