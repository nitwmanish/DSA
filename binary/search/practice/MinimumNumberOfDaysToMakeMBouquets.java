package com.binary.search.practice;

public class MinimumNumberOfDaysToMakeMBouquets {
	private boolean isPossible(int[] bloomDay, int m, int k, int days) {
		int count_continuous = 0;
		int count_flower = 0;
		for (int ele : bloomDay) {
			if (ele <= days) {
				// If the current flower can be taken with in days then increase the flower
				// flowersCollected.
				count_continuous++;
				if (count_continuous >= k) {
					// If the flowersCollected is same as the required flower per bookie, then
					// increase the bouquets count;
					count_continuous = 0;
					count_flower++;
				}
			} else {
				// If there is a flower in between that takes more number of days then the given
				// day, then resent the counter.
				count_continuous = 0;
			}
		}

		return count_flower >= m;

	}

	public int minDays(int[] bloomDay, int m, int k) {
		int start = 1;
		int end = Integer.MIN_VALUE;
		for (int ele : bloomDay) {
			start = Math.min(end, ele);
			end = Math.max(end, ele);
		}
		int ans = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (isPossible(bloomDay, m, k, mid)) {
				ans = mid;
				end = mid - 1;
			} else {

				start = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
