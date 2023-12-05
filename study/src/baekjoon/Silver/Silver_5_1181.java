package baekjoon.Silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Silver_5_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<>();
		int n = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= n; i++) {
			set.add(sc.nextLine());
		}
		
		List<String> list = new ArrayList<>(set);
		
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});
		
		for (String s : list) {
			System.out.println(s);
		}
	}
}
