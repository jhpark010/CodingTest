package logis;

public class Problem_3 {
	/*
	 * 자리수의 합
	 */
	public static void main(String[] args) {
		Problem_3 main = new Problem_3();
		int N = 987;
		main.solution(N);
	}
	
	public int solution(int n) {
        int answer = 0;
        String str = String.valueOf(n);

        for (int i = 0; i < str.length(); i++) {
            answer += (str.charAt(i) - '0');
        }
        return answer;
    }

}
