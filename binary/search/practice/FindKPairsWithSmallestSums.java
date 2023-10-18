package com.binary.search.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) {
			return res;
		}
		int n = nums1.length;
		int m = nums2.length;
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
		for (int j = 0; j < m; j++) {
			minHeap.offer(new int[] { nums1[0] + nums2[j], 0, j });
		}
		for (int i = 0; i < Math.min(k, m * n); i++) {
			if (!minHeap.isEmpty()) {
				int[] top = minHeap.poll();
				List<Integer> list = new ArrayList<>();
				list.add(nums1[top[1]]);
				list.add(nums2[top[2]]);
				res.add(list);
				if (top[1] + 1 < n) {
					minHeap.offer(new int[] { nums1[top[1] + 1] + nums2[top[2]], top[1] + 1, top[2] });
				} else if (top[2] + 1 < m) {
					minHeap.offer(new int[] { nums1[0] + nums2[top[2] + 1], 0, top[2] + 1 });
				}
			}

		}
		return res;
	}
	public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
		List<List<Integer>> results = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0) {
			return results;
		}
		for (int i = 0; i < nums1.length && i < k; i++) {
			minHeap.offer(new int[] { nums1[i], nums2[0], 0 });
		}
		while (k-- > 0 && !minHeap.isEmpty()) {
			int[] top = minHeap.poll();
			int u = top[0];
			int v = top[1];
			int indexOfNums2 = top[2];
			List<Integer> list = new ArrayList<>();
			list.add(u);
			list.add(v);
			results.add(list);
			if (indexOfNums2 == nums2.length - 1) {
				continue;
			}
			minHeap.offer(new int[] { u, nums2[indexOfNums2 + 1], indexOfNums2 + 1 });
		}
		return results;
	}
	

	public static void main(String[] args) {
		FindKPairsWithSmallestSums alg = new FindKPairsWithSmallestSums();
//		int[] nums1 = { 1, 7, 11 };
//		int[] nums2 = { 2, 4, 6 };
//		int[] nums1 = { 1, 2 };
//		int[] nums2 = { 3 };
		int[] nums1 = { 1, 1, 2 };
		int[] nums2 = { 1, 2, 3 };
		System.out.print(alg.kSmallestPairs(nums1, nums2, 10));

	}
}

