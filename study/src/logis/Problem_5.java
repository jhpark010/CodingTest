package logis;

import java.util.Arrays;

public class Problem_5 {
	/*
	 * 길이가 n인 배열에 1부터 n까지의 숫자가 중복 없이 한번씩 들어있는지 확인
	 */
	public static void main(String[] args) {
		Problem_5 main = new Problem_5();
		int[] arr = {4,1,3,2};
		main.solution(arr);
	}
	
	public boolean solution(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != (i + 1)) return false;
        }
        return true;
    }

}
