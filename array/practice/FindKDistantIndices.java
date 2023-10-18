package com.array.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindKDistantIndices {
	public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List<Integer> result = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == key) {
				set.add(i);
			}
		}
		for (int i = 0; i < nums.length; i++) {
			boolean flag = false;
			if (nums[i] == key) {
				result.add(i);
				continue;
			}
			for (int j : set) {
				if (Math.abs(j - i) <= k) {
					flag = true;
					break;
				}
			}
			if (flag) {
				result.add(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, 9, 1, 3, 9, 5 };
		System.out.print(findKDistantIndices(nums, 9, 1));

	}

}
