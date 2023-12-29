package practice.programmers.level_2;

public class Practice_lessons_12911 {
	public static void main(String[] args) {
		// Test Case
		int n = 78;
		
		// Answer
		Practice_lessons_12911 p = new Practice_lessons_12911();
		System.out.println(p.solution(n));
		
	}
	
	public int solution(int n) {
		int answer = 0;
		String str = Integer.toBinaryString(n++);
		int oneCnt = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') oneCnt++;
		}
		
		int loopOneCnt = 0;
		
		while (oneCnt != loopOneCnt) {
			String tmp = Integer.toBinaryString(n++);
			
			for (int i = 0; i < tmp.length(); i++) {
				if (tmp.charAt(i) == '1') loopOneCnt++;
			}
			
			if (loopOneCnt == oneCnt) {
				answer = n - 1;
				break;
			}
			
			loopOneCnt = 0;
		}
		
		return answer;
	}
	
}


















