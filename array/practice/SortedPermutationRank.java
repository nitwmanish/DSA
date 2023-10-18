package com.array.practice;

public class SortedPermutationRank {
	public int[] factorials(int n) {
		int mod = 1000003;
		int[] factorials = new int[n + 1];
		factorials[0] = 1;
		for (int i = 1; i <= n; i++) {
			factorials[i] = factorials[i - 1] * i;
			factorials[i] %= mod;
		}
		return factorials;
	}

	public int findRank(String A) {
		int length = A.length();
		int[] factorials = factorials(length);
		long count = 0;
		long ans = 0;
		int mod = 1000003;
		for (int i = 0; i < length; i++) {
			count = 0;
			for (int j = i + 1; j < length; j++) {
				if (A.charAt(j) < A.charAt(i)) {
					count++;
				}
			}
			ans += (count * factorials[length - i - 1]) % mod;
		}
		return (int) (ans + 1) % mod;
	}

	public static void main(String[] args) {
		SortedPermutationRank rank = new SortedPermutationRank();
		System.out.print(rank.findRank("acb"));

	}

}
