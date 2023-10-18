package com.binary.search.practice;

import java.util.Arrays;

public class TheKWeakestRowsInMatrix {
	private int binarySearch(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > 0) {
				start = mid + 1;
			} else {
				ans = mid;
				end = mid - 1;
			}
		}
		return ans;
	}

	class Pair implements Comparable<Pair> {
		int soldiers;
		int index;

		Pair(int soldiers, int index) {
			this.soldiers = soldiers;
			this.index = index;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.soldiers == o.soldiers) {
				return this.index - o.index;
			}
			return this.soldiers - o.soldiers;
		}
	}

	public int[] kWeakestRows(int[][] mat, int k) {
		Pair[] soldiersArray = new Pair[mat.length];
		int i = 0;
		for (int[] nums : mat) {
			int index = binarySearch(nums);
			if (index == -1) {
				soldiersArray[i] = new Pair(nums.length, i);
			} else {
				int soldiers = index;
				soldiersArray[i] = new Pair(soldiers, i);
			}
			i++;
		}
		Arrays.sort(soldiersArray);
		int[] ans = new int[k];
		for (int j = 0; j < k; j++) {
			ans[j] = soldiersArray[j].index;
		}
		return ans;
	}


	public static void main(String[] args) {
		TheKWeakestRowsInMatrix alg = new TheKWeakestRowsInMatrix();
		int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
		int[] nums = alg.kWeakestRows(mat, 3);
		for (int ele : nums) {
			System.out.print(ele + "  ");
		}
	}
}
