package com.binary.search.practice;

public class PeakIndex {

	private int binarySearch(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int ans = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if ((mid - 1 >= 0 && nums[mid] > nums[mid - 1]) && (mid + 1 < nums.length && nums[mid] > nums[mid + 1])) {
				ans = mid;
				break;
			}
			if (mid - 1 > 0 && nums[mid] > nums[mid - 1]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	public int peakIndexInMountainArray(int[] arr) {
		return binarySearch(arr);
	}

	public static void main(String[] args) {
		PeakIndex alg = new PeakIndex();
		int[] nums = { 0, 1, 0 };
		System.out.print(alg.peakIndexInMountainArray(nums));
	}
}
