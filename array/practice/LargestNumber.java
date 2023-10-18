package com.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

	class StringComparator implements Comparator<String>{  
        public int compare(String a, String b){
            String o1 = a+b;
            String o2 = b+a;
            return o2.compareTo(o1);
        } 
    }  
    public String largestNumber(final List<Integer> A) {
        String[] strArray = new String[A.size()];
        for (int i = 0; i < A.size(); i++){
            strArray[i] = Integer.toString(A.get(i));
        }
        Arrays.sort(strArray, new StringComparator());
        if(strArray[0].equals("0")){
            return "0";   /* Otherwise it would return multiple zeros (equal to the length of given array); but the requirement of test 
            case is to just return a single zero if the answer is zero */

        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<strArray.length;i++){
            sb.append(strArray[i]);
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		LargestNumber nl = new LargestNumber();
		int[] nums = { 3, 30, 34, 5, 9 };
		ArrayList<Integer> list =  (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
		System.out.println(nl.largestNumber(list));
	}
}
