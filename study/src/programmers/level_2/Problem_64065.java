package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Problem_64065 {
	public static void main(String[] args) {
		// Test Case
		String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		

		// Answer
		Problem_64065 p = new Problem_64065();
		System.out.println(Arrays.toString(p.solution(s)));

	}

	public int[] solution(String s) {
		List<String> list = new ArrayList<>();
		
		String[] arr = s.split("\\},");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i].replaceAll("\\{", "").replaceAll("\\}", "");
			list.add(arr[i]);
		}
		
//		Collections.sort(list, (a1, a2) -> a1.length() - a2.length());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		Set<Integer> set = new LinkedHashSet<>();
		
		for (String str : list) {
			String[] tmp = str.split(",");
			
			for (String value : tmp) {
				set.add(Integer.parseInt(value));
			}
		}
		
		
		List<Integer> answerList = new ArrayList<>();
		
		for (int n : set) {
			answerList.add(n);
		}
		
		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}
	

}
