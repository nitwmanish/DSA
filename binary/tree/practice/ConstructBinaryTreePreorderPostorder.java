package com.binary.tree.practice;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderPostorder {

	public class TreeNode {
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

	static int preIndex = 0;

	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		preIndex = 0;
		if (preorder.length == 0 || postorder.length == 0) {
			return null;
		}
		if (preorder.length != postorder.length) {
			return null;
		}
		Map<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < postorder.length; i++) {
			mp.put(postorder[i], i);
		}
		return buildTree(preorder, postorder, mp, 0, preorder.length);
	}

	public TreeNode buildTree(int[] preorder, int[] postorder, Map<Integer, Integer> mp, int start, int end) {
		if (preIndex >= preorder.length || start > end) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preIndex++]);
		if (start == end || preIndex >= preorder.length) {
			return root;
		}
		int postIndex = mp.get(preorder[preIndex]);
		if (postIndex <= end) {
			root.left = buildTree(preorder, postorder, mp, start, postIndex);
			root.right = buildTree(preorder, postorder, mp, postIndex + 1, end - 1);
		}
		return root;
	}

	public static void main(String[] args) {
		int[] preorder = { 1, 2, 4, 5, 3, 6, 7 };
		int[] postorder = { 4, 5, 2, 6, 7, 3, 1 };
		ConstructBinaryTreePreorderPostorder algo = new ConstructBinaryTreePreorderPostorder();
		algo.constructFromPrePost(preorder, postorder);

	}

}
