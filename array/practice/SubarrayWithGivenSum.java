package com.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SubarrayWithGivenSum {
//	public int[] solve(int[] A, int B) {
//		int l = A.length;
//		int[] ps = new int[A.length];
//		ps[0] = A[0];
//		for (int i = 1; i < A.length; i++) {
//			ps[i] = ps[i - 1] + A[i];
//		}
//		int p1 = 0;
//		int p2 = 1;
//		while (p1 < l & p2 < l) {
//			int sum = 0;
//			if (p1 == 0) {
//				sum = ps[p2];
//			} else {
//				sum = ps[p2] - ps[p1 - 1];
//			}
//			if (sum == B) {
//				int[] ans = new int[p2 - p1 + 1];
//				int j = 0;
//				for (int i = p1; i <= p2; i++) {
//					ans[j] = A[i];
//					j += 1;
//				}
//				return ans;
//			} else if (sum > B) {
//				p1 += 1;
//			} else {
//				p2 += 1;
//			}
//		}
//		int[] ans = new int[1];
//		ans[0] = -1;
//		return ans;
//	}
	public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
		int[] ps = new int[A.size()];
		ps[0] = A.get(0);
		for (int i = 1; i < A.size(); i++) {
			ps[i] = ps[i - 1] + A.get(i);
		}
		int p1 = 0;
		int p2 = 1;
		while (p1 < A.size() & p2 < A.size()) {
			int sum = 0;
			if (p1 == 0) {
				sum = ps[p2];
			} else {
				sum = ps[p2] - ps[p1 - 1];
			}
			if (sum == B) {
				ArrayList<Integer> ans = new ArrayList<Integer>();
				for (int i = p1; i <= p2; i++) {
					ans.add(A.get(i));
                }
				return ans;
			} else if (sum > B) {
				p1 += 1;
			} else {
				p2 += 1;
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(-1);
		return ans;
	}

	public static void main(String[] args) {
//		int[] nums = { 1, 2, 3, 4, 5 };
//		int B = 5;
		int[] nums = { 23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34, 14, 6 };
		int B = 62;
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
		SubarrayWithGivenSum l = new SubarrayWithGivenSum();
		System.out.println(l.solve(list, B));
	}
}
