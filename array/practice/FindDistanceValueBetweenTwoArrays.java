package com.array.practice;

import java.util.Arrays;

public class FindDistanceValueBetweenTwoArrays {
	private boolean foundWithinDistanceD(int[] arr2, int num, int d) {
		int low = 0;
		int high = arr2.length - 1;
		while (low <= high) {
			var mid = (low + high) / 2;
			if (Math.abs(num - arr2[mid]) <= d) {
				return true;
			} else if (num < arr2[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		Arrays.sort(arr2);
		int result = 0;
		for (int num : arr1) {
			result += foundWithinDistanceD(arr2, num, d) ? 0 : 1;
		}
		return result;
	}

	public static void main(String[] args) {
		FindDistanceValueBetweenTwoArrays alg = new FindDistanceValueBetweenTwoArrays();
		int[] arr1 = { 4, 5, 8 };
		int[] arr2 = { 10, 9, 1, 8 };
		int d = 2;
		System.out.print(alg.findTheDistanceValue(arr1, arr2, d));

	}

}
