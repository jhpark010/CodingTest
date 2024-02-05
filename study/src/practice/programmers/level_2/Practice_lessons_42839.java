package practice.programmers.level_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice_lessons_42839 {
	public static void main(String[] args) {
		// Test Case
//		String num = "011";
		String num = "17";
		
		long l = 1;
		int n = 1;
		l = n;
		Arrays.stream(new int[2]).sum();
		
		
		// Answer
		Practice_lessons_42839 main = new Practice_lessons_42839();
		System.out.println(main.solution(num));
	}
	
	Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
    	int answer = 0;
        char[] cArr = numbers.toCharArray();
        boolean[] visited = new boolean[cArr.length];
        dfs(0, visited, cArr, "");
        
        for (int n : set) {
        	if (isPrime(n)) {
        		answer++;
        	}
        }
        return answer;
    }
    
    public boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
    
    public void dfs(int level, boolean[] visited, char[] cArr, String num) {
        if (level == cArr.length) {
        	return;
        } else {
        	for (int i = 0; i < cArr.length; i++) {
        		if (!visited[i]) {
        			visited[i] = true;
                    set.add(Integer.parseInt(num + cArr[i]));
                    dfs(level + 1, visited, cArr, num + cArr[i]);
        			visited[i] = false;
        		}
        	}
        }
    }
}


















