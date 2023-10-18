package com.array.practice;

public class SortedPermutationRankWithRepeats {
	static int mod = 1000003;

	public static int getFindRank(String A) {
		if (A == null || A.length() == 0) {
			return 0;
		}
		int res = 1;
		for (int i = 0; i < A.length(); i++) {
			int count = 0;
			// Count all the value less than current alpha
			for (int j = i + 1; j < A.length(); j++) {
				if (A.charAt(i) > A.charAt(j)) {
					count++;
				}
			}
			// Find the freq of all the dup apha from the current element.
			int[] freq = new int[52];
			for (int j = i; j < A.length(); j++) {
				if (A.charAt(j) >= 'a' && A.charAt(j) <= 'z') {
					freq[A.charAt(j) - 'a']++;
				} else {
					freq[A.charAt(j) - 'A' + 26]++;
				}
			}
			long factVal = 1;
			// Take fact for the dup values
			for (int j = 0; j < freq.length; j++) {
				if (freq[j] > 1) {
					factVal = factVal * factorials(freq[j]) % mod;
				}
			}
			// take Fermat mod on the total dup value
			long inverse = getFermatSolve(factVal, mod);
			res = (int) ((res % mod) + (count * factorials(A.length() - 1 - i) * inverse) % mod);
		}
		return res;
	}

	public static int factorials(int n) {
		int mod = 1000003;
		if (n > -1 && n < 2) {
			return 1;
		}
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact = (fact * i) % mod;
		}
		return (fact % mod);

	}

	public static int getFermatSolve(long A, int B) {
		int result = 1;
		long p = B - 2;
		long a = A;
		while (p > 0) {
			if (p % 2 == 1) {
				result = (int) ((result * a) % mod);
			}
			a = (a * a) % mod;
			p >>= 1;
		}
		return result;
	}

}
