package com.binary.search.practice;

public class FairCandySwap {
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

	private int binarySearch(int[] nums, int k) {
		int start = 0;
		int end = nums.length - 1;
		int ans = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == k) {
				ans = mid;
				break;
			}
			if (nums[mid] < k) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return ans;
	}

	public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
		int aliceSum = 0;
		for (int ele : aliceSizes) {
			aliceSum = aliceSum + ele;
		}
		int bobSum = 0;
		for (int ele : bobSizes) {
			bobSum = bobSum + ele;
		}
		int deff = (aliceSum - bobSum) / 2;
		mergeSort(bobSizes, 0, bobSizes.length - 1);
		int[] ans = new int[2];
		for (int ele : aliceSizes) {
			int index = binarySearch(bobSizes, ele - deff);
			if (index != -1) {
				ans[0] = ele;
				ans[1] = bobSizes[index];
				break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		FairCandySwap alg = new FairCandySwap();
		int[] aliceSizes = { 35,17,4,24,10 };
		int[] bobSizes = { 63,21 };
		int[] ans = alg.fairCandySwap(aliceSizes, bobSizes);
		for (int ele : ans) {
			System.out.print(ele + "  ");
		}
	}
}
