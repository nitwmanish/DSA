package com.backtracking.practice;

public class FindNumberOfSubsequenceSumEqualToK {

	public void subSequenceSum(int nums[], int index, int k, int sum, int[] ans) {
		if (index == nums.length || sum > k) {
			return;
		}
		if (sum == k) {
			ans[0]++;
			return;
		}
		sum = sum + nums[index];
		subSequenceSum(nums, index + 1, k, sum, ans);
		sum = sum - nums[index];
		subSequenceSum(nums, index + 1, k, sum, ans);
	}

	public static void main(String args[]) {
		FindNumberOfSubsequenceSumEqualToK algo = new FindNumberOfSubsequenceSumEqualToK();
		int arr[] = { 5, 12, 3, 17, 1, 18, 15, 3, 17 };
		int k = 6;
		int[] ans = new int[1];
		algo.subSequenceSum(arr, 0, k, 0, ans);
		System.out.println(ans[0]);
	}

}
