package test;

import java.util.HashMap;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		HashMap<String, Double> map = new HashMap<>();
		map.put("A+", 4.5);
		map.put("A", 4.0);
		map.put("B+", 3.5);
		map.put("B", 3.0);
		map.put("C+", 2.5);
		map.put("C", 2.0);
		
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		int cnt = 0;
		
		while(true) {
			String s = sc.nextLine();
			
			if (s.equals("end")) {
				break;
			}
			
			sum += map.get(s);
			cnt ++;
		}
		
		System.out.println(sum / cnt);
		
	}
}
