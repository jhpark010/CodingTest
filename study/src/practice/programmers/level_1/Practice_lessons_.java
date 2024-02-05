package practice.programmers.level_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice_lessons_ {
	public static void main(String[] args) {
		// Test Case
		int n = 10;
		
		// Answer
		Practice_lessons_ main = new Practice_lessons_();
		System.out.println(main.solution(n));
	}
	
    public int solution(int n) {
    	A a = new A(10);
    	A b = new A(10);
    	
    	swap(a, b);
    	
    	System.out.println("r : " + a.val);
    	System.out.println("r : " + b.val);
        return 0;
    }
    
    public void swap(A a, A b) {
    	a.val = 111;
    	b = a;
    	System.out.println("b : " + a.val);
    	System.out.println("b : " + b.val);
    }
    
    class A {
    	int val;
    	
    	A (int val) {
    		this.val = val;
    	}
    }
}


















