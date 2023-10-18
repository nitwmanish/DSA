package com.backtracking2.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

	private int countInvalidCount(String str) {
		int open = 0;
		int invalidClose = 0;
		for (char ch : str.toCharArray()) {
			if (ch == '(') {
				open++;
			} else if (ch == ')') {
				if (open > 0) {
					open--;
				} else {
					invalidClose++;
				}
			}
		}
		return open + invalidClose;
	}

	private void backtracking(String str, int index, int open, int removed, int invalidCount, StringBuilder sb,
			Set<String> ans) {
		if (index == str.length() && open == 0) {
			ans.add(sb.toString());
			return;
		}
		if (index == str.length() || removed > invalidCount) {
			return;
		}
		if (str.charAt(index) == '(') {
			sb.append(str.charAt(index));
			backtracking(str, index + 1, open + 1, removed, invalidCount, sb, ans); // use '('
			sb.deleteCharAt(sb.length() - 1);
			backtracking(str, index + 1, open, removed + 1, invalidCount, sb, ans);// not use '('
		} else if (str.charAt(index) == ')') {
			if (open > 0) {
				sb.append(str.charAt(index));
				backtracking(str, index + 1, open - 1, removed, invalidCount, sb, ans);// use ')'
				sb.deleteCharAt(sb.length() - 1);
			}
			backtracking(str, index + 1, open, removed + 1, invalidCount, sb, ans); // not use ')'
		} else {
			sb.append(str.charAt(index));
			backtracking(str, index + 1, open, removed, invalidCount, sb, ans);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public List<String> removeInvalidParentheses(String s) {
		int invalidCount = countInvalidCount(s);
		Set<String> ans = new HashSet<>();
		backtracking(s, 0, 0, 0, invalidCount, new StringBuilder(), ans);
		return new ArrayList<String>(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
