package com.array.practice;

public class MergeSortedSubarrays {
	public static void solve(int[] arr, int endIndex) {
		int[] temp = new int[arr.length - endIndex - 1];
		for (int i = endIndex + 1, j = 0; i < arr.length; i++, j++) {
			temp[j] = arr[i];
		}
		int j = endIndex;
		int i = arr.length - 1;
		while (j >= 0) {
			arr[i] = arr[j];
			i--;
			j--;
		}
		int k = 0;
		j = 0;
		i = i + 1;
		while (k < arr.length && j < temp.length && i < arr.length) {
			if (temp[j] < arr[i]) {
				arr[k++] = temp[j++];
			} else if (arr[i] < temp[j]) {
				arr[k++] = arr[i++];
			} else {
				arr[k++] = temp[j++];
				arr[k++] = arr[i++];
			}
		}
		while (k < arr.length && i < arr.length) {
			arr[k++] = arr[i++];
		}
		while (k < arr.length && j < temp.length) {
			arr[k++] = temp[j++];
		}
	}

	public static void main(String args[]) {
		int[] arr = new int[] { 1, 3, 5, 7, 9, 11, 0, 4, 6, 8 };
		solve(arr, 5);
		for (int ele : arr) {
			System.out.print(ele + " ");
		}

	}
}
