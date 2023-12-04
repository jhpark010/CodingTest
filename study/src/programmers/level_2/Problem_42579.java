package programmers.level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_42579 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		List<Info> infoList = new ArrayList<>();
		
		for (int i = 0; i < plays.length; i ++) {
			infoList.add(new Info(i, plays[i], genres[i]));
		}
		
		HashMap<String, Integer> totalPlayList = new HashMap<>();
		
		for (int i = 0; i < genres.length; i++) {
			if (totalPlayList.containsKey(genres[i])) {
				totalPlayList.put(genres[i], totalPlayList.get(genres[i]) + plays[i]);
			} else {
				totalPlayList.put(genres[i], plays[i]);
			}
		}
		
		List<Map.Entry<String, Integer>> genreRankList = new ArrayList<>(totalPlayList.entrySet());
		genreRankList.sort(new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
				return b.getValue() - a.getValue();
			}
		});
		
		Collections.sort(infoList);
		
		List<Integer> answer = new ArrayList<>();
		
		for (int i = 0; i < genreRankList.size(); i++) {
			int cnt = 0;
			String genre = genreRankList.get(i).getKey();
			
			for (int j = 0; j < infoList.size(); j++) {
				if (cnt == 2) {
					break;
				}
				
				if (genre.equals(infoList.get(j).genre)) {
					cnt ++;
					answer.add(infoList.get(j).idx);
				}
			}
		}
		
		answer.stream().mapToInt(Integer::intValue).toArray();
	}
}

class Info implements Comparable<Info>{
	int idx;
	int play;
	String genre;
	
	Info(int idx, int play, String genre) {
		this.idx = idx;
		this.play = play;
		this.genre = genre;
	}
	
	@Override
	public int compareTo(Info i) {
		return i.play - this.play;
	}
}

















