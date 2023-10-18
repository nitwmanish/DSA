package com.binary.search.practice;

public class LongestSubsequenceWithLimitedSum {
	private void mergeSort(int[] nums, int s, int e) {
		if (s == e) {
			return;
		}
		int mid = (s + e) / 2;
		mergeSort(nums, s, mid);
		mergeSort(nums, mid + 1, e);
		merge(nums, s, mid, e);
	}

	private void merge(int[] nums, int s, int mid, int e) {
		int[] temp = new int[e - s + 1];
		int p1 = s;
		int p2 = mid + 1;
		int p3 = 0;
		while (p1 <= mid && p2 <= e) {
			if (nums[p1] <= nums[p2]) {
				temp[p3] = nums[p1];
				p1++;
				p3++;
			} else {
				temp[p3] = nums[p2];
				p2++;
				p3++;
			}
		}
		while (p1 <= mid) {
			temp[p3] = nums[p1];
			p1++;
			p3++;
		}
		while (p2 <= e) {
			temp[p3] = nums[p2];
			p2++;
			p3++;
		}
		int j = s;
		for (int i = 0; i < temp.length; i++) {
			nums[j] = temp[i];
			j++;
		}
	}

	private int binarySearch(int[] nums, int k) {
		int start = 0;
		int end = nums.length - 1;
		int ans = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] <= k) {
				ans = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	private void printArray(int[] nums) {
		for (int ele : nums) {
			System.out.print(ele + "  ");
		}
	}

	public int[] answerQueries(int[] nums, int[] queries) {
		mergeSort(nums, 0, nums.length - 1);
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i];
		}
		printArray(prefixSum);
		System.out.println();
		int[] ans = new int[queries.length];
		for (int i = 0; i < queries.length; i++) {
			int j = binarySearch(prefixSum, queries[i]);
			ans[i] = Math.abs(j + 1);
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestSubsequenceWithLimitedSum alg = new LongestSubsequenceWithLimitedSum();
		int[] nums = { 4, 5, 2, 1 };
		int[] queries = { 3, 10, 21 };
		int[] ans = alg.answerQueries(nums, queries);
		for (int ele : ans) {
			System.out.print(ele + "  ");
		}
	}
}
