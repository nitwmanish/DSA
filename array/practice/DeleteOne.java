package com.array.practice;

import java.util.ArrayList;

public class DeleteOne {
	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	 public static int solve1(ArrayList<Integer> A) {
	        int[]preGcd = new int[A.size()];
	        int[]postGcd = new int[A.size()];
	        preGcd[0] = A.get(0);
	        for(int i = 1; i < A.size(); i++){
	            preGcd[i] = gcd(preGcd[i-1], A.get(i));
	        }
	        postGcd[A.size() - 1] = A.get(A.size() - 1);
	        for(int i = A.size() - 2; i >= 0; i--){
	            postGcd[i] = gcd(postGcd[i + 1], A.get(i));
	        }
	        int gcdMax = postGcd[1];
	        for(int i = 1; i < A.size() - 1; i++){
	            int gcd = gcd(preGcd[i-1], postGcd[i+1]);
	            gcdMax = Math.max(gcdMax, gcd);
	        }
	        gcdMax = Math.max(gcdMax, preGcd[A.size() - 2]);
	        return gcdMax;
	    }

	    public static int solve2(int A, int B, int C) {
	        int gcd = gcd(B, C);
	        if(gcd == 1){
	            return 0;
	        }
	        return A/gcd;
	    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(3);
		A.add(9);
		A.add(6);
		A.add(8);
		A.add(3);
//		System.out.println(solve1(A));
		System.out.println(solve2(99413, 7473, 3438));

	}

}
