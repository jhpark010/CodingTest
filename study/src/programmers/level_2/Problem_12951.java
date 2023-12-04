package programmers.level_2;

public class Problem_12951 {
	public static void main(String[] args) {
		// Test Case
//		String s = "3people   unFollowed me";
//		String s = "for the last week";
		String s = "UUUU  UUUU 3UUU";

		// Answer
		Problem_12951 p = new Problem_12951();
		System.out.println(p.solution(s));

	}

	public String solution(String s) {
		String answer = "";

		s = s.toLowerCase();
		char[] cArr = s.toCharArray();

		for (int i = 0; i < cArr.length; i++) {
			if (i == 0) {
				if (!Character.isDigit(cArr[i])) {
					cArr[i] = (char) (cArr[i] - 32);
				}
			} else if (cArr[i - 1] == ' ' && cArr[i] != ' ' && !Character.isDigit(cArr[i])) {
				cArr[i] = (char) (cArr[i] - 32);
			}
		}
		answer = String.valueOf(cArr);

		return answer;
	}

}













