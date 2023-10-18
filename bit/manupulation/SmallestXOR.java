package com.bit.manupulation;

public class SmallestXOR {
	public static boolean checkBit(int N, int i) {
		boolean ans = false;
		if (((N >> i) & 1) == 1) {
			ans = true;
		}
		return ans;
	}

	public static int solve(int A, int B) {
		if (B == 0) {
			return A ^ A;
		}
		int ans = 0; // initial value

		/*
		 * traversing the bits of A from LSB if number of bits in A is equal to B , then
		 * answer will be A. A^A=0 gives minimum so initial loop to match setbits of A
		 * to answer. then second loop if B is greater than setbits in A. in that case
		 * adding setbits from RSB
		 */

		for (int i = 31; i >= 0; --i) {
			if (B == 0) {
				return ans;
			}
			if (checkBit(A, i)) {
				ans += (1 << i);
				--B;
			}
		}
		/*
		 * second loop , checking unset bit from RSB and changeing it to setbit since B
		 * is greater than setbits in A
		 */
		for (int i = 0; i <= 31; ++i) {
			if (B == 0) {
				return ans;
			}
			if (!checkBit(ans, i)) {
				ans += (1 << i);
				--B;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int res = solve(3, 3);
		System.out.print(res);
	}
}
