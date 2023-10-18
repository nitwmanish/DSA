package com.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SearchInBitonicArray {
	private static int binarySearchAsc(ArrayList<Integer> A, int start, int end, int K) {
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (A.get(mid) == K) {
				return mid;
			} else if (A.get(mid) > K) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private static int binarySearchDesc(ArrayList<Integer> A, int start, int end, int K) {
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (A.get(mid) == K) {
				return mid;
			} else if (A.get(mid) > K) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	private static int bitonicPoint(ArrayList<Integer> A) {
		if (A.get(0) > A.get(1)) {
			return 0;
		}
		if (A.get(A.size() - 1) > A.get(A.size() - 2)) {
			return A.size() - 1;
		}
		int start = 1, end = A.size() - 2;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (A.get(mid - 1) < A.get(mid) && A.get(mid) > A.get(mid + 1)) {
				return mid;
			} else if (A.get(mid) < A.get(mid + 1)) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	public int solve(ArrayList<Integer> A, int B) {
		int bitonicPoint = bitonicPoint(A);
		if (A.get(bitonicPoint) == B) {
			return bitonicPoint;
		}
		if (B > A.get(bitonicPoint)) {
			return -1;
		}
		int ans = binarySearchAsc(A, 0, bitonicPoint - 1, B);
		if (ans != -1) {
			return ans;
		}
		ans = binarySearchDesc(A, bitonicPoint + 1, A.size() - 1, B);
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 10, 9, 8, 7, 6 };
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
		SearchInBitonicArray l = new SearchInBitonicArray();
		System.out.println(l.solve(list, 5));
	}

}
