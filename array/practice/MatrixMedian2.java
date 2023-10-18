package com.array.practice;

import java.util.ArrayList;

public class MatrixMedian2 {
	public int findMedian(ArrayList<ArrayList<Integer>> A) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			max = Math.max(max, A.get(i).get(A.get(i).size() - 1));
			min = Math.min(min, A.get(i).get(0));
		}
		int l = min;
		int r = max;
		int ans = r;
		int k = (A.get(0).size() * A.size()) >> 1; // median k = (min*max)/2

		while (l <= r) {
			int mid = (l + r) >> 1;
			int count = 0;
			for (int i = 0; i < A.size(); i++) {
				count += countlessSorted(A.get(i), mid);
			}
			if (count > k) {
				r = mid - 1; // when count is greater than the k then neglect right side
			} else {
				ans = mid; // when count<=k
				l = mid + 1;
			}
		}

		return ans;
	}

	// no of element smaller than the mid
	private static int countlessSorted(ArrayList<Integer> A, int mid) {
		int count = 0;
		for (int i = 0; i < A.size(); i++) {
			if (A.get(i) < mid) {
				count++;
			}
		}
		return count;
	}
}
