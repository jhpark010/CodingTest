package practice.programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice_lessons_42888 {
	public static void main(String[] args) {
		// Test Case
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan", "Enter uid1111 Pro", "Leave uid1234" };

		// Answer
		Practice_lessons_42888 main = new Practice_lessons_42888();
		System.out.println(Arrays.toString(main.solution(record)));

	}

	public String[] solution(String[] record) {
		Map<String, String> name = new HashMap<>();
		List<String> logs = new ArrayList<>();

		for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");

			if (arr[0].equals("Change") || arr[0].equals("Enter")) {
				name.put(arr[1], arr[2]);
			}
		}

		for (int i = 0; i < record.length; i++) {
			String[] arr = record[i].split(" ");

			if (arr[0].equals("Leave")) {
				logs.add(name.get(arr[1]) + "님이 나갔습니다.");
			} else if (arr[0].equals("Enter")) {
				logs.add(name.get(arr[1]) + "님이 들어왔습니다.");
			}
		}

		return logs.toArray(new String[logs.size()]);
	}

//	public String[] getRecord(String record) {
//		String
//	}

}
