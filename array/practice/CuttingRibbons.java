package com.array.practice;

public class CuttingRibbons {
	public static int maxLength(int[] ribbons, int k) {
		int maxRibbon = 0;
		for (int ribbon : ribbons)
			maxRibbon = Math.max(maxRibbon, ribbon);
		int low = 1, high = maxRibbon;
		while (low < high) {
			int mid = (high - low + 1) / 2 + low;
			int count = 0;
			for (int ribbon : ribbons)
				count += ribbon / mid;
			if (count >= k)
				low = mid;
			else
				high = mid - 1;
		}
		return low;
	}

//	public static void printArray(int[] arr) {
//		for (int e : arr) {
//			System.out.print(e + " ");
//		}
//	}

	public static void main(String[] args) {
		int[] ribbons = { 9, 7, 5 };
		int k = 3;
		System.out.print(maxLength(ribbons, k));

	}

}
