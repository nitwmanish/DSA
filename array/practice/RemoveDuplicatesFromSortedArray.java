package com.array.practice;

public class RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[res] = nums[i];
				res++;
			}
		}
		nums[res] = nums[nums.length - 1];
		res++;
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int k = removeDuplicates(nums);
		for (int i = 0; i < k; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
