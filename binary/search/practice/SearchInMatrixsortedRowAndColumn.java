package com.binary.search.practice;

public class SearchInMatrixsortedRowAndColumn {
	public static boolean search(int[][] mat, int x) {
		int i = 0;
		int j = mat.length - 1;
		while (i < mat.length && j >= 0) {
			if (mat[i][j] == x) {
				return true;
			}
			if (mat[i][j] > x)
				j--;
			else
				i++;
		}
		return false;
	}

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println(search(mat, 29));
		System.out.println(search(mat, 200));
	}
}
