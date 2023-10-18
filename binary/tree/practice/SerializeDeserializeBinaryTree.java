package com.binary.tree.practice;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserializeBinaryTree {
	int i;

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public String serialize(TreeNode root) {
		List<String> list = new ArrayList<>();
		preOrder(root, list);
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				strBuilder.append(list.get(i));
			} else {
				strBuilder.append(list.get(i)).append(",");
			}

		}
		return strBuilder.toString();
	}

	public void preOrder(TreeNode root, List<String> list) {
		if (root == null) {
			list.add("N");
			return;
		}
		list.add(root.val + "");
		preOrder(root.left, list);
		preOrder(root.right, list);
	}

	public TreeNode deserialize(String data) {
		String[] strArray = data.split(",");
		i = 0;
		return createTree(strArray);
	}

	public TreeNode createTree(String[] strArray) {
		if (i >= strArray.length || i < 0 || strArray[i].compareTo("N") == 0) {
			i++;
			return null;
		}
		if (strArray[i].trim() == "") {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(strArray[i]));
		i++;
		root.left = createTree(strArray);
		root.right = createTree(strArray);
		return root;
	}

	public static void main(String args[]) {
		SerializeDeserializeBinaryTree tree = new SerializeDeserializeBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(tree.deserialize(tree.serialize(root)));
	}
}
