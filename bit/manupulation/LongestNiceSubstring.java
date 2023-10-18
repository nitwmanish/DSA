package com.bit.manupulation;

public class LongestNiceSubstring {
	public String longestNiceSubstring(String s) {
		int maxLength = 0, idx = 0; // idx stores the starting index of the substring
		int lowerCase, upperCase;
		for (int i = 0; i < s.length(); i++) {
			lowerCase = 0;
			upperCase = 0;
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(j) >= 'a')
					lowerCase |= (1 << (s.charAt(j) - 'a'));
				else
					upperCase |= (1 << (s.charAt(j) - 'A'));
				if ((lowerCase ^ upperCase) == 0) {
					if (maxLength < j - i + 1) {
						idx = i;
						maxLength = j - i + 1;
					}
				}
			}
		}
		if (maxLength == 0)
			return "";
		String ans = s.substring(idx, idx+ maxLength);
		return ans;
	}

	public static void main(String[] args) {

		LongestNiceSubstring alg = new LongestNiceSubstring();
		System.out.println(alg.longestNiceSubstring("YazaAay"));
	}

}
