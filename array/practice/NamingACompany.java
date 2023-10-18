package com.array.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NamingACompany {
	public long distinctNames2(String[] ideas) {
		HashSet<String>[] count = new HashSet[26];
		for (int i = 0; i < 26; ++i) {
			count[i] = new HashSet<>();
		}
		for (String s : ideas) {
			count[s.charAt(0) - 'a'].add(s.substring(1));
		}
		long res = 0;
		for (int i = 0; i < 26; ++i)
			for (int j = i + 1; j < 26; ++j) {
				long c1 = 0;
				long c2 = 0;
				for (String str : count[i]) {
					if (!count[j].contains(str)) {
						c1++;
					}
				}
				for (String str : count[j]) {
					if (!count[i].contains(str)) {
						c2++;
					}
				}
				res += c1 * c2;
			}
		return res * 2;
	}

	public long distinctNames3(String[] ideas) {
		HashSet<Integer>[] count = new HashSet[26];
		for (int i = 0; i < 26; ++i) {
			count[i] = new HashSet<>();
		}
		for (String s : ideas) {
			count[s.charAt(0) - 'a'].add(s.substring(1).hashCode());
		}
		long res = 0;
		for (int i = 0; i < 26; ++i)
			for (int j = i + 1; j < 26; ++j) {
				long c1 = 0;
				long c2 = 0;
				for (int c : count[i]) {
					if (!count[j].contains(c)) {
						c1++;
					}
				}
				for (int c : count[j]) {
					if (!count[i].contains(c)) {
						c2++;
					}
				}
				res += c1 * c2;
			}
		return res * 2;
	}

	public long distinctNames(String[] ideas) {
		Set<String> set = new HashSet<>(Arrays.asList(ideas));
		int count = 0;
		for (int i = 0; i < ideas.length; i++) {
			for (int j = i + 1; j < ideas.length; j++) {
				char[] ideaA = ideas[i].toCharArray();
				char[] ideaB = ideas[j].toCharArray();
				char temp = ideaA[0];
				ideaA[0] = ideaB[0];
				ideaB[0] = temp;
				if (!set.contains(new String(ideaA)) && !set.contains(new String(ideaB))) {
					count++;
				}
			}
		}
		return 2 * count;
	}

	public static void main(String[] args) {
		String[] ideas = { "coffee", "donuts", "time", "toffee" };
		NamingACompany algo = new NamingACompany();
		System.out.println(algo.distinctNames(ideas));
		System.out.println(algo.distinctNames2(ideas));
		System.out.println(algo.distinctNames3(ideas));
	}

}
