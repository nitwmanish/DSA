package com.array.practice;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	public int maxPoints(int[][] points) {
		int n = points.length;
		if (n == 1) {
			return 1;
		}
		int max = 2;
		for (int i = 0; i < n - 1; i++) {
			Map<Double, Integer> tangentMap = new HashMap<>();
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				int[] p1 = points[i];
				int[] p2 = points[j];
				int x1 = p1[0];
				int y1 = p1[1];
				int x2 = p2[0];
				int y2 = p2[1];
				double tangent = Math.atan2((y2 - y1), (x2 - x1));
				tangentMap.put(tangent, tangentMap.getOrDefault(tangent, 0) + 1);
			}
			Collection<Integer> collection = tangentMap.values();
			if (!collection.isEmpty()) {
				max = Math.max(max, Collections.max(collection) + 1);
			}

		}
		return max;
	}

	public static void main(String[] args) {
		MaxPointsOnALine algo = new MaxPointsOnALine();

		int[][] points = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
		System.out.println(algo.maxPoints(points));

	}

}
