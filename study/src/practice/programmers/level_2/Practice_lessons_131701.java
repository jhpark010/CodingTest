package practice.programmers.level_2;

import java.util.HashSet;
import java.util.Set;

public class Practice_lessons_131701 {
	public static void main(String[] args) {
		// Test Case
		int[] elements = {7,9,1,1,4};
		
		// Answer
		Practice_lessons_131701 p = new Practice_lessons_131701();
		System.out.println(p.solution(elements));
		
	}
	
	public int solution(int[] elements) {
		int[] newArr = new int[elements.length * 2];
		
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = elements[i % elements.length];
		}
		
		Set<Integer> set = new HashSet<>();
		
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


















