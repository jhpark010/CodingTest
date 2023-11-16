package programmers.level_1;

import java.util.HashMap;
import java.util.Map.Entry;

public class Problem_42578 {
	public static void main(String[] args) {
		int answer = 1;
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		HashMap<String, Integer> map = new HashMap<>();
		
		for (String[] tmp : clothes) {
			map.put(tmp[1], map.getOrDefault(tmp[1], 0) + 1);
		}
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			answer *= entry.getValue() + 1;
		}
		
		System.out.println(answer - 1);
		
	}
}
