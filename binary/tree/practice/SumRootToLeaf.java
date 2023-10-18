package com.binary.tree.practice;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	int ans = 0;

	public int sumRootToLeaf(TreeNode root) {
		preOrder(root, "");
		return ans;
	}

	public void preOrder(TreeNode node, String str) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			str += node.val;
			ans += calculateValue(str);
		}
		str = str + node.val;
		preOrder(node.left, str);
		preOrder(node.right, str);
	}

	public int calculateValue(String str) {
		int ans = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '1')
				ans += Math.pow(2, str.length() - 1 - i);
		}
		return ans;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
		System.out.println(sumRootToLeaf.sumRootToLeaf(root));
	}
}
