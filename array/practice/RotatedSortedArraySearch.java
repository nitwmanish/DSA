package com.array.practice;

import java.util.List;

public class RotatedSortedArraySearch {
	public int binarySearch(int[] nums, int k) {
		int n = nums.length;
		int low = 0;
		int hi = n - 1;
		while (low <= hi) {
			int mid = low + (hi - low) / 2;
			if (nums[mid] == k) {
				return mid;
			} else if (k <= nums[n - 1] && (nums[mid] > nums[n - 1] || nums[mid] < k)) {
				low = mid + 1;
			} else if (k <= nums[n - 1] && nums[mid] > k) {
				hi = mid - 1;
			} else if (k > nums[n - 1] && (nums[mid] < k)) {
				low = mid + 1;
			} else if (k > nums[n - 1] && (nums[mid] < nums[n - 1] || nums[mid] > k)) {
				hi = mid - 1;
			}
		}
		return -1;
	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int search(final List<Integer> A, int B) {
		int[] nums = new int[A.size()];
		for (int i = 0; i < A.size(); i++) {
			nums[i] = A.get(i);
		}
		return binarySearch(nums, B);
	}
}
