package programmers.level_2;

import java.util.Stack;

public class Problem_17683 {
	
	public static void main(String[] args) {
		// Test Case
//		String m = "CC#BCC#BCC#BCC#B";
//		String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		String m = "ABC";
		String[] musicinfos = {"12:00,12:05,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//		String m = "ABCDEFG";
//		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		// Answer
		Problem_17683 main = new Problem_17683();
		System.out.println(main.solution(m, musicinfos));

	}
	
	public String solution(String m, String[] musicinfos) {
		int max = Integer.MIN_VALUE;
		String answer = "";
		
		for (String s : musicinfos) {
			String[] arr = s.split(",");
			int time = getTime(arr[0], arr[1]);
			String newMelody = changeMelody(arr[3]);
			int mLen = newMelody.length();
			
			if (mLen < time) {
				StringBuilder mel = new StringBuilder();
				
				for (int i = 0; i < (time / mLen); i++) {
					mel.append(newMelody);
				}
				
				int remainder = time % mLen;
				mel.append(newMelody.substring(0, remainder));
				
				newMelody = mel.toString();
				
			} else {
				newMelody = newMelody.substring(0, time);
			}
			
			m = changeMelody(m);
			
			if (newMelody.contains(m) && time > max) {
				answer = arr[2];
                max = time;
			}
		}
		
		if (max == Integer.MIN_VALUE) {
			answer = "(None)";
		}
		
		return answer;
	}
	
	public int getTime(String timeA, String timeB) {
		String[] aArr = timeA.split(":");
		int a = (Integer.parseInt(aArr[0]) * 60) + Integer.parseInt(aArr[1]);
		
		String[] bArr = timeB.split(":");
		int b = (Integer.parseInt(bArr[0]) * 60) + Integer.parseInt(bArr[1]);
		
		return b - a;
	}
	
	public String changeMelody(String melody) {
		melody = melody.replaceAll("C#", "H");
		melody = melody.replaceAll("D#", "I");
		melody = melody.replaceAll("F#", "J");
		melody = melody.replaceAll("G#", "K");
		melody = melody.replaceAll("A#", "M");
		
		return melody;
	}
}























