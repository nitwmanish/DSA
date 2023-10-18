package com.bit.manupulation;

public class FindTwoMissingElements {

	public static boolean checkBit(int N, int i) {
		boolean ans = false;
		if (((N >> i) & 1) == 1) {
			ans = true;
		}
		return ans;
	}


	public static int[] findTwoMissingElements(int[] nums) {
		int xor = 0;

		for (int j = 0; j < nums.length; j++) {
			xor = xor ^ nums[j];
		}
		for (int j = 1; j <= nums.length + 2; j++) {
			xor = xor ^ j;
		}
		int position = -1;
		for (int i = 0; i < 32; i++) {
			if (checkBit(xor, i)) {
				position = i;
				break;
			}
		}
		int set = 0;
		int unset = 0;
		for (int j = 0; j < nums.length; j++) {
			if (checkBit(nums[j], position)) {
				set = set ^ nums[j];
			} else {
				unset = unset ^ nums[j];
			}
		}
		int[] res = { set, unset };
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 6, 4, 7, 5 };
		int[] res = findTwoMissingElements(nums);
		System.out.print(res[0] + " " + res[1]);
	}
}
