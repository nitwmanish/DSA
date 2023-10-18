package com.backtracking.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
	private Set<Integer> HRS = new HashSet<>();// HashSet for horizontal row
	private Set<Integer> HSLL = new HashSet<>();// HashSet for lower left diagonal row
	private Set<Integer> HSUL = new HashSet<>();// HashSet for upper left diagonal row

	private void nQueens(int n, int col, List<Integer> ds, List<ArrayList<String>> ans) {
		if (col == n) {
			ArrayList<String> tempList = new ArrayList<>();
			for (int row : ds) {
				char[] arr = new char[n];
				Arrays.fill(arr, '.');
				arr[row] = 'Q';
				tempList.add(new String(arr));
			}
			ans.add(tempList);
			return;
		}

		for (int row = 0; row < n; row++) {
			if (HRS.contains(row) || HSLL.contains(row + col) || HSUL.contains(row - col)) {
				continue;
			}
			// do
			ds.add(row);
			HRS.add(row);// HashSet for horizontal row
			HSLL.add(row + col);// HashSet for lower left diagonal row
			HSUL.add(row - col);// HashSet for upper left diagonal row

			// call
			nQueens(n, col + 1, ds, ans);

			// undo
			ds.remove(ds.size() - 1);
			HRS.remove(row);
			HSLL.remove(row + col);
			HSUL.remove(row - col);

		}
	}

	public List<ArrayList<String>> solveNQueens(int n) {
		List<ArrayList<String>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		nQueens(n, 0, list, ans);
		return ans;
	}

	public static void main(String[] args) {
		NQueens algo = new NQueens();
		System.out.print(algo.solveNQueens(4));

	}

}
