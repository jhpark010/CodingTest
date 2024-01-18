package practice.programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Practice_lessons_42583 {
	public static void main(String[] args) {
		// Test Case
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		
		// Answer
		Practice_lessons_42583 main = new Practice_lessons_42583();
		System.out.println(main.solution(bridge_length, weight, truck_weights));
		
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Truck> waiting = new LinkedList<>();
		Queue<Truck> onBridge = new LinkedList<>();
		
		for (int t : truck_weights) {
			waiting.add(new Truck(t));
		}
		
		int curBridgeWeight = 0;
		
		while(!onBridge.isEmpty() || !waiting.isEmpty()) {
			answer++;
			
			if (onBridge.isEmpty()) {
				Truck t = waiting.poll();
				curBridgeWeight += t.weight;
				onBridge.add(t);
				continue;
			}
			
			for (Truck t : onBridge) {
				t.moving();
			}
			
			if (onBridge.peek().move > bridge_length) {
				curBridgeWeight -= onBridge.poll().weight; 
			}
			
			
			if (!waiting.isEmpty() && curBridgeWeight + waiting.peek().weight <= weight && onBridge.size() < bridge_length) {
				Truck t = waiting.poll();
				curBridgeWeight += t.weight;
				onBridge.add(t);
			}
		}
		
		return answer;
	}
	
	class Truck {
		int move;
		int weight;
		
		Truck (int weight) {
			this.weight = weight;
			this.move = 1;
		}
		
		public void moving() {
			this.move++;
		}
	}
	
	
}


















