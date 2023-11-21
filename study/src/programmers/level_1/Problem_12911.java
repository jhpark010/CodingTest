package programmers.level_1;

public class Problem_12911 {
	public static void main(String[] args) {
		// Test Case
		int n = 78;
		
		// Answer
		Problem_12911 p = new Problem_12911();
		System.out.println(p.solution(n));

	}

	public int solution(int n) {
		int answer = 0;
		String nStr = Integer.toBinaryString(n++);
		int cnt = 0;
		
		for (int i = 0; i < nStr.length(); i++) {
			if (nStr.charAt(i) == '1') {
				cnt ++;
			}
		}
		
		int loopCnt = 0;
		
		while (loopCnt != cnt) {
			loopCnt = 0;
			String loopStr = Integer.toBinaryString(n);
			
			for (int i = 0; i < loopStr.length(); i++) {
				if (loopStr.charAt(i) == '1') {
					loopCnt ++;
				}
			}
			
			if (loopCnt == cnt) {
				answer = n;
				break;
				
			} else {
				n++;
			}
		}
		
		return answer;
	}
}













