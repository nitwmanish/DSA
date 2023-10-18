package com.binary.search.practice;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
	public static class Tuple implements Comparable<Tuple> {
		private int row;
		private int col;
		private int val;

		public Tuple(int row, int col, int val) {
			this.row = row;
			this.col = col;
			this.val = val;
		}

		@Override
		public int compareTo(Tuple that) {
			return this.val - that.val;
		}
	}

	/*
	 * build a min Heap from the first column, and do the similar operations as
	 * above. (Replace the root with the next element from the same row
	 */
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		for (int col = 0; col < n; col++) {
			pq.offer(new Tuple(0, col, matrix[0][col]));
		}
		for (int i = 0; i < k - 1; i++) {
			Tuple tuple = pq.poll();
			if (tuple.row == n - 1) {
				continue;
			}
			pq.offer(new Tuple(tuple.row + 1, tuple.col, matrix[tuple.row + 1][tuple.col]));
		}
		return pq.poll().val;
	}

	/*
	 * The maxHeap will keep up to k smallest elements (because when maxHeap is over
	 * size of k, we do remove the top of maxHeap which is the largest one).
	 * Finally, the top of the maxHeap is the kth smallest element in the matrix.
	 */
	public int kthSmallest1(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1, o2) -> Integer.compare(o2, o1));
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				maxHeap.offer(matrix[row][col]);
				if (maxHeap.size() > k) {
					maxHeap.poll();
				}
			}
		}
		return maxHeap.poll();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
