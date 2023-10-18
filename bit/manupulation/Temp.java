package com.bit.manupulation;

public class Temp {

	public static int divide(int A, int B) {
		long n = A;
		long m = B;
		int sign = 1;
		if (n < 0) {
			sign = -sign;
		}
		if (m < 0) {
			sign = -sign;
		}
		n = Math.abs(n);
		m = Math.abs(m);
		long q = 0;
		for (int i = 31; i >= 0; i--) {
			if ((m << i) <= n) {
				n -= (m << i);
				long one = 1;
				q += one << i;
			}
		}
		if (sign < 0) {
			q = -q;
		}
		if (q > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else
			return (int) q;
	}

	public static void main(String[] args) {
		int A = -2147483648;
		int B = 1;
		System.out.print(divide(A, B));
	}
}
