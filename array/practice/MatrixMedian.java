package com.array.practice;

import java.util.ArrayList;

public class MatrixMedian {
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int N = A.size();
		int M = A.get(0).size();
		int med = N * M / 2 + 1;
		for (int i = 0; i < N; i++) {
			min = Math.min(min, A.get(i).get(0));
			max = Math.max(max, A.get(i).get(M - 1));
		}
		int l = min;
		int h = max;
		int ans = min;
		while (l <= h) {
			int m = (l + h) / 2;
			ArrayList<Integer> temp = rank(A, m);
			int lowRange = temp.get(0) + 1;
			int highRange = temp.get(0) + temp.get(1);
			int equal = temp.get(1);
			if (med >= lowRange && med <= highRange) {
				if (equal == 0) {
					l = m + 1;
				} else {
					ans = m;
					break;
				}
			}
			if (med < lowRange) {
				h = m - 1;
			}
			if (med > highRange) {
				l = m + 1;
			}
		}
		return ans;
	}

	public ArrayList<Integer> rank(ArrayList<ArrayList<Integer>> A, int B) {
		ArrayList<Integer> out = new ArrayList<Integer>();
		int N = A.size();
		int M = A.get(0).size();
		int less = 0;
		int equal = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A.get(i).get(j) < B) {
					less++;
				}
				if (A.get(i).get(j) == B) {
					equal++;
				}
			}
		}
		out.add(less);
		out.add(equal);
		return out;
	}
}
