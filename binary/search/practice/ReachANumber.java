package com.binary.search.practice;

public class ReachANumber {

	public int reachNumber(int target) {
		target = Math.abs(target);
		if (target == 0) {
			return 0;
		}
		int low = 1;
		int high = target;
		long finalPosition = 0;
		int minMoves = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			long num = (long) mid * (mid + 1) / 2;
			if (num >= target) {
				finalPosition = num;
				minMoves = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		int diff = (int) (finalPosition - target);
		if (diff % 2 != 0) {
			if (minMoves % 2 != 0) {
				minMoves += 2;
			} else {
				minMoves += 1;
			}
		}
		return minMoves;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
