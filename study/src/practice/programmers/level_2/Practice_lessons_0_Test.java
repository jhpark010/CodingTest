package practice.programmers.level_2;

import java.util.HashSet;
import java.util.Set;

public class Practice_lessons_0_Test {
	public static void main(String[] args) {
		// Test Case
		int[] n = {1,2,3,4};
		
		// Answer
		Practice_lessons_0_Test main = new Practice_lessons_0_Test();
		System.out.println(main.solution(n));
		
	}
	

    public int solution(int[] nums) {
    	int answer = 0;
    	visited = new boolean[nums.length];
        dfs(0, 3, nums);
        
        for (int n : ansSet) {
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

    Set<Integer> ansSet = new HashSet<>();
    boolean[] visited;
    
    public void dfs(int idx, int r, int[] nums) {
        if (r == 0) {
            int sum = 0;

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                	System.out.print(nums[i] + " ");
                	sum += nums[i];
                }
            }
            System.out.println();
            
            ansSet.add(sum);

            return;
        }
        
        for (int i = idx; i < nums.length; i++) {
            visited[i] = true;
            dfs(i + 1, r - 1, nums);
            visited[i] = false;
        }
    }
}


















