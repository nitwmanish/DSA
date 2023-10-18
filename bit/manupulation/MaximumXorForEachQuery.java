package com.bit.manupulation;

public class MaximumXorForEachQuery {
	public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] res = new int[nums.length];
        int val = (1 << maximumBit) - 1;
        for (int i = 0; i < nums.length; ++i){
            val ^= nums[i];
            res[nums.length - i - 1] = val;
        }
        return res;
    }
	public static void main(String[] args) {
		MaximumXorForEachQuery algo = new MaximumXorForEachQuery();
		int[] nums = {2,3,4,7};
		int maximumBit = 3;
		int[] ans = algo.getMaximumXor(nums, maximumBit);
		for(int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+ " ");
		}

	}

}
