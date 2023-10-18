package com.backtracking2.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneDigits {

	static void backtracking(int[] digits, int index, Map<Integer, String> map, StringBuilder sb,
			ArrayList<String> ans) {
		if (index == digits.length) {
			ans.add(sb.toString());
			return;
		}
		String str = map.get(digits[index]);
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			backtracking(digits, index + 1, map, sb, ans);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	static ArrayList<String> possibleWords(int a[], int N) {
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		ArrayList<String> ans = new ArrayList<>();
		if (a.length == 0) {
			return ans;
		}
		backtracking(a, 0, map, new StringBuilder(), ans);
		return ans;
	}

	public static void main(String[] args) {
		int N = 3;
		int[] digits = { 2, 3, 4 };
		System.out.print(possibleWords(digits, N));

	}

}
