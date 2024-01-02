package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_42747 {
	public static void main(String[] args) {
		// Test Case
		int[] citations = {2,0,6,1,5,7};
		// Answer
		Practice_lessons_42747 p = new Practice_lessons_42747();
		System.out.println(p.solution(citations));
		
	}
	
	public int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
        
		int hIndex = citations.length;
        
        for (int i = 0; i < citations.length; i++) {
            if (hIndex <= citations[i]) {
                break;
            }
            
            hIndex--;
        }
        
        return answer;
	}
	
}


















