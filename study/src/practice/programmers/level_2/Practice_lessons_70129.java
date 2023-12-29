package practice.programmers.level_2;

import java.util.Arrays;

public class Practice_lessons_70129 {
	public static void main(String[] args) {
		// Test Case
		String s = "1111111";
		
		// Answer
		Practice_lessons_70129 p = new Practice_lessons_70129();
		System.out.println(Arrays.toString(p.solution(s)));
		
	}
	
	public int[] solution(String s) {
		dfs(s, 0);
		return new int[] {depth, zeroCnt};
	}
	
	int zeroCnt = 0;
	int depth = 0;
	
	public void dfs(String n, int depth) {
		if (n.equals("1")) {
			this.depth = depth;
			return;
			
		} else {
			for (int i = 0; i < n.length(); i++) {
				if (n.charAt(i) == '0') {
					zeroCnt ++;
				}
			}
			
			String s = n.replaceAll("0", "");
			dfs(Integer.toString(s.length(), 2), depth + 1);
		}
	}
	
}


















