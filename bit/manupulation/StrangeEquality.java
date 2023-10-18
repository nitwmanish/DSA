package com.bit.manupulation;

public class StrangeEquality {

	public static boolean checkBit(int N, int i) {
		boolean ans = false;
		if (((N >> i) & 1) == 1) {
			ans = true;
		}
		return ans;
	}

	public static int solve(int A) {
		int position = -1;
		for (int i = 30; i >= 0; i--) {
			if (checkBit(A, i)) {
				position = i;
				break;
			}
		}
		int y = 1 << (position + 1);
		int x = 0;
		for (int i = position; i >=0 ; i--) {
			if (!checkBit(A, i)) {
				x += 1 << i;
			}
		}
		return x ^ y;
	}

	public static void main(String[] args) {
		int res = solve(1);
		System.out.print(res);
	}
}
