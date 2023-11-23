package programmers.level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Problem_17677 {
	public static void main(String[] args) {
		// Test Case
//		String str1 = "E=M*C^2";
//		String str2 = "e=m*c^2";
//		String str1 = "FRANCE";
//		String str2 = "french";
		String str1 = "handshake";
		String str2 = "shake hands";

		// Answer
		Problem_17677 p = new Problem_17677();
		System.out.println(p.solution(str1, str2));

	}

	public int solution(String str1, String str2) {
		int answer = 0;
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();
		
		List<String> str1List = new ArrayList<>();
		List<String> str2List = new ArrayList<>();
		
		for (int i = 1; i < str1.length(); i++) {
			StringBuilder sb = new StringBuilder();
			
			if (str1.charAt(i - 1) >= 65 && str1.charAt(i - 1) <= 90
					&& str1.charAt(i) >= 65 && str1.charAt(i) <= 90) {
				sb.append(str1.charAt(i - 1));
				sb.append(str1.charAt(i));
				
				str1List.add(sb.toString());
			}
		}
		
		for (int i = 1; i < str2.length(); i++) {
			StringBuilder sb = new StringBuilder();
			
			if (str2.charAt(i - 1) >= 65 && str2.charAt(i - 1) <= 90
					&& str2.charAt(i) >= 65 && str2.charAt(i) <= 90) {
				sb.append(str2.charAt(i - 1));
				sb.append(str2.charAt(i));
				
				str2List.add(sb.toString());
			}
		}
		
		if (str1List.size() == 0 && str2List.size() == 0) {
			return 1 * 65536;
			
		} else {
			answer = solve(str1List, str2List);
		}
		
		return answer;
	}
	
	public int solve(List<String> aList, List<String> bList) {
		List<String> cross = new ArrayList<>();
		List<String> sumList = new ArrayList<>();
		
		int len = aList.size();
		//교집합 구하기
		for (int i = 0; i < len; i++) {
			if (bList.contains(aList.get(i))) {
				cross.add(aList.get(i));
				
				// 서로 중복된 원소 삭제(합집합을 위해)
				bList.remove(aList.get(i));
				
			} else {
				sumList.add(aList.get(i));
			}
		}
		
		//합집합 구하기 
		sumList.addAll(cross);
		sumList.addAll(bList);
		
		double d = ((double)cross.size() / (double)sumList.size()) * 65536;
		
		return (int) Math.floor(d);
	}
}









