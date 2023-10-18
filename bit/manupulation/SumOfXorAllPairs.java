package com.bit.manupulation;

public class SumOfXorAllPairs {
	public static boolean checkBit(int N, int i) {
		boolean ans = false;
		if (((N >> i) & 1) == 1) {
			ans = true;
		}
		return ans;
	}

	public static int sumOfXorAppPairs(int[] nums) {
		int sum = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (checkBit(nums[j], i)) {
					count++;
				}
			}
			int contribustion = count * (nums.length - count);
			contribustion = contribustion * (1 << i);
			sum +=  contribustion;
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] nums = { 3, 5, 6, 8, 2 };
		int res = sumOfXorAppPairs(nums);
		System.out.print(res);
	}
}
