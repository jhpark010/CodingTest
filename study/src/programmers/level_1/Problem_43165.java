package programmers.level_1;

public class Problem_43165 {
	public static void main(String[] args) {
		// Test Case
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		int n = 3;
		
		// Answer
		Problem_43165 p = new Problem_43165();
		System.out.println(p.solution(n, computers));
		
	}
	
	public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
        	if (!visited[i]) {
        		dfs(computers, visited, i);
        		answer ++;
        	}
        }
        
        return answer;
    }
	
	public void dfs(int[][] computers, boolean[] visited, int start) {
		visited[start] = true;
		
		for (int i = 0; i < computers[start].length; i++) {
			if (computers[start][i] == 1 && !visited[i]) {
				dfs(computers, visited, i);
			}
		}
	}
	
	
	
	
	//////////////////
	//// Union & Find
	/*
	int[] iArr;
	
	public int find(int v) {
		if (iArr[v] == v) {
			return v;
		} else {
			return find(iArr[v]);
		}
	}
	
	public void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		
		if (fa != fb) {
			iArr[fa] = fb;
		}
	}
	
	public int solution(int n, int[][] computers) {
		int answer = 0;
		iArr = new int[n + 1];
		HashSet<Integer> hs = new HashSet<>();
		
		for (int i = 1; i < iArr.length; i++) {
			iArr[i] = i;
		}
		
		for (int i = 0; i < computers.length; i++) {
			List<Integer> tmpList = new ArrayList<>();
			
			for (int j = 0; j < computers[i].length; j++) {
				if (computers[i][j] == 1) {
					tmpList.add(j + 1);
				}
			}
			
			if (tmpList.size() > 1) {
				for (int k = 1; k < tmpList.size(); k++) {
					union(tmpList.get(0), tmpList.get(k));
				}
			}
		}
		
		
		for (int i = 1; i < iArr.length; i++) {
			hs.add(find(iArr[i]));
		}
		
		answer = hs.size();
		
		return answer;
    }
    */
	
}

















