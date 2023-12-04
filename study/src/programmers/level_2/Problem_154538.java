package programmers.level_2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_154538 {
	public static void main(String[] args) {
		// Test Case
		int x = 10;
		int y = 40;
		int n = 5;
		
		
		// Answer
		Problem_154538 main = new Problem_154538();
//		System.out.println(main.solution(x, y, n));
		System.out.println(main.solution2(x, y, n));

	}

	public int solution(int x, int y, int n) {
		int answer = bfs(x, y, n);
		
		return answer;
	}
	
	public int bfs(int x, int y, int n) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int len = q.size();
			
			for (int i = 0; i < len; i++) {
				if (q.peek() == y) {
					return cnt;
				}
				helper(q.poll(), y, n, set, q);
			}
			cnt++;
		}
		
		return -1;
	}
	
	public void helper(int num, int y, int n, HashSet<Integer> set, Queue<Integer> q) {
		if (num + n <= y && !set.contains(num + n)) {
			set.add(num + n);
			q.add(num + n);
			
		}
		
		if (num * 2 <= y && !set.contains(num * 2)) {
			set.add(num * 2);
			q.add(num * 2);
			
		}
		
		if (num * 3 <= y && !set.contains(num * 3)) {
			set.add(num * 3);
			q.add(num * 3);
		}
	}
	
	/**
	 * 가지치기로 인해 시간 감소 소스코드(하단)
	 */
	
	public int solution2(int x, int y, int n) {
		int answer = -1;
		Queue<Number> q = new LinkedList<>();
		q.add(new Number(y, 0));
		
		while (!q.isEmpty()) {
			Number tmp = q.poll();
			int tmpValue = tmp.getValue();
			int tmpCnt = tmp.getCnt();
			
			if (tmpValue == x) {
				return tmpCnt;
			}
			
			if (tmpValue % 3 == 0) {
				q.add(new Number(tmpValue / 3, tmpCnt + 1));
			}
			
			if (tmpValue % 2 == 0) {
				q.add(new Number(tmpValue / 2, tmpCnt + 1));
			}
			
			if (tmpValue - n >= x) {
				q.add(new Number(tmpValue - n, tmpCnt + 1));
			}
			
		}
		
		return answer;
	}
	
	class Number {
		int value;
		int cnt;
		
		Number(int value, int cnt) {
			this.value = value;
			this.cnt = cnt;
		}
		
		
		public int getValue() {
			return this.value;
		}
		
		public int getCnt() {
			return this.cnt;
		}
	}
	
	
}













