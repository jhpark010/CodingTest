package programmers.level_1;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_17680 {
	public static void main(String[] args) {
		// Test Case
		int cacheSize = 3;
//		String[] cities = {"1","2","1","1","1","1"};
		String[] cities = {"SEOUL", "SEOUL", "SEOUL"};
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

		// Answer
		Problem_17680 p = new Problem_17680();
		System.out.println(p.solution(cacheSize, cities));

	}

	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Queue<String> q = new LinkedList<>();

		if (cacheSize != 0) {
			for (String city : cities) {
				city = city.toUpperCase();

				if (q.contains(city)) {
					answer += 1;
					q.remove(city);
					q.add(city);

				} else {
					answer += 5;
					if (q.size() < cacheSize) {
						q.add(city);

					} else {
						q.poll();
						q.add(city);
					}
				}
			}

		} else {
			answer += (cities.length * 5);
		}

		return answer;
	}

}
