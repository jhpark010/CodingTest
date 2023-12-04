package programmers.level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_155651 {
	
	public static void main(String[] args) {
		// Test Case
//		String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
		String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
		
		// Answer
		Problem_155651 main = new Problem_155651();
		System.out.println(main.solution(book_time));

	}
	
	public int solution(String[][] book_time) {
		int answer = 0;
		List<Book> list = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < book_time.length; i++) {
			list.add(new Book(getTime(book_time[i][0]), getTime(book_time[i][1]) + 10));
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			if (pq.isEmpty()) {
				answer ++;
				pq.add(list.get(i).endTime);
			} else {
				int endTime = pq.poll();
				
				if (endTime <= list.get(i).startTime) {
					pq.add(list.get(i).endTime);
					
				} else {
					answer ++;
					pq.add(list.get(i).endTime);
					pq.add(endTime);
				}
			}
		}
		
		return answer;
	}
	
	public int getTime(String time) {
		String[] arr = time.split(":");
		
		return (Integer.parseInt(arr[0]) * 60) + Integer.parseInt(arr[1]);
	}
	
	class Book implements Comparable<Book>{
		int startTime;
		int endTime;
		
		Book(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
		
		@Override
		public int compareTo(Book b) {
			if (this.startTime == b.startTime) {
				return this.endTime - b.endTime;
			} else {
				return this.startTime - b.startTime;
			}
		}
	}
}























