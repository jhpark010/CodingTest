package baekjoon.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Silver_5_10814 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		List<User> list = new ArrayList<>();
		
		while (n-- > 0) {
			String[] arr = br.readLine().split(" ");
			list.add(new User(n, Integer.parseInt(arr[0]), arr[1]));
		}
		
		Collections.sort(list);
		
		for (User u : list) {
			sb.append(u.toString()).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static class User implements Comparable<User>{
		int idx;
		int age;
		String name; 
		
		User (int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}
		
		@Override
		public int compareTo(User u) {
			if (this.age == u.age) {
				return u.idx - this.idx;
			} else {
				return this.age - u.age;
			}
		}
		
		@Override
		public String toString() {
			return this.age + " " + this.name;
		}
	}
}
