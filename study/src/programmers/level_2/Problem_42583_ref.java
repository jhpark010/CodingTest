package programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_42583_ref {
	public static void main(String[] args) {
		// Test Case
//		int bridge_length = 2;
		int bridge_length = 100;
//		int weight = 10;
		int weight = 100;
//		int[] truck_weights = {7, 4, 5, 6};
//		int[] truck_weights = {10};
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		// Answer
		Problem_42583_ref p = new Problem_42583_ref();
		System.out.println(p.solution(bridge_length, weight, truck_weights));
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		//대기 트럭 큐
		Queue<Truck> waitQueue = new LinkedList<>();
		
		// 현재 다리 위에 이동 중인 트럭 큐
		Queue<Truck> moveQueue = new LinkedList<>();
		
		// 매개 변수인 트럭 정보(무게)를 대기 트럭 큐에 추가
		for (int truckWeight : truck_weights) {
			waitQueue.add(new Truck(truckWeight));
		}
		
		// 현재 다리 위의 트럭 무게
		int curBridgeWeight = 0;
		
		// 대기 트럭 큐(waitQueue)와 이동 중인 트럭 큐(moveQueue)가 비어있지 않을 때 까지 반복
		while (!waitQueue.isEmpty() || !moveQueue.isEmpty()) {
			// 반복할 때 마다 시간 + 1
			answer ++;
			
			// 이동 중인 트럭 큐가 비어있을 경우 대기 트럭 큐에서 객체 poll하여 이동 큐에 추가
			if (moveQueue.isEmpty()) {
				Truck t = waitQueue.poll();
				curBridgeWeight += t.weight;
				moveQueue.add(t);
				
				// 이동 큐가 비어있어서 1개의 트럭을 이동 시키는 하나의 액션이 끝났으므로 아래의 로직 동작 X
				continue;
			}
			
			// 이동 중인 트럭 큐가 비어있지 않을 경우 매 반복할 때 마다 한 칸씩 이동해야하므로
			// 현재 이동 중인 큐 내에 있는 객체들의 move 정보를 +1
			for (Truck t : moveQueue) {
				t.moving();
			}
			
			// 이동 큐의 객체들의 이동 값을 + 1한 후 가장 맨 앞의 객체가 
			// 다리 길이를 넘어갈 경우 이동 큐에서 제거
			if (moveQueue.peek().move > bridge_length) {
				curBridgeWeight -= moveQueue.peek().weight;
				moveQueue.poll();
			}
			
			// 대기 큐에서 가장 앞에 있는 객체가 현재 다리 위에 올려도 되는지를 판단
			// #1-1. 큐가 비어져 있지 않아야 하고(NullPointException 발생)
			// #1-2. 현재 다리 위의 무게, 대기 큐 맨 앞 객체 무게의 합이 다리의 최대 무게(weight)를 초과하지 않는지
			// #2. 1번의 조건을 만족할 경우 이동 큐에 추가
			if (!waitQueue.isEmpty() && curBridgeWeight + waitQueue.peek().weight <= weight) {
				Truck t = waitQueue.poll();
				curBridgeWeight += t.weight;
				moveQueue.add(t);
			}
		}
		
		return answer;
	}
	
	
	class Truck {
		int weight;
		int move;
		
		Truck(int weight) {
			this.weight = weight;
			this.move = 1;
		}
		
		
		public void moving() {
			this.move ++;
		}
	}
}
