package com.bit.manupulation;

public class ReverseBits {

	public static long reverse(long a) {
		// 3 steps need to be followed
		// ************************************
		// Loop for each of the 32 bit
		// left shift result (multiply by 2)
		// If bit in n is set then do same in result (add 1)
		// right shift n (divide by 2)
		// ************************************/
		long sum = 0;
		for (int i = 0; i < 32; i++) {
			sum = sum << 1;
			if ((a & 1) == 1) {
				sum = sum | (a & 1); // setting the bit in the result if the bit is 1
			}
			a = a >> 1;
		}
		return sum;

	}

	public static int reverseBits(int n) {
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result += n & 1;
	        n >>>= 1;   // CATCH: must do unsigned shift
	        if (i < 31) // CATCH: for last digit, don't shift!
	            result <<= 1;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		int res = reverseBits(3);
		System.out.print(res);
	}

}
