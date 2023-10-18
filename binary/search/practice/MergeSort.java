package com.binary.search.practice;

public class MergeSort {

	private void mergeSort(int[] nums, int s, int e) {
		if (s == e) {
			return;
		}
		int mid = (s + e) / 2;
		mergeSort(nums, s, mid);
		mergeSort(nums, mid + 1, e);
		merge(nums, s, mid, e);
	}

	private void merge(int[] nums, int s, int mid, int e) {
		int[] temp = new int[e - s + 1];
		int p1 = s;
		int p2 = mid + 1;
		int p3 = 0;
		while (p1 <= mid && p2 <= e) {
			if (nums[p1] <= nums[p2]) {
				temp[p3] = nums[p1];
				p1++;
				p3++;
			} else {
				temp[p3] = nums[p2];
				p2++;
				p3++;
			}
		}
		while (p1 <= mid) {
			temp[p3] = nums[p1];
			p1++;
			p3++;
		}
		while (p2 <= e) {
			temp[p3] = nums[p2];
			p2++;
			p3++;
		}
		int j = s;
		for (int i = 0; i < temp.length; i++) {
			nums[j] = temp[i];
			j++;
		}
	}

	public static void main(String[] args) {
		MergeSort alg = new MergeSort();
		int[] nums = { 1, 2, 5, 2, 3 };
		alg.mergeSort(nums, 0, nums.length - 1);
		for (int ele : nums) {
			System.out.print(ele + "  ");
		}
	}
}
