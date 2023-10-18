package com.array.practice;

import java.util.ArrayList;

public class AllocateBooks {
	public int books(ArrayList<Integer> A, int B) {
		int N = A.size();
		if (B > N)
			return -1;
		// building start and end for Binary Search
		int start = A.get(0), end = 0;
		for (int i = 0; i < N; i++) {
			start = Math.max(A.get(i), start);
			end += A.get(i);
		}
		int ans = end;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (checkPages(mid, A, B)) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	private static boolean checkPages(int maxpages, ArrayList<Integer> A, int students) {
		int sumPages = 0, count = 0;

		for (int i = 0; i < A.size(); i++) {
			sumPages += A.get(i);
			if (sumPages > maxpages) {
				count++;
				sumPages = A.get(i);
			}
		}
		if (sumPages != 0)
			count++;

		if (count <= students) {
			return true;
		} else {
			return false;
		}
	}
}
