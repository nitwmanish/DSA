package com.array.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSubsequences {
	public static boolean[] sieve(int A){
        boolean[]isPrimes = new boolean[A+1];
        Arrays.fill(isPrimes,true);
        isPrimes[0] = false;
        isPrimes[1] = false;
        for(int i = 2; i <= (int)Math.sqrt(A); i++){
            if(isPrimes[i]){
                for(int j = i*i ; j <= A; j += i){
                    isPrimes[j] = false;
                }
            }
        }
        return isPrimes;
    }
    public static int solve(ArrayList<Integer> A) {
        int max = 0;
		for (int i = 0; i < A.size(); i++) {
			max = Math.max(max, A.get(i));
		}
		boolean[] spf = sieve(max);
        int primeCount = 0; 
        for (int i = 0; i < A.size(); i++) {
			if(spf[A.get(i)]){
                primeCount++;
            }
		}
        return (int)Math.pow(2, primeCount) - 1;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(9);
		A.add(4);
		A.add(9);
		A.add(1);
		A.add(5);
		System.out.println(solve(A));

	}

}
