package com.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class PairsWithGivenSumII {
	public int solve(ArrayList<Integer> A, int B) {
		int mod = 1000 * 1000 * 1000 + 7;
		int start = 0;
		int end = A.size() - 1;
		int ans = 0;
		while (start < end) {
			int sum = A.get(start) + A.get(end);
			if (sum < B) {
				start++;
			} else if (sum > B) {
				end--;
			} else if (A.get(start) == A.get(end)) {
				int count = end - start + 1;
				ans = ans + count * (count - 1) / 2;
				break;
			} else if (A.get(start) != A.get(end)) {
				int x = A.get(start); 
				int y = A.get(end);
				int countStart = 0;
				int countEnd = 0;
				while (start < A.size() && A.get(start) == x) { // if there is left duplicate value
					start++;
					countStart++;
				}
				while (end > 0 && A.get(end) == y) { // if there is right duplicate value
					end--;
					countEnd++;
				}
				ans = (ans % mod) + ((countEnd * countStart) % mod) % mod;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
				4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
				4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
				4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
				4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
				4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
				4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666,
				4629666, 4629666, 4629666, 4629666, 4629666, 4629666, 4629666 };
		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
		PairsWithGivenSumII l = new PairsWithGivenSumII();
		System.out.println(l.solve(list, 9259332));
	}
}
