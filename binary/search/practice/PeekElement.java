package com.binary.search.practice;

public class PeekElement {
	public static int findPeak(int arr[]) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && mid < high) {
				if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
					return mid;
				} else if (arr[mid - 1] > arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (mid == 0) {
				if (arr[0] > arr[1]) {
					return 0;
				} else {
					return 0;
				}
			} else if (mid == high) {
				if (arr[arr.length - 1] > arr[arr.length - 2]) {
					return arr.length - 1;
				} else {
					return arr.length - 2;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 20, 4, 1, 0 };
		System.out.println("Index of a peak point is " + findPeak(arr));

	}

}
