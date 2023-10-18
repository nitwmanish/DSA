package com.array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class matrix {
	public void sort(int nums[]) {
		int lo = 0;
		int mid = 0;
		int hi = nums.length - 1;
		while (mid <= hi) {
			switch (nums[mid]) {
			case 0: {
				int temp = nums[lo];
				nums[lo] = nums[mid];
				nums[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				int temp = nums[mid];
				nums[mid] = nums[hi];
				nums[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

	public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		int l1 = A.size();
		int l2 = B.size();
		int l3 = C.size();
		int ans = Integer.MAX_VALUE;
		while (p1 < l1 & p2 < l2 & p3 < l3) {
			int val = Integer.MIN_VALUE;
			int x = Math.abs(A.get(p1) - B.get(p2));
			int y = Math.abs(B.get(p2) - C.get(p3));
			int z = Math.abs(A.get(p1) - C.get(p3));
			if (x >= y & x >= z) {
				val = x;
				if (A.get(p1) > B.get(p2)) {
					p2 += 1;
				} else {
					p1 += 1;
				}
			} else if (y >= x & y >= z) {
				val = y;
				if (C.get(p3) > B.get(p2)) {
					p2 += 1;
				} else {
					p3 += 1;
				}
			} else if (z >= x & z >= y) {
				val = z;
				if (A.get(p1) > C.get(p3)) {
					p3 += 1;
				} else {
					p1 += 1;
				}
			}
			ans = Math.min(ans, val);
		}
		return ans;
	}
	public int longestConsecutive(final List<Integer> A) {
		HashSet<Integer> set = new HashSet<>(A);
		int max = Integer.MIN_VALUE;
		for (int ele : A) {
			int lcount = 0;
			int hcount = 0;
			int temp = ele;
			while (true) {
				temp--;
				if (set.contains(temp)) {
					lcount++;
					set.remove(temp);
				} else
					break;
			}
			temp = ele;
			while (true) {
				temp++;
				if (set.contains(temp)) {
					hcount++;
					set.remove(temp);
				} else
					break;
			}
			max = Math.max(lcount + hcount + 1, max);
		}
		return max;
	}

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
		int res = 0;
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < A.size(); i++) {
			map.put(A.get(i) + "" + B.get(i), map.getOrDefault(A.get(i) + "" + B.get(i), 0) + 1);
		}
		for (int i = 0; i < A.size(); i++) {
			for (int j = i + 1; j < B.size(); j++) {
				if (!A.get(i).equals(A.get(j)) && !B.get(i).equals(B.get(j))) {
					if (map.containsKey(A.get(i) + "" + B.get(j)) && map.get(A.get(i) + "" + B.get(j)) == 1
							&& map.containsKey(A.get(j) + "" + B.get(i)) && map.get(A.get(j) + "" + B.get(i)) == 1) {
						res++;
					}
				}
			}
		}
		return res / 2;
	}

	public int solve(int[] A, int[] B) {

		long m = 1000000007;
		HashMap<Integer, Integer> mapX = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> mapY = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			mapX.put(A[i], mapX.getOrDefault(A[i], 0) + 1);
			mapY.put(B[i], mapY.getOrDefault(B[i], 0) + 1);
		}
		int res = 0;
		for (int i = 0; i < B.length; i++) {
			res = (int) ((res + (1L * (mapX.get(A[i]) - 1) * (mapY.get(B[i]) - 1)) % m) % m);
		}
		return res;
	}

	public int solve(int A, String B) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < B.length(); i++) {
			if (hm.containsKey(B.charAt(i))) {
				hm.replace(B.charAt(i), hm.get(B.charAt(i)) + 1);
			} else {
				hm.put(B.charAt(i), 1);
			}
		}
		for (Character key : hm.keySet()) {
			if (hm.get(key) % A != 0) {
				return -1;
			}
		}
		return 1;
	}

	public static int getSolve(int[] A, int[] B) {
		int res = 0;
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			int equal = 1;
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] == A[j] && B[j] == B[i])
					equal++;
				else {
					int y = B[i] - B[j];
					int x = A[i] - A[j];
					int g__ = gcd(y, x);
					String str = (x / g__) + "#" + (y / g__);
					map.put(str, map.getOrDefault(str, 0) + 1);
				}
			}
			res = Math.max(res, equal);
			for (Map.Entry<String, Integer> e : map.entrySet()) {
				res = Math.max(res, e.getValue() + equal);
			}
			map.clear();
		}
		return res;
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
	public static ArrayList<Integer> compareSortedSubarrays(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < B.size(); i++) {
			List<Integer> s1 = new ArrayList<>();
			List<Integer> s2 = new ArrayList<>();
			ArrayList<Integer> query = B.get(i);
			int l1 = query.get(0);
			int r1 = query.get(1);
			for (int j = l1; j <= r1; j++) {
				s1.add(A.get(j));
			}
			int l2 = query.get(2);
			int r2 = query.get(3);
			for (int j = l2; j <= r2; j++) {
				s2.add(A.get(j));
			}
			Collections.sort(s1);
			Collections.sort(s2);
			if (s1.equals(s2)) {
				ans.add(1);
			} else {
				ans.add(0);
			}
		}
		return ans;
	}
	public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
		int[] nums = new int[A.size()];
		for (int i = 0; i < A.size(); i++) {
			nums[i] = A.get(i);
		}
		sort(nums);
		A.clear();
		for (int i = 0; i < nums.length; i++) {
			A.add(nums[i]);
		}
		return A;
	}
	
	public static int[] smallerNumbersThanCurrent(int[] nums) {
        
        int[] map = new int[101];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
        }
        
        for (int i = 1 ; i <= 100; i++) {
            map[i] += map[i-1];    
        }
        
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                res[i] = 0;
            else 
                res[i] = map[nums[i] - 1];
        }
        
        return res;  
    }

	public static void main(String[] args) {
//		int[] nums = { 2, 0, 0, 1, 0, 0, 2, 2, 1, 1, 0, 0, 1, 0, 2, 1, 1, 0, 1, 0, 1, 2, 2, 2, 0, 0, 1, 0, 2, 1, 1, 2,
//				1, 2, 2, 1, 0, 2, 2, 1, 1, 1, 0, 1, 0, 1, 0, 2, 1, 2, 0, 2, 0, 1, 1, 0, 2, 2, 1, 2, 0, 2, 1, 1, 1, 2, 0,
//				1, 0, 2, 2, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 2, 1, 1, 0, 2, 1, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 1, 1, 0, 2,
//				1, 2, 2, 2, 1, 2, 2, 0, 1, 0, 1, 2, 1, 1, 0, 1, 2, 0, 1, 0, 2, 2, 1, 2, 1, 0, 2, 2, 1, 1, 0, 2, 1, 2 };
//		ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList()); { 8,1,2,2,3 };
//		A a = new A();
//		System.out.println(a.sortColors(list));
//		int[] a = { 100000, 100000, 100000, 100000, 100000 };
//		int[][] b = { { 0, 3, 1, 4 }, { 0, 1, 2, 3 }, { 4, 4, 1, 1 }, { 1, 3, 0, 0 }, { 2, 4, 1, 1 } };
//		ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(a).boxed().collect(Collectors.toList());
//		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
//		for (int i = 0; i < b.length; i++) {
//			ArrayList<Integer> temp = new ArrayList<Integer>();
//			temp.add(b[i][0]);
//			temp.add(b[i][1]);
//			temp.add(b[i][2]);
//			temp.add(b[i][3]);
//			B.add(temp);
//		}
//		int[] a = { 1, 7, 11, 8, 11, 7, 1 };
//		int[][] b = { { 0, 2, 4, 6 } };
//		ArrayList<Integer> A = (ArrayList<Integer>) Arrays.stream(a).boxed().collect(Collectors.toList());
//		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
//		for (int i = 0; i < b.length; i++) {
//			ArrayList<Integer> temp = new ArrayList<Integer>();
//			temp.add(b[i][0]);
//			temp.add(b[i][1]);
//			temp.add(b[i][2]);
//			temp.add(b[i][3]);
//			B.add(temp);
//		}
		int[] a = { 8,1,2,2,3 };
		System.out.print(smallerNumbersThanCurrent(a));
	}

}
