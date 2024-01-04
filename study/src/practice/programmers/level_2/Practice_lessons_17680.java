package practice.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Practice_lessons_17680 {
	public static void main(String[] args) {
		// Test Case
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
//		int cacheSize = 2;
//		String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
		
//		int cacheSize = 0;
//		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		
		// Answer
		Practice_lessons_17680 p = new Practice_lessons_17680();
		System.out.println(p.solution(cacheSize, cities));
		
	}
	
	public int solution(int cacheSize, String[] cities) {
		Queue<String> q = new LinkedList<>();
		int hit = 0;
		
		if (cacheSize == 0) return 5 * cities.length;
		
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toUpperCase();
			
			if (q.contains(city)) {
				hit += 1;
				q.remove(city);
				q.add(city);

			} else {
				if (q.size() < cacheSize){
					q.add(city);
				} else {
					q.poll();
					q.add(city);
				}
				hit += 5;
			}
		}
		
//		while(!q.isEmpty()) {
//			q.poll();
//			hit += 5;
//		}
		
		return hit;
	}
	
}


















