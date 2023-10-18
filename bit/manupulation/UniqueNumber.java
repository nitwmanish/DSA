package com.bit.manupulation;

public class UniqueNumber {

	public static boolean checkBit(int N, int i) {
		boolean ans = false;
		if (((N >> i) & 1) == 1) {
			ans = true;
		}
		return ans;
	}

	public int countBit(int N) {
		int ans = 0;
		while (N > 0) {
			if ((N & 1) == 1) {
				ans++;
			}
		}
		return ans;
	}

	public static int findUniqElement(int[] nums) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				if (checkBit(nums[j], i)) {
					count++;
				}
			}
			if (count % 3 == 1) {
				ans += 1 << i;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 5, 4, 7, 11, 11, 9, 11, 7, 5, 4, 4 };
		System.out.print(findUniqElement(nums));
	}
}
