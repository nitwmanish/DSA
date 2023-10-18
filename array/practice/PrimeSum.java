package com.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSum {
	public static List<Integer> spf(int A) {
		List<Integer> primes = new ArrayList<Integer>();
		boolean[] isPrimes = new boolean[A + 1];
		Arrays.fill(isPrimes, true);
		isPrimes[0] = false;
		isPrimes[1] = false;
		for (int i = 2; i <= (int) Math.sqrt(A); i++) {
			if (isPrimes[i]) {
				for (int j = i * i; j <= A; j += i) {
					isPrimes[j] = false;
				}
			}
		}

		for (int i = 2; i <= A; i++) {
			if (isPrimes[i]) {
				primes.add(i);
			}
		}
		return primes;
	}

	public static ArrayList<Integer> primesum(int A) {
		List<Integer> primes = spf(A);
		int i = 0;
		int j = primes.size() - 1;
		System.out.println("primes-->"+primes);
		ArrayList<Integer> res = new ArrayList<Integer>();
		while (i <= j) {
			if (primes.get(i) + primes.get(j) == A) {
				res.add(primes.get(i));
				res.add(primes.get(j));
				i++;
				j--;
				break;
			}else if(primes.get(i) + primes.get(j) < A) {
				i++;
			}else {
				j--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(primesum(28));

	}

}
