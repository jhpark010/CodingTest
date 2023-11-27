package programmers.level_1;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Problem_92341 {
	public static void main(String[] args) {
		// Test Case
//		int[] fees = {180, 5000, 10, 600};
//		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] fees = {1, 461, 1, 10};
		String[] records = {"00:00 1234 IN"};
		
		
		// Answer
		Problem_92341 main = new Problem_92341();
		System.out.println(Arrays.toString(main.solution(fees, records)));

	}

	// fees[0] : 기본 시간
	// fees[1] : 기본 요금
	// fees[2] : 단위 시간(분)
	// fees[3] : 단위 요금(원)
	
	public int[] solution(int[] fees, String[] records) {
		Map<String, Info> map = new TreeMap<>();
		int endTime = getTime("23:59");
		
		for (int i = 0; i < records.length; i++) {
			String[] tmp = records[i].split(" ");
			int time = getTime(tmp[0]);
			time = tmp[2].equals("IN") ? -time : +time;
			
			if (map.containsKey(tmp[1])) {
				int cnt = map.get(tmp[1]).cnt + 1;
				map.put(tmp[1], new Info(map.get(tmp[1]).time + time, cnt));
			} else {
				map.put(tmp[1], new Info(time, 1));
			}
		}
		
		int[] answer = new int[map.size()];
		int idx = 0;
		
		for (Map.Entry<String, Info> entry : map.entrySet()) {
			if (entry.getValue().cnt % 2 != 0) {
				entry.getValue().time += endTime;
			}
			
			if (entry.getValue().time <= fees[0]) {
				answer[idx++] = fees[1];
			} else {
				int resultTime = entry.getValue().time - fees[0];
				
				if (resultTime % fees[2] != 0) {
					double num = (double)(resultTime) / fees[2];
					resultTime = (int) (Math.ceil((num / 10) * 10));
					
				} else {
					resultTime = resultTime / fees[2];
				}
				
				answer[idx++] = fees[1] + (resultTime * fees[3]);
			}
		}
		
		return answer;
	}
	
	public int getTime(String s) {
		String[] arr = s.split(":");
		
		return (Integer.parseInt(arr[0]) * 60 ) + Integer.parseInt(arr[1]);  
	}
	
	
	class Info {
		int time;
		int cnt;
		
		Info(int time, int cnt) {
			this.time = time;
			this.cnt = cnt;
		}
	}
}









