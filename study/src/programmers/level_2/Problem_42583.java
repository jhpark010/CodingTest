package programmers.level_2;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_42583 {
	public static void main(String[] args) {
		// Test Case
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
//		int bridge_length = 100;
//		int weight = 100;
//		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		
		// Answer
		Problem_42583 p = new Problem_42583();
		System.out.println(p.solution(bridge_length, weight, truck_weights));
	}
	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waitTrucks = new LinkedList<>();
        Queue<Integer> onBridgeQueue = new LinkedList<>();
        Queue<Integer> timeQueue = new LinkedList<>();
        
        for (int truck : truck_weights) {
        	waitTrucks.offer(truck);
        }
        
        int time = 0;
        int totalCnt = 0;
        int curBridgeWeight = 0;
        int curBridgeTruckCnt = 0;
        
        while(totalCnt != truck_weights.length) {
        	time ++;
        	
        	if (timeQueue.peek() != null && timeQueue.peek() == bridge_length) {
        		timeQueue.poll();
        		curBridgeTruckCnt --;
        		curBridgeWeight -= onBridgeQueue.poll();
        		totalCnt ++;
        	}
        	
        	if (waitTrucks.peek() != null) {
        		int truck = waitTrucks.peek();
        		
        		if (truck + curBridgeWeight <= weight && curBridgeTruckCnt <= bridge_length) {
        			curBridgeWeight += truck;
        			curBridgeTruckCnt ++;
        			onBridgeQueue.offer(waitTrucks.poll());
        			timeQueue.offer(0);
        		}
        	}
        	
        	for (int i = 0; i < timeQueue.size(); i++) {
        		timeQueue.offer(timeQueue.poll() + 1);
        	}
        }
        
		return answer; 
	}
}

















