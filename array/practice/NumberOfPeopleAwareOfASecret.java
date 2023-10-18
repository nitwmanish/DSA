package com.array.practice;

public class NumberOfPeopleAwareOfASecret {

	public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[]nums = new int[n + 1];
        int mod = 1000 * 1000* 1000 + 7;
        nums[1] = 1;

        for(int i = 1; i <= n; i++){
            for(int k = i + delay; k < i + forget && k <= n; k++){
                nums[k] = (nums[k] + nums[i]) % mod;   
            }
        }

        int i = 0;
        long ans = 0;

        while(forget-- > 0){
            ans = (ans + nums[n-i]) % mod;
            i++;
        }
        return (int)ans;
    
    }
	public static void main(String[] args) {
		NumberOfPeopleAwareOfASecret alg = new NumberOfPeopleAwareOfASecret();
		System.out.println(alg.peopleAwareOfSecret(4, 1, 3));
	}
}
