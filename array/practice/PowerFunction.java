package com.array.practice;

public class PowerFunction {
	public static int pow(int A, int B, int C) {
		int ans = pow2(A, B, C);
		if(ans < 0) {
			ans = (C - Math.abs(ans)%C)%C;
		}
		return ans;
	}
	public static int pow2(int A, int B, int C) {
		if (A == 0) {
			return 0;
		}
		if (B == 0) {
			return 1;
		}
		if (B == 1) {
			return A % C;
		}
		long mul = A * A;
		int res = (int) mul % C;
		if (B % 2 == 0) {
			return pow(res, B / 2, C);
		} else {
			return (pow(res, (B - 1) / 2, C) * A) % C;
		}
	}

	public static void main(String[] args) {
//		System.out.println(71045970 % 64735492);
//		System.out.println(pow(71045970, 41535484, 64735492));

		System.out.println((71045970 % 64735492) * (71045970 % 64735492));

	}

}
