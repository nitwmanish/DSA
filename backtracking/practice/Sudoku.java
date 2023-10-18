package com.backtracking.practice;

public class Sudoku {

	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == c)
				return false;
			if (board[row][i] == c)
				return false;
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
				return false;
		}
		return true;
	}

	public boolean sudoku(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, row, col, c)) {
							board[row][col] = c;
							if (sudoku(board)) {
								return true;
							} else {
								board[row][col] = '.';
							}
						}
					}
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Sudoku algo = new Sudoku();
		String[] A = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.",
				"...419..5", "....8..79" };
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			board[i] = A[i].toCharArray();
		}
		System.out.println(algo.sudoku(board));
		for (int i = 0; i < 9; i++) {
			System.out.println(new String(board[i]));
		}
	}

}
