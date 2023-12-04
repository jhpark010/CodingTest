package programmers.level_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem_150370 {
	public static void main(String[] args) {
		Problem_150370 p = new Problem_150370();
		String today = "2020.01.01";
		String[] terms = {"Z 3", "D 5"};
		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		
//		p.solution(today, terms, privacies);
		for (int n : p.solution2(today, terms, privacies)) {
			System.out.println(n);
		}
	}
	
	public int[] solution2(String today, String[] terms, String[] privacies) {
		List<Integer> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		int todays = getDate(today);
		
		for (String term : terms) {
			String[] tmp = term.split(" ");
			
			map.put(tmp[0], Integer.valueOf(tmp[1]));
		}
		
		for (int i = 0; i < privacies.length; i++) {
			String[] info = privacies[i].split(" ");
			int privacyDays = getDate(info[0]);
			int term = map.get(info[1]);
			
			if (privacyDays + (term * 28) < todays) {
				list.add(i + 1);
			}
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public int getDate(String s) {
		String[] date = s.split("\\.") ;
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		
		return (year * 12 * 28) + (month * 28) + day;
	}
	
	
	
	
	String[] todayArr;
	
	public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termList = new HashMap<>();
        todayArr = today.split("\\.");
        
        System.out.println(todayArr[0] + "-" + todayArr[1] + "-" + todayArr[2]);
        
        for (String t : terms) {
        	String[] info = t.split(" ");
        	termList.put(info[0], Integer.parseInt(info[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
        	String[] privacy = privacies[i].split(" ");
        	
        	int term = termList.get(privacy[1]);
        	
        	String[] date = privacy[0].split("\\.");
        	
        	if(!isValid(date, term)) {
        		answer.add(i + 1);
        	}
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
	
	
	public boolean isValid(String[] date, int term) {
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		int termYear = term / 12;
		int termMonth = term % 12;
		
		if (termYear > 0) {
			if (month + termMonth > 12) {
				year = year + termYear + 1;
				month = (month + termMonth) % 12;
				
			} else {
				year = year + termYear;
				month = month + termMonth;
			}
			
		} else {
			if (month + termMonth > 12) {
				year = year + 1;
				month = (month + termMonth) % 12;
				
			} else {
				month = month + termMonth;
			}
		}
		
		day = day - 1;
		
		if (day == 0) {
			day = 28;
			month = month - 1;
			
			if (month == 0) {
				month = 12;
				year--;
			}
		}
		
		System.out.println(year + "-" + month + "-" + day);
		
		if (Integer.parseInt(todayArr[0]) < year) {
			return true;
		} else if (Integer.parseInt(todayArr[0]) == year) {
			if (Integer.parseInt(todayArr[1]) < month) {
				return true;
			} else if (Integer.parseInt(todayArr[1]) == month ) {
				if (Integer.parseInt(todayArr[2]) <= day) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	
	
}












