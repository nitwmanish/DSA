package com.backtracking.practice;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubset {

	public void findAllSubset(int nums[], int index, List<Integer> ds, List<ArrayList<Integer>> ans) {
		if (index == nums.length) {
			ans.add(new ArrayList<>(ds));
			return;
		}
		ds.add(nums[index]);
		findAllSubset(nums, index + 1, ds, ans);
		ds.remove(ds.size() - 1);
		findAllSubset(nums, index + 1, ds, ans);
	}

	public static void main(String[] args) {
		FindAllSubset algo = new FindAllSubset();
		int arr[] = { 1, 2, 3 };
		List<Integer> ds = new ArrayList<>();
		List<ArrayList<Integer>> ans = new ArrayList<>();
		algo.findAllSubset(arr, 0, ds, ans);
		for (List<Integer> subset : ans) {
			System.out.println(subset);
		}
	}

}
