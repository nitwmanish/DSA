package com.array.practice;

public class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1;
		int j = m + n - 1;
		while (i >= 0) {
			nums1[j] = nums1[i];
			j--;
			i--;
		}
		j++;
		int k = 0;
		i = 0;
		while (k < n && j < m + n) {
			if (nums1[j] < nums2[k]) {
				nums1[i] = nums1[j];
				j++;
			} else {
				nums1[i] = nums2[k];
				k++;
			}
			i++;
		}
		while (k < n) {
			nums1[i] = nums2[k];
			k++;
			i++;
		}
		while (j < m) {
			nums1[i] = nums1[j];
			j++;
			i++;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		merge(nums1, m, nums2, n);
		for (int ele : nums1) {
			System.out.print(ele + " ");
		}

	}

}
