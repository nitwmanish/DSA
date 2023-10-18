package com.backtracking2.practice;

import java.util.ArrayList;

public class Subsets {

	public static void backtracking(int[] nums, int index, ArrayList<Integer> ds, ArrayList<ArrayList<Integer>> ans) {
		if (index == nums.length) {
			return;
		}
		ds.add(nums[index]);
		ans.add(new ArrayList<Integer>(ds));
		backtracking(nums, index + 1, ds, ans);// take it
		ds.remove(ds.size() - 1);
		backtracking(nums, index + 1, ds, ans);// leave it
	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		int[] nums = A.stream().mapToInt(num -> num).toArray();
		ArrayList<Integer> ds = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		backtracking(nums, 0, ds, ans);
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(2);
		A.add(4);
		System.out.print(subsets(A));
	}

}
