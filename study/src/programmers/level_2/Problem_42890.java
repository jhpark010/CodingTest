package programmers.level_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem_42890 {
	public static void main(String[] args) {
		// Test Case
		String[][] relation = {{"100","ryan","music","2"}
			,{"200","apeach","math","2"}
			,{"300","tube","computer","3"}
			,{"400","con","computer","4"}
			,{"500","muzi","music","3"}
			,{"600","apeach","music","2"}};
		// Answer
		Problem_42890 p = new Problem_42890();
		System.out.println(p.solution(relation));

	}

	int n;    //행의 수
	int m;    //열의 수
	String[][] relationCopy;    //전역 변수로 쓸 relation의 카피
	List<HashSet<Integer>> candidateKeyList;    //후보키 리스트
	int answer;
	
	public int solution(String[][] relation) {
		answer = 0;
		relationCopy = relation;
		n = relationCopy.length;
		m = relationCopy[0].length;
		candidateKeyList = new ArrayList<>();
		
		//조합의 수 (1부터 열의 개수(m)까지)
		for (int i = 1; i <= m; i++) {
			combi(0, i, 0, new HashSet<>());
		}
		
		return answer;
	}
	
	public void combi(int idx, int size, int depth, HashSet<Integer> set) {
		if (size == depth) {
			if (!unique(set)) {
				return;
			}

			// 최소성 검사
			// 후보키 리스트 내에 매개 변수로 받은 후보키들이 포함되어 있는지 검사
			for (HashSet<Integer> candidateKey : candidateKeyList) {
				if (set.containsAll(candidateKey)) {
					return;
				}
			}
			
			candidateKeyList.add(set);
			answer++;
			return;
			
		} else {
			for (int i = idx; i < m; i++) {
				HashSet<Integer> newSet = new HashSet<>(set);
				newSet.add(i);
				idx ++;
				combi(idx, size, depth + 1, newSet);
			}
		}
	}
	
	//유일성 검사(동일한 값을 가지는 행이 있는지 검사)
	public boolean unique(HashSet<Integer> set) {
		//이전들의 행들의 값 중에 중복되는 값이 있는지 파악하기 위한 리스트
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < n; i ++) {
			StringBuilder sb = new StringBuilder();
			
			for (int idx : set) {
				sb.append(relationCopy[i][idx]);
				sb.append(" ");
			}
			
			if (!list.contains(sb.toString())) {
				list.add(sb.toString());
			} else {
				return false;
			}
		}
		
		return true;
	}
}













