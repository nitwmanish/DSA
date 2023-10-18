package com.binary.tree.practice;

import java.util.TreeMap;

public class SummaryRanges {
	private TreeMap<Integer, Integer> treeMap;

	public SummaryRanges() {
		this.treeMap = new TreeMap<>();
	}

	public void addNum(int value) {
		if (treeMap.containsKey(value)) {
			return;
		}
		Integer lowerKey = this.treeMap.lowerKey(value); // lower interval start
		Integer higherKey = this.treeMap.higherKey(value); // higher interval start
		// merge three intervals like [[1,1],[3,3]] and [2,2] for val =2, so [1,3]
		// for lower we need to check end, for higher we need to check start
		if (lowerKey != null && higherKey != null && value == this.treeMap.get(lowerKey) + 1
				&& value == higherKey - 1) {
			this.treeMap.put(lowerKey, this.treeMap.get(higherKey));
			this.treeMap.remove(higherKey);
		}
		// merge lower and this interval, we can only merge [1,1] and[2,2], not [1,1]
		// and [3,3], end of lower should be greater than start of next to merge
		else if (lowerKey != null && value <= this.treeMap.get(lowerKey) + 1) {
			this.treeMap.put(lowerKey, Math.max(value, this.treeMap.get(lowerKey)));
		}
		// merge higher and this interval[1,3],[7,7] and [6,6], merge higher , so
		// [1,3],[6,7]
		else if (higherKey != null && value == higherKey - 1) {
			this.treeMap.put(value, this.treeMap.get(higherKey));
			this.treeMap.remove(higherKey);
		} else {
			this.treeMap.put(value, value);
		}
	}

	public int[][] getIntervals() {
		int[][] ans = new int[this.treeMap.size()][2];
		int i = 0;
		for (int a : this.treeMap.keySet()) {
			ans[i++] = new int[] { a, this.treeMap.get(a) };
		}
		return ans;
	}
}
