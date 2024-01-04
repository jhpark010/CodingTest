package practice.programmers.level_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Practice_lessons_42577 {
	public static void main(String[] args) {
		// Test Case
		String[] phone_book = {"11111111111", "19", "97674223", "976"};
		// Answer
		Practice_lessons_42577 p = new Practice_lessons_42577();
		System.out.println(p.solution(phone_book));
		
	}
	
	public boolean solution(String[] phone_book) {
//		Arrays.sort(phone_book, (s1, s2) -> {
//			return s1.length() - s2.length();
//		});
//		
//		for (int i = 1; i < phone_book.length; i++) {
//			if (phone_book[i].contains(phone_book[0])) {
//				return false;
//			}
//		}
		
		Map<String, Integer> map = new HashMap<>();
		
		for (String p : phone_book) {
			map.put(p, 0);
		}
		
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book[i].length(); j++) {
				System.out.println(phone_book[i].substring(0, j));
				if (map.containsKey(phone_book[i].substring(0, j))) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}


















