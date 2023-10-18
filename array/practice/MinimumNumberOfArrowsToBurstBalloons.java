package com.array.practice;

import java.util.Arrays;
import java.util.Stack;

public class MinimumNumberOfArrowsToBurstBalloons {

	public int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (o1, o2) -> Integer.compare(o1[1],o2[1]));
		Stack<int[]> stack = new Stack<>();
		stack.push(points[0]);
		for (int i = 1; i < points.length; i++) {
			int[] o1 = stack.pop();
			int[] o2 = points[i];
			if (o1[1] >= o2[0]) {
				int[] o = new int[] { o1[0], Math.min(o1[1], o2[1]) };
				stack.push(o);
			} else {
				stack.push(o1);
				stack.push(o2);
			}
		}
		return stack.size();
	}
	
	public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int arrow = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > end){
                 arrow++;
                 end = points[i][1];
            }
        }
        return arrow;
    }

	public static void main(String[] args) {
		MinimumNumberOfArrowsToBurstBalloons algo = new MinimumNumberOfArrowsToBurstBalloons();
		System.out.println(algo.findMinArrowShots(new int[][] { { -10, -16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }));
		System.out.println(algo.findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }));
		int[][] points = { { -2147483646, -2147483645 }, { 2147483646, 2147483647 } };
		System.out.println(algo.findMinArrowShots(points));
		System.out.println(algo.findMinArrowShots2(points));
	}
}
