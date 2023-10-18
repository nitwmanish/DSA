package com.array.practice;

public class NumberOfOpenDoors {
	public static boolean[] getSieve(int A) {
		boolean[] spf = new boolean[A + 1];
		for (int i = 0; i <= A; i++) {
			spf[i] = false;
		}
		for (int i = 1; i <= A; i++) {
			for (int j = i; j <= A; j += i) {
				if (spf[j] == true) {
					spf[j] = false;
				} else {
					spf[j] = true;
				}
			}
		}
		return spf;
	}

	public static int solve(int A) {
		boolean[] spf = getSieve(A);
		int count = 0;
		for (int i = 1; i < spf.length; i++) {
			if (spf[i]) {
				count++;
			}
		}
		return count;
	}

	public static int solve1(int A) {
		int cnt = 0;
		for (int i = 1; i * i <= A; i++) {
			cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		System.out.println(solve(4));
		System.out.println(solve1(7375780));

	}

}
