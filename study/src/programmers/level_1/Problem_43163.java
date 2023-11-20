package programmers.level_1;

public class Problem_43163 {
	public static void main(String[] args) {
		// Test Case
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		// Answer
		Problem_43163 p = new Problem_43163();
		System.out.println(p.solution(begin, target, words));
		
	}
	
	String t;
	int answer;
	boolean[] visited;
	
	public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        t = target;
        
        boolean ch = false;
        for (String str : words) {
        	if (target.equals(str)) {
        		ch = true;
        	}
        }
        
        if (!ch) {
        	return answer;
        } else {
        	dfs(begin, target, words, 0);
        }
        
        
		return answer;
	}
	
	public void dfs (String begin, String target, String[] words, int ans) {
		if (begin.equals(target)) {
			answer = ans;
			return;
		}
		
		for (int i = 0; i < words.length; i++) {
			if (visited[i]) {
				continue;
			}
			
			int cnt = 0;
			
			for (int j = 0; j < begin.length(); j++) {
				if (begin.charAt(j) == words[i].charAt(j)) {
					cnt ++;
				}
			}
			
			if (cnt == begin.length() - 1) {
				visited[i] = true;
				dfs(words[i], target, words, ans + 1);
				visited[i] = false;
			}
			
		}
	}
}


















