package com.backtracking.practice;

public class ValidSudoku {
	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == c && i != col) {
				return false;
			}
			if (board[i][col] == c && i != row) {
				return false;
			}
		}
		int startRow = row - row % 3;
		int startCol = col - col % 3;
		for (int i = startRow; i < startRow + 3; i++) {
			for (int j = startCol; j < startCol + 3; j++) {
				if (board[i][j] == c && !(i == row && j == col)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!isValid(board, i, j, board[i][j]))
						return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku algo = new ValidSudoku();
		String[] A = { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.",
				"...419..5", "....8..79" };
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			board[i] = A[i].toCharArray();
		}
		System.out.print(algo.isValidSudoku(board));

	}
}
