package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Practice_lessons_64065 {
	public static void main(String[] args) {
		// Test Case
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		// Answer
		Practice_lessons_64065 p = new Practice_lessons_64065();
		System.out.println(Arrays.toString(p.solution(s)));
		
	}
	
	public int[] solution(String s) {
		List<String> list = new ArrayList<>();
		String[] arr = s.split("},");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].replaceAll("\\{", "").replaceAll("\\}", "");
			list.add(arr[i]);
		}
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return a.length() - b.length();
			}
		});
		
		Set<Integer> set = new LinkedHashSet<>();
		
		for (int i = 0; i < list.size(); i++) {
			String tmp = list.get(i);
			
			if (tmp.contains(",")) {
				String[] tmpArr = tmp.split(",");
				
				for (String t : tmpArr) {
					set.add(Integer.parseInt(t));
				}
				
			} else {
				set.add(Integer.parseInt(tmp));
			}
		}
		
		int idx = 0;
		int[] answer = new int[set.size()];
		
		for (int n : set) {
			answer[idx++] = n;
		}
		
		return answer;
	}
	
}


















