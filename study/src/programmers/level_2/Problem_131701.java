package programmers.level_2;

import java.util.Arrays;
import java.util.HashSet;

public class Problem_131701 {
	public static void main(String[] args) {
		// Test Case
		int[] elements = {7, 9, 1, 1, 4};
		
		// Answer
		Problem_131701 p = new Problem_131701();
		System.out.println(p.solution(elements));

	}

	
	public int solution(int[] elements) {
		int[] newArr = new int[elements.length * 2];
		
		for (int i = 0; i < newArr.length; i++) {
			int idx = i >= elements.length ? i - elements.length : i; 
			newArr[i] = elements[idx];
		}
		
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 1; i <= elements.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				int sum = 0;
				for (int k = j; k < j + i; k++) {
					sum += newArr[k];
				}
				set.add(sum);
			}
		}
		
		return set.size();
	}
	
}













