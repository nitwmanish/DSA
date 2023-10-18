package com.binary.search.practice;

public class AllocateMinimumNumberOfPages {
	public static boolean isPossible(int[] arr, int m, int mid) {
		int students = 1;
		int totalPages = 0;
		for (int i = 0; i < arr.length; i++) {
			totalPages = totalPages + arr[i];
			if (totalPages > mid) {
				students++;
				totalPages = arr[i];
			}
		}
		if (students > m) {
			return false;
		}
		return true;
	}

	public static int findPages(int[] arr, int m) {
		long sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		int start = max;
		int end = (int) sum;
		int result = Integer.MAX_VALUE;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (isPossible(arr, m, mid)) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 12, 34, 67, 90 };
		int m = 2;
		System.out.println("Minimum number of pages = " + findPages(arr, m));
	}
}
