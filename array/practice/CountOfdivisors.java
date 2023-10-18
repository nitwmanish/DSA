package com.array.practice;

import java.util.ArrayList;

public class CountOfdivisors {
	public static int[] sieveSpf(int A) {
		int[] spf = new int[A + 1];
		for (int i = 0; i <= A; i++) {
			spf[i] = i;
		}
		for (int i = 2; i <= (int) Math.sqrt(A); i++) {
			if (spf[i] == i) {
				for (int j = i * i; j <= A; j += i) {
					if (spf[j] == j) {
						spf[j] = i;
					}
				}
			}
		}
		return spf;
	}

	public static ArrayList<Integer> solve(ArrayList<Integer> A) {
		int max = 0;
		for (int i = 0; i < A.size(); i++) {
			max = Math.max(max, A.get(i));
		}
		int[] spf = sieveSpf(max);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int n : A) {
			int total = 1;
			while (n > 1) {
				int p = spf[n];
				int c = 0;
				while (n % p == 0) {
					c++;
					n = n / p;
				}
				total = total * (c + 1);
			}
			res.add(total);
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(2);
		A.add(3);
		A.add(4);
		A.add(5);
		System.out.println(solve(A));

	}

}
