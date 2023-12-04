package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_42888 {
	public static void main(String[] args) {
		// Test Case
		String[] record = { "Enter uid1234 Muzi"
				, "Enter uid4567 Prodo"
				, "Leave uid1234"
				, "Enter uid1234 Prodo"
				, "Change uid4567 Ryan" };
		
		// Answer
		Problem_42888 main = new Problem_42888();
		System.out.println(Arrays.toString(main.solution(record)));

	}

	public String[] solution(String[] record) {
		//각 key는 userId
		Map<String, String> names = new HashMap<>();
		List<User> logs = new ArrayList<>();
		
		for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");
			
			if (arr[0].equals("Change") || arr[0].equals("Enter")) {
				names.put(arr[1], arr[2]);
			}
			
			logs.add(new User(arr[1], arr[0]));
		}
		
		List<String> answer = new ArrayList<>();
		
		for (int i = 0; i < logs.size(); i++) {
			if (logs.get(i).state.equals("Change")) {
				continue;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append(names.get(logs.get(i).id));
			
			if (logs.get(i).state.equals("Enter")) {
				sb.append("님이 들어왔습니다.");
			} else if (logs.get(i).state.equals("Leave")) {
				sb.append("님이 나갔습니다.");
			}
			
			answer.add(sb.toString());
		}
		
		return answer.toArray(new String[answer.size()]);
	}
	
	class User {
		String id;
		String state;
		
		User (String id, String state) {
			this.id = id;
			this.state = state;
		}
	}
	
}
