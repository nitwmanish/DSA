package com.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MaximumUnsortedSubarray {
	public ArrayList<Integer> solved(int[] nums) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int n = nums.length;
		int i = 0;
		int j = n - 1;

		while (i < n - 1 && nums[i] <= nums[i + 1])
			i++;

		while (j > 0 && nums[j] >= nums[j - 1])
			j--;

		if (i == n - 1) {
			ans.add(-1);
			return ans;
		}

		int max = nums[i + 1];
		int min = nums[i + 1];
		for (int k = i; k <= j; k++) {
			max = Math.max(nums[k], max);
			min = Math.min(nums[k], min);
		}
		int left = 0;
		int right = n - 1;

		while (left <= i && nums[left] <= min)
			left++;

		while (right >= j && nums[right] >= max)
			right--;

		ans.add(left);
		ans.add(right);
		return ans;
	}

	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
		int[] nums = new int[A.size()];
		for (int i = 0; i < A.size(); i++) {
			nums[i] = A.get(i);
		}
		return solved(nums);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 3, 3, 5, 6, 6, 14, 17, 18, 17, 18, 15, 15, 17, 19, 14, 19, 18 };
		MaximumUnsortedSubarray ll = new MaximumUnsortedSubarray();
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
		System.out.println(ll.subUnsort(list));

	}

}
