package com.backtracking.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllPermutation {

	public void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void findAllPermutation(int nums[], int index, List<ArrayList<Integer>> ans) {
		if (index == nums.length) {
			List<Integer> ds = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				ds.add(nums[i]);
			}
			ans.add(new ArrayList<>(ds));
			return;
		}
		for (int i = index; i < nums.length; i++) {
			swap(nums, i, index);
			findAllPermutation(nums, index + 1, ans);
			swap(nums, i, index);
		}

	}

	public void findAllPermutation(int nums[], Set<Integer> hs, List<Integer> ds, List<ArrayList<Integer>> ans) {
		if (hs.size() == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!hs.contains(nums[i])) {
				ds.add(nums[i]);
				hs.add(nums[i]);
				findAllPermutation(nums, hs, ds, ans);
				hs.remove(nums[i]);
				ds.remove(ds.size() - 1);
			}

		}

	}

	public static void main(String[] args) {
		FindAllPermutation algo = new FindAllPermutation();
		int arr[] = { 1, 2, 3 };
		List<ArrayList<Integer>> ans = new ArrayList<>();
		algo.findAllPermutation(arr, 0, ans);
		for (List<Integer> subset : ans) {
			System.out.println(subset);
		}
		System.out.println("---------");
		ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		algo.findAllPermutation(arr, set, ds, ans);
		for (List<Integer> subset : ans) {
			System.out.println(subset);
		}

	}

}
