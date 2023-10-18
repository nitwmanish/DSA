package com.array.practice;

public class SquareRootOfInteger {
	public int binarySearch(int A) {
		int low = 1;
		int hi = A;
		int ans = 0;
		while (low < hi) {
			int mid = (hi - low) / 2 + low;
			long sqrt = mid * mid;
			if (sqrt < A) {
				ans = mid;
				low = mid + 1;
			} else if (sqrt > A) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return ans;
	}

	public int sqrt(int A) {
		return binarySearch(A);
		
	}

	public static void main(String[] args) {
//		StringBuilder sb = new StringBuilder();
		SquareRootOfInteger l = new SquareRootOfInteger();
		System.out.println(l.sqrt(2147483647));
	}
}
