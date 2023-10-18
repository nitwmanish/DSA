package com.binary.tree.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static List<TreeNode> allPossibleFBT(int n) {
		Map<Integer, List<TreeNode>> mp = new HashMap<>();
		mp.put(0, new ArrayList<TreeNode>());
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(new TreeNode());
		mp.put(1, list);
		if (n == 0) {
			return mp.get(0);
		}
		if (n == 1) {
			return mp.get(1);
		}
		return backtracking(n, mp);
	}

	public static List<TreeNode> backtracking(int n, Map<Integer, List<TreeNode>> mp) {
		if (mp.containsKey(n)) {
			return mp.get(n);
		}
		List<TreeNode> list = new ArrayList<TreeNode>();
		for (int l = 0; l < n; l++) {
			int r = n - 1 - l;
			List<TreeNode> leftTree = backtracking(l, mp);
			List<TreeNode> rightTree = backtracking(r, mp);
			for (TreeNode t1 : leftTree) {
				for (TreeNode t2 : rightTree) {
					list.add(new TreeNode(0, t1, t2));
				}
			}
		}
		mp.put(n, list);
		return list;
	}
	
	public static void main(String[] args) {
		System.out.print(allPossibleFBT(7));

	}
}
