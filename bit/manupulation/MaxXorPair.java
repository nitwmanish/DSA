package com.bit.manupulation;

public class MaxXorPair {
	public static boolean checkBit(int N, int i) {
		boolean ans = false;
		if (((N >> i) & 1) == 1) {
			ans = true;
		}
		return ans;
	}

	public static int maxXorPair(int[] nums) {
		int ans = 0;
		for (int i = 30; i >= 0; i--) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (checkBit(nums[j], i)) {
					count++;
				}
			}
			if (count >= 2) {
				ans = ans + (1 << i);
				for(int j = 0; j < nums.length; j++) {
					if (!checkBit(nums[j], i)) {
						nums[j] = 0;
					}
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 26, 13, 23, 28, 27, 7, 25 };
		int res = maxXorPair(nums);
		System.out.print(res);
	}
}
