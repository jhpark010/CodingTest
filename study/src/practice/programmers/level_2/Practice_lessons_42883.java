package practice.programmers.level_2;

import java.util.Stack;

public class Practice_lessons_42883 {
	public static void main(String[] args) {
		// Test Case
		String number = "3333221111";
		int k = 4;
		
		// Answer
		Practice_lessons_42883 main = new Practice_lessons_42883();
		System.out.println(main.solution(number, k));
		
	}
	
	public String solution(String number, int k) {
		Stack<Integer> s = new Stack<>();
        char[] ans = new char[number.length() - k];
        
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            
            while(!s.isEmpty() && s.peek() < num && k > 0) {
            	k--;
            	s.pop();
            }
            s.push(num);
        }
        
        for (int i = 0; i < ans.length; i++) {
        	ans[i] = (char) (s.get(i) + '0');
        }
        
		return String.valueOf(ans);
    }
}


















