package com.array.practice;

import java.util.ArrayList;

public class FoodPacketsDistribution {
	public int solve(ArrayList<Integer> A, int B) {
		int ans = -1;
		int left = 0;
		int right = Integer.MAX_VALUE;
		for (int i = 0; i < A.size(); i++) {
			right = Math.min(right, A.get(i));
		}
		while (left <= right) {
			int mid = (left + right) / 2;
			if (isMinimum(A, mid, B)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (ans == -1) {
			return 0;
		} else {
			return ans;
		}
	}

	public boolean isMinimum(ArrayList<Integer> A, int mid, int B) {
		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			if (mid == 0) {
				sum += A.get(i);
			} else {
				sum += (A.get(i) / mid);
			}
		}
		return sum >= B;
	}
}
