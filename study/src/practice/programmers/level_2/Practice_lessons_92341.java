package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice_lessons_92341 {
	public static void main(String[] args) {
		// Test Case
//		int[] fees = {180, 5000, 10, 600};
//		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] fees = {1, 461, 1, 10};
		String[] records = {"00:00 1234 IN"};

		// Answer
		Practice_lessons_92341 main = new Practice_lessons_92341();
		System.out.println(Arrays.toString(main.solution(fees, records)));
		
	}
	
	public int[] solution(int[] fees, String[] records) {
		 Map<Integer, Integer> cars = new HashMap<>();
			int timeMax = 1439;
			
			for (String record : records) {
				String[] arr = record.split(" ");
				int carNo = Integer.parseInt(arr[1]);
	            
				if (arr[2].equals("IN")) {
					cars.put(carNo, cars.getOrDefault(carNo, 0) - getTime(arr[0]));
				} else {
					cars.put(carNo, cars.getOrDefault(carNo, 0) + getTime(arr[0]));
				}
			}
			
			for (Map.Entry<Integer, Integer> entry : cars.entrySet()) {
				if (entry.getValue() <= 0) {
					cars.put(entry.getKey(), entry.getValue() + timeMax);
				}
			}
			
			List<Map.Entry<Integer, Integer>> list = new ArrayList<>(cars.entrySet());
			
			list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
				@Override
				public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
					return a.getKey() - b.getKey();
				}
			});
			
			List<Integer> answer = new ArrayList<>();
			
			for (Map.Entry<Integer, Integer> m : list) {
				if (m.getValue() <= fees[0]) {
					answer.add(fees[1]);
				} else {
					int val = (int) Math.ceil((m.getValue() - fees[0] * 1.0) / fees[2]) * fees[3];
					answer.add(fees[1] + val);
				}
			}
			
			return answer.stream().mapToInt(Integer::intValue).toArray();
	    }
	    
	    public int getTime(String s) {
			String[] arr = s.split(":");
			return (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
		}
	
//	class Info implements Comparable<Info> {
//		int time;
//		int no;
//		char state;
//		
//		Info (int time, int no, char state) {
//			this.time = time;
//			this.no = no;
//			this.state = state;
//		}
//		
//		@Override
//		public int compareTo(Info i) {
//			return this.time - i.time;
//		}
//	}
	
}


















