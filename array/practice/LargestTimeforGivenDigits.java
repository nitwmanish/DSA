package com.array.practice;

import java.util.HashMap;
import java.util.Map;

public class LargestTimeforGivenDigits {

	public int numSplits(String s) {
		Map<Character, Integer> left = new HashMap<>();
		Map<Character, Integer> right = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) + 1);
		}
		int count = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			left.put(s.charAt(i), left.getOrDefault(s.charAt(i), 0) + 1);
			right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) - 1);
			if (right.getOrDefault(s.charAt(i), 0) == 0) {
				right.remove(s.charAt(i));
			}
			if (left.size() == right.size()) {
				count++;
			}
		}
		return count;
	}

	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int reverse = 0;
		int tmp = x;
		while (tmp != 0) {
			int remainder = tmp % 10;
			reverse = reverse * 10 + remainder;
			tmp = tmp / 10;
		}
		if (reverse == x) {
			return true;
		}
		return false;
	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))) {
				str.append(s.charAt(i));
			}
		}
		int n = str.length() - 1;
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(n - i))
				return false;
		}
		return true;
	}
	
	public int minDeletion(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length -1 ; i++){
            if(i % 2 == 0 && nums[i] == nums[i + 1]){
                count++;
            }
        }
        if((nums.length - count) % 2 == 0){
            count++;
        }
        return count;
    }

	public static void main(String[] args) {
//		String s = "aaaaa";
//		String s = "aacaba";
		LargestTimeforGivenDigits largestTimeforGivenDigits = new LargestTimeforGivenDigits();
//		System.out.print(largestTimeforGivenDigits.numSplits(s));
		int[] arr = {1,1,2,3,5};
		System.out.print(largestTimeforGivenDigits.minDeletion(arr));
	}

}
