package logis;

import java.util.ArrayList;
import java.util.List;

public class Problem_1 {
	/*
	 * n크기의 배열에서 3개만 선택하여 합을 구하고 그 합들 중에 소수의 개수 출력
	 */
	public static void main(String[] args) {
		Problem_1 main = new Problem_1();
		int[] nums = {1,2,7,6,4};
		
		main.solution(nums);
	}
	
	public int solution(int[] nums) {
    	int answer = 0;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    ans.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        
        for (int n : ans) {
        	if (isPrime(n)) answer++;
        }

        return answer;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
