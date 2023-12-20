package programmers.level_2;

import java.util.Stack;

public class Problem_60058 {
	public static void main(String[] args) {
		// Test Case
		String p = "()))((()";
		
		// Answer
		Problem_60058 main = new Problem_60058();
		System.out.println(main.solution(p));

	}

	public String solution(String p) {
		return dfs(p);
    }
	
	public String dfs(String w) {
		if (w.isEmpty()) {
			return "";
			
		} else {
			int leftOpen = 0;
			String u = "";
			String v = "";
			String result = "";
			
			for (int i = 0; i < w.length(); i++) {
				if (w.charAt(i) == '(') {
					leftOpen++;
				} else {
					leftOpen--;
				}
				
				if (leftOpen == 0) {
					u = w.substring(0, i + 1);
					v = w.substring(i + 1);
					break;
				}
			}
			
			if (isCheck(u)) {
				result = u + dfs(v);
			} else {
				result = "(" + dfs(v) + ")";
				for (int i = 1; i < u.length() - 1; i++) {
					if (u.charAt(i) == '(') {
						result += ')';
					} else {
						result += '(';
					}
				}
			}
			
			return result;
		}
	}
	
	
	
	public boolean isCheck(String str) {
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				s.push(str.charAt(i));
			} else {
				if (s.isEmpty()) {
					return false;
				} else {
					s.pop();
				}
			}
		}
		
		return true;
	}
	

    // p는 '(' 와 ')' 로만 이루어진 문자열이며 길이는 2 이상 1,000 이하인 짝수입니다.
    // 문자열 p를 이루는 '(' 와 ')' 의 개수는 항상 같습니다.
    private String balancedParen(String w, int fromW) {
        if (fromW == w.length()) return "";
        int leftOpen = 0;
        int balancedCount = 0;
        for (int i = fromW; i < w.length(); ++i) {
            char c = w.charAt(i);
            if (c == '(') {
                leftOpen++;
                balancedCount++;
            } else {
                if (leftOpen > 0) leftOpen--;
                balancedCount--;
            }
            if (balancedCount == 0) {
                if (leftOpen == 0) {
                    // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
                    // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
                    return w.substring(fromW, i + 1) + balancedParen(w, i + 1);
                } else {
                    // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
                    // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
                    // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
                    // 4-3. ')'를 다시 붙입니다. 
                    // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
                    // 4-5. 생성된 문자열을 반환합니다.
                    return "(" + balancedParen(w, i + 1) + ")" + reverse(w, fromW + 1, i);
                }
            }
        }
        // should be unreachable.
        throw new IllegalArgumentException("the input should only contain parens and open and closing paren should match");
    }

    private String reverse(String w, int from, int to) {
        StringBuilder sb = new StringBuilder();
        for (int i = from; i < to; ++i) {
            sb.append((w.charAt(i) == ')' ? '(' : ')'));
        }
        return sb.toString();
    }
}













