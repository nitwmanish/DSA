package com.binary.tree.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	class Pair {
		public int row;
		public int col;

		public Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public boolean equals(Object object) {
			if (object instanceof Pair) {
				Pair pair = (Pair) object;
				return pair.row == row && pair.col == col;
			}
			return false;
		}

		public int hashCode() {
			return new Integer(row).hashCode() * 31 + new Integer(col).hashCode();
		}
	}

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int ROWS = heights.length;
		int COLS = heights[0].length;
		Set<Pair> pac = new HashSet<>();
		Set<Pair> atl = new HashSet<Pair>();
		for (int col = 0; col < COLS; col++) {
			dfs(0, col, pac, heights, heights[0][col]);
			dfs(ROWS - 1, col, atl, heights, heights[ROWS - 1][col]);
		}
		for (int row = 0; row < ROWS; row++) {
			dfs(row, 0, pac, heights, heights[row][0]);
			dfs(row, COLS - 1, atl, heights, heights[row][COLS - 1]);
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (pac.contains(new Pair(row, col)) && atl.contains(new Pair(row, col))) {
					List<Integer> pair = new ArrayList<>();
					pair.add(row);
					pair.add(col);
					result.add(pair);
				}
			}
		}
		return result;
	}

	public void dfs(int row, int col, Set<Pair> visited, int[][] heights, int preHeight) {
		if (visited.contains(new Pair(row, col)) || row < 0 || col < 0 || row == heights.length
				|| col == heights[0].length || heights[row][col] < preHeight) {
			return;
		}
		visited.add(new Pair(row, col));
		dfs(row - 1, col, visited, heights, heights[row][col]);
		dfs(row + 1, col, visited, heights, heights[row][col]);
		dfs(row, col - 1, visited, heights, heights[row][col]);
		dfs(row, col + 1, visited, heights, heights[row][col]);
	}

	public static void main(String args[]) {
		Main m = new Main();
		int[][] heights = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		System.out.println(m.pacificAtlantic(heights));
	}
}
