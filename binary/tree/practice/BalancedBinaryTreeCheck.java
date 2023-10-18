package com.binary.tree.practice;

public class BalancedBinaryTreeCheck {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static class Height {
		int height = 0;
	}

	public static boolean isBalanced(Node root, Height height) {
		if (root == null) {
			height.height = 0;
			return true;
		}
		Height lheight = new Height();
		Height rheight = new Height();
		boolean l = isBalanced(root.left, lheight);
		boolean r = isBalanced(root.right, rheight);
		int lh = lheight.height;
		int rh = rheight.height;
		height.height = (lh > rh ? lh : rh) + 1;
		if (Math.abs(lh - rh) >= 2)
			return false;
		else
			return l && r;
	}

	public static int height(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(8);
		Height height = new Height();
		if (isBalanced(root, height))
			System.out.println("Tree is balanced");
		else
			System.out.println("Tree is not balanced");
	}

}
