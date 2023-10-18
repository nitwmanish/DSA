package com.binary.search.practice;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
	private boolean isPossible(int[] nums, int k, int mid) {
		int i = 0;
		int j = 0;
		int count = 0;
		while (j < nums.length) {
			if (nums[j] - nums[i] > mid) {
				i++;
			} else {
				count += j - i;
				j++;
			}
		}
		return count >= k;
	}

	public int smallestDistancePair(int[] nums, int k) {
		
		Arrays.sort(nums);
		int start = 0;
		int end = nums[nums.length - 1] - nums[0];
		int ans = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			boolean isPossible = isPossible(nums, k, mid);
			if (isPossible) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		FindKthSmallestPairDistance alg = new FindKthSmallestPairDistance();
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(alg.smallestDistancePair(nums, 3));
		for(int i = 1; i <= 14; i++)
		   System.out.println(alg.smallestDistancePair(nums, i));

	}

}
