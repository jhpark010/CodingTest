package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.List;

public class Practice_lessons_17677 {
	public static void main(String[] args) {
		// Test Case
		String str1 = "&&&^";
		String str2 = "@#!";
//		String str1 = "";
//		String str2 = "";
		
		// Answer
		Practice_lessons_17677 p = new Practice_lessons_17677();
		System.out.println(p.solution(str1, str2));
		
	}
	
	public int solution(String str1, String str2) {
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		List<String> str1List = new ArrayList<>();
		List<String> str2List = new ArrayList<>();
		
		for (int i = 1; i < str1.length(); i++) {
			StringBuilder sb = new StringBuilder();
			
			if (str1.charAt(i - 1) >= 65 && str1.charAt(i - 1) <= 90
					&& str1.charAt(i) >= 65 && str1.charAt(i) <= 90) {
				
				sb.append(str1.charAt(i - 1)).append(str1.charAt(i));
				str1List.add(sb.toString());
			}
		}
		
		for (int i = 1; i < str2.length(); i++) {
			StringBuilder sb = new StringBuilder();
			
			if (str2.charAt(i - 1) >= 65 && str2.charAt(i - 1) <= 90
					&& str2.charAt(i) >= 65 && str2.charAt(i) <= 90) {
				
				sb.append(str2.charAt(i - 1)).append(str2.charAt(i));
				str2List.add(sb.toString());
			}
		}

		if (str1List.size() == 0 && str2List.size() == 0) return 65536;
		
		List<String> sumList = new ArrayList<>();
		List<String> cross = new ArrayList<>();
		
		for (int i = 0; i < str1List.size(); i++) {
			if (str2List.contains(str1List.get(i))) {
				cross.add(str1List.get(i));
				str2List.remove(str1List.get(i));
			} else {
				sumList.add(str1List.get(i));
			}
		}
		
		sumList.addAll(str2List);
		sumList.addAll(cross);
		
		double d = ((double)cross.size() / (double)sumList.size()) * 65536;
		
		return (int) Math.floor(d);
		
	}
}


















