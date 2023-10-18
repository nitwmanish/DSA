package com.binary.search.practice;

public class BitonicSearch {
	public static int findMaximum(int[] arr) {

		int low = 0, high = arr.length - 1;
		while (low <= high) {
			if (low == high) {
				return arr[low];
			}
			int mid = low + (high - low) / 2;
			if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
				return arr[mid];
			}
			if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 50, 10, 9, 7, 6 };
		System.out.println("The maximum element is " + findMaximum(arr));

	}

}
