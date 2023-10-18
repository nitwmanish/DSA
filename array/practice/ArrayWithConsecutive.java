package com.array.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class ArrayWithConsecutive {

//	public static int solve(ArrayList<Integer> A) {
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//        int sum = 0;
//        for(int i = 0; i < A.size(); i++){
//            if(A.get(i) < min){
//                min = A.get(i);
//            }
//            if(A.get(i) > max){
//                max = A.get(i);
//            }
//            sum += A.get(i);
//        }
//        return sum == ((max*(max+1)/2) - ((min - 1)*(min)/2))?1:0;
//    }
	public static int solve(ArrayList<Integer> A) {
		BigInteger f = new BigInteger("1");
		System.out.println((f.toString()));
		
        int min = Collections.min(A);
        int num = 0;
        for(int i = 0 ; i < A.size() ; i++) {
            num = num ^ min ^ A.get(i);
            min += 1;
        }
        if(num == 0)
            return 1;
        return 0;
    }
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 5, 5 };
		ArrayList<Integer> list =  (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
		System.out.println(solve(list));
	}	

}
