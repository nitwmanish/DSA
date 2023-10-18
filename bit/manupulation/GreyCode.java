package com.bit.manupulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GreyCode {
	public static List<String> getcode(int n) {
		if (n == 1) {
			List<String> temp = new ArrayList<>();
			temp.add("0");
			temp.add("1");
			return temp;
		}
		List<String> temp = new ArrayList<>(getcode(n - 1));
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < temp.size(); i++) {
			ans.add("0" + temp.get(i));
		}
		for (int i = temp.size() - 1; i >= 0; i--) {
			ans.add("1" + temp.get(i));
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		List<String> stringcode = new ArrayList<>(getcode(n));
		List<Integer> graycode = new ArrayList<>();
		for (int i = 0; i < stringcode.size(); i++) {
			graycode.add(Integer.parseInt(stringcode.get(i), 2));
		}
		System.out.println(stringcode);
		System.out.println(graycode);
		scn.close();

//		System.out.println(Integer.parseInt("100", 2));
	}
}
