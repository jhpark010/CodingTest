package practice.programmers.level_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public interface Test {
	int a();
	
    public int solution(int n);
    
    default boolean swap(A a, A b) {
    	return a() == 0;
    }
    
    class A {
    	int val;
    	
    	A (int val) {
    		this.val = val;
    	}
    }
}


















