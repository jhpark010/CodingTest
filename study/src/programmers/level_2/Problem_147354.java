package programmers.level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Problem_147354 {
	public static void main(String[] args) {
		Problem_147354 main = new Problem_147354();
		int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
		int col = 2;
		int row_begin = 2;
		int row_end = 3;
		
		System.out.println(main.solution(data, col, row_begin, row_end));
	}
	
	public int solution(int[][] data, int col, int row_begin, int row_end) {
        List<int[]> list = new ArrayList<>();
        
        for (int[] arr : data) {
        	list.add(arr);
        }
        
        Collections.sort(list, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a, int[] b) {
        		if (a[col - 1] == b[col - 1]) {
        			return b[0] - a[0];
        		} else {
        			return a[col - 1] - b[col - 1];
        		}
        	}
        });
        
        int[] first = list.get(row_begin - 1);
        int answer = 0;
        
        for (int i = 0; i < first.length; i++) {
        	answer += first[i] % row_begin;
        }
        
        for (int i = row_begin; i < row_end; i++) {
        	int tmp = 0;
	        
        	for (int j = 0; j < list.get(i).length; j++) {
	        	tmp += list.get(i)[j] % (i + 1);
	        }
        	
        	answer = answer ^ tmp;
        }
        
        return answer;
    }
}
