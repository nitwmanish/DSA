package com.binary.search.practice;

public class MinimumTimeToCompleteTrips {

	private long check(int[] time, long mid) {
		long totalTrips = 0;
		for (int x : time) {
			long val = (long) x;
			totalTrips += (mid / val);
		}
		return totalTrips;
	}

	public long minimumTime(int[] time, int totalTrips) {
		long start = 0;
		long end = 100000000000001L;
		;
		while (start < end) {
			long mid = start + (end - start) / 2;
			if (check(time, mid) >= totalTrips) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		MinimumTimeToCompleteTrips algo = new MinimumTimeToCompleteTrips();
		int[] time = { 39, 82, 69, 37, 78, 14, 93, 36, 66, 61, 13, 58, 57, 12, 70, 14, 67, 75, 91, 1, 34, 68, 73, 50,
				13, 40, 81, 21, 79, 12, 35, 18, 71, 43, 5, 50, 37, 16, 15, 6, 61, 7, 87, 43, 27, 62, 95, 45, 82, 100,
				15, 74, 33, 95, 38, 88, 91, 47, 22, 82, 51, 19, 10, 24, 87, 38, 5, 91, 10, 36, 56, 86, 48, 92, 10, 26,
				63, 2, 50, 88, 9, 83, 20, 42, 59, 55, 8, 15, 48, 25 };
		int totalTrips = 4187;
		System.out.println(algo.minimumTime(time, totalTrips));
	}
}
