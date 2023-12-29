package practice.programmers.level_2;

public class Practice_lessons_12951 {
	public static void main(String[] args) {
		// Test Case
		String s = "a  b";
		
		// Answer
		Practice_lessons_12951 p = new Practice_lessons_12951();
		System.out.println(p.solution(s));
		
	}
	
	public String solution(String s) {
		s = s.toLowerCase();
		char[] arr = s.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (!Character.isDigit(arr[i])) {
					arr[i] = (char) (arr[i] - 32);
				}
			} else if (arr[i - 1] == ' ' && arr[i] != ' ' && !Character.isDigit(arr[i])){
				arr[i] = (char) (arr[i] - 32);
			}
		}
		
		return String.valueOf(arr);
	}
	
}


















