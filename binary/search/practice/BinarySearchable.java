package com.binary.search.practice;

public class BinarySearchable {

//	static int countBinarySearchable(int nums[], int low, int high, int min, int max) {
//		if (low > high) {
//			return 0;
//		}
//		int ans = 0;
//		int mid = (low + high) / 2;
//		if (min < nums[mid] && nums[mid] < max) {
//			ans = 1;
//		}
//		int leftAns = countBinarySearchable(nums, low, mid - 1, min, Math.min(max, nums[mid]));
//		int rightAns = countBinarySearchable(nums, mid + 1, high, Math.max(min, nums[mid]), max);
//		return ans + leftAns + rightAns;
//	}

	static int binarySearchable(int[] nums, int n) {

		int[] leftMax = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			leftMax[i] = max;
			max = Math.max(max, nums[i]);
		}
		int[] rightMin = new int[n];
		int min = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			rightMin[i] = min;
			min = Math.min(min, nums[i]);
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (leftMax[i] < nums[i] && nums[i] < rightMin[i]) {
				count++;
			}
		}
		return count;
	}

	public static void solve(int A) {
		int[] dp = new int[A + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= A; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
		System.out.print(dp[A]);
	}

	public static void main(String[] args) {

		int nums[] = { 1, 3, 2, 4, 5, 7, 6, 8 };
		System.out.println(binarySearchable(nums, nums.length));

	}

}
