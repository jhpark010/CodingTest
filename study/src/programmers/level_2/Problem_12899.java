package programmers.level_2;

import java.util.Arrays;

public class Problem_12899 {
	
	public static void main(String[] args) {
		// Test Case
		int n = 20;
		
		// Answer
		Problem_12899 main = new Problem_12899();
		System.out.println(main.solution(n));

	}
	
	public String solution(int n) {
        String[] nums = {"4", "1", "2"};
        //StringBuilder sb = new StringBuilder();
        String answer = "";
        
        while(n > 0) {
            answer = nums[n % 3] + answer;
            n = (n - 1) / 3;
        }
        
        return answer;
    }
}

























