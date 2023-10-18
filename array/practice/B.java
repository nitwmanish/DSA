package com.array.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class B {

	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	HashSet<Integer> set = new HashSet<Integer>();

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

		rand(A);
		ArrayList<Integer> res = new ArrayList<Integer>();
		long[] prefix = new long[A.size() + 1];
		prefix[0] = 0;
		int k = 1;
		for (int a : A) {
			prefix[k] = prefix[k - 1] + map.get(a);
			k++;
		}
		for (int i = 0; i < B.size(); i++) {
			if (B.get(i).get(1) - B.get(i).get(0) == B.get(i).get(3) - B.get(i).get(2)) {
				if (prefix[B.get(i).get(1) + 1] - prefix[B.get(i).get(0)] == prefix[B.get(i).get(3) + 1]
						- prefix[B.get(i).get(2)])
					res.add(1);
				else
					res.add(0);
			} else
				res.add(0);
		}
		return res;
	}

	void rand(ArrayList<Integer> A) {
		int min = 1;
		int max = 1000000007;
		int range = max - min + 1;
		for (int i = 0; i < A.size(); i++) {
			if (!map.containsKey(A.get(i))) {
				int value = (int) (0D + 1D * Math.random() * range + min);
				while (set.contains(value)) {
					value = (int) (0D + 1D * Math.random() * range + min);
				}
				map.put(A.get(i), value);
				set.add(value);
			}
		}
	}

	public int colorful(int A) {
		int isColorful = 1;
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		while (A > 0) {
			list.add(A % 10);
			A = A / 10;
		}

		for (int i = 0; i < list.size(); i++) {
			if (!set.add(list.get(i))) {
				isColorful = 0;
				break;
			}
			int prod = list.get(i);
			for (int j = (i + 1); j < list.size(); j++) {
				prod = prod * list.get(j);
				if (!set.add(prod)) {
					isColorful = 0;
					break;
				}
			}
		}
		return isColorful;
	}

	public int solve(String A) {
		HashMap<Character, Integer> map = new HashMap<>();
		int n = A.length();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(A.charAt(i))) {
				map.put(A.charAt(i), (map.get(A.charAt(i)) + 1));
			} else {
				map.put(A.charAt(i), 1);
			}
		}

		int counter = 0;
		for (int val : map.values()) {
			if (val % 2 != 0) {
				counter++;
				if (counter == 2) {
					return 0;
				}
			}
		}
		return 1;
	}

	public static ArrayList<Integer> getSolve(ArrayList<Integer> A, ArrayList<Integer> B) {
		SortedMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < A.size(); i++) {
			map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
		}
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < B.size(); i++) {
			if (map.containsKey(B.get(i))) {
				int j = 0;
				while (j < map.get(B.get(i))) {
					res.add(B.get(i));
					j++;
				}
				map.put(B.get(i), 0);
			}
		}
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			int key = e.getKey();
			int i = 0;
			while (i < e.getValue()) {
				res.add(key);
				i++;
			}
		}
		return res;
	}

	private static int[] generateLPS(String A) {
		int[] lps = new int[A.length()];
		int i = 1, j = 0;
		while (i < A.length()) {
			if (A.charAt(i) == A.charAt(j)) {
				lps[i++] = ++j;
			} else {
				if (j == 0) {
					lps[i++] = 0;
				} else {
					j = lps[j - 1];
				}
			}
		}
		return lps;
	}

	public static int solve(String A, String B) {
		String str = A + "#" + B + B.substring(0, B.length() - 1);
		System.out.println(str);
		int[] lps = generateLPS(str);
		int count = 0;
		for (int i = 0; i < lps.length; i++) {
			System.out.print(lps[i]+" ");
			if (lps[i] == A.length()) {
				count++;
			}
		}
		System.out.println();
		return count;
	}

	public static void main(String[] args) {
		String A = "1001";
		String B = "0011";
		System.out.println(solve(A, B));
	}

}
