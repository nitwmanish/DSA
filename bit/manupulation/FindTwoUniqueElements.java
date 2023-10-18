package com.bit.manupulation;

public class FindTwoUniqueElements {

	public static boolean checkBit(int N, int i) {
		boolean ans = false;
		if (((N >> i) & 1) == 1) {
			ans = true;
		}
		return ans;
	}

	public static int[] findTwoUniqueElements(int[] nums) {
		int xor = 0;

		for (int j = 0; j < nums.length; j++) {
			xor = xor ^ nums[j];
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
		int[] nums = { 10, 8, 8, 9, 12, 9, 10, 17, 11, 12 };
		int[] res = findTwoUniqueElements(nums);
		System.out.print(res[0] + " " + res[1]);
	}
}
