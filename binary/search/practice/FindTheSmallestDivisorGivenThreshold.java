package com.binary.search.practice;

public class FindTheSmallestDivisorGivenThreshold {
	private boolean isValid(int[] nums, int threshold, int uperLimit) {
		long res = 0;
		for (int n : nums) {
			res += n / uperLimit + (n % uperLimit == 0 ? 0 : 1);
		}
		return res <= threshold;
	}

	public int smallestDivisor(int[] nums, int threshold) {
		int start = 1;
		int end = Integer.MIN_VALUE;
		for (int ele : nums) {
			end = Math.max(end, ele);
		}
		while (start < end) {
			int mid = start + (end - start) / 2;
			boolean posible = isValid(nums, threshold, mid);
			if (posible) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
//	public int smallestDivisor(int[] nums, int threshold) {
//        int l = 1, r = getMax(nums);
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            if (getDiv(nums, mid) <= threshold) r = mid;
//            else l = mid + 1;
//        }
//        return l;
//    }

	private int getMax(int[] nums) {
		int res = 1;
		for (int n : nums)
			res = Math.max(res, n);
		return res;
	}

	private long getDiv(int[] nums, int d) {
		long res = 0;
		for (int n : nums) {
			res += n / d + (n % d == 0 ? 0 : 1);
		}
		return res;
	}

	public static void main(String[] args) {
		FindTheSmallestDivisorGivenThreshold alg = new FindTheSmallestDivisorGivenThreshold();
		int[] nums = { 1, 2, 5, 9 };
		System.out.print(alg.smallestDivisor(nums, 6));

	}
}
