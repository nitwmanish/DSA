package com.bit.manupulation;

public class NumberComplement {

	private int highestOneBit(int num) {
		if (num == 0) {
			return 0;
		}
		int msb = 0;
		while (num != 0) {
			num = num / 2;
			msb++;
		}
		return msb;
	}

	public int findComplement(int num) {
		int postion = highestOneBit(num);
		for (int i = 0; i < postion; i++) {
			int tem = 1;
			tem = tem << i;
			num = num ^ tem;
		}
		return num;
	}

	public static void main(String[] args) {
		NumberComplement alg = new NumberComplement();
		System.out.println(alg.findComplement(5));

	}

}
