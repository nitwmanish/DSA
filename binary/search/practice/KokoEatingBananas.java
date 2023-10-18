package com.binary.search.practice;

public class KokoEatingBananas {
	private boolean canEatAll(int[] piles, int h, int k) {
		long  countHour = 0; // Hours take to eat all bananas at speed K.
		for (int pile : piles) {
			countHour += pile / k;
			if (pile % k != 0) {
				countHour++;
			}
		}
		return countHour <= h;
	}

	public int minEatingSpeed(int[] piles, int h) {
		int start = 1;
		int end = Integer.MIN_VALUE;
		for (int ele : piles) {
			end = Math.max(end, ele);
		}
		int ans = 0;
		while (start <= end) {
			int k = start + (end - start) / 2;
			boolean isPossible = canEatAll(piles, h, k);
			if (isPossible) {
				ans = k;
				end = k - 1;
			} else {
				start = k + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		KokoEatingBananas alg = new KokoEatingBananas();
		int[] nums = { 805306368,805306368,805306368 };
		System.out.print(alg.minEatingSpeed(nums, 1000000000));
		
	}

}
