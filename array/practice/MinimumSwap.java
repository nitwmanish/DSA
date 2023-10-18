package com.array.practice;

import java.util.Arrays;
import java.util.List;

public class MinimumSwap {

	public static int solve(List<Integer> A, int B) {
        int start = 0;
        int end = A.size() - 1;
        int count = 0;
        while(start < end){
            while(start < end && A.get(start) <= B){
                start++;
            }
            while(end > start && A.get(end) > B){
                end--;
            }
            if(start < end) {
	            count++;
	            start++;
	            end--;
            }
        }
        return count;
    }
	public static void main(String args[]) {
		List<Integer> lst = Arrays.asList(52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70 );
		System.out.print(solve(lst, 19));
	}
}
