package com.binary.tree.practice;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private static final String SEP = ",";
	private static final String NULL = "null";

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			return NULL;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp == null) {
				sb.append(NULL).append(SEP);
				continue;
			}
			sb.append(temp.val).append(SEP);
			queue.add(temp.left);
			queue.add(temp.right);
		}
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data.equals(NULL)) {
			return null;
		}
		String[] strs = data.split(SEP);
		// for (String e : strs) {
		// queue.offer(Integer.parseInt(e));
		// }
		// return getNode(queue);
		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i = 1;
		while (!queue.isEmpty() && i < strs.length) {
			TreeNode temp = queue.poll();
			if (!strs[i].equals(NULL)) {
				temp.left = new TreeNode(Integer.parseInt(strs[i]));
				queue.add(temp.left);
			}
//			else {
//				temp.left = null;
//			}
			i++;
			if (i < strs.length && !strs[i].equals(NULL)) {
				temp.right = new TreeNode(Integer.parseInt(strs[i]));
				queue.add(temp.right);
			}
//			else {
//				temp.right = null;
//			}
			i++;
		}
		return root;
	}

	public static void main(String[] args) {
		SerializeAndDeserializeBST alg = new SerializeAndDeserializeBST();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		String tree = alg.serialize(root);
		System.out.println(tree);
		TreeNode root2 = alg.deserialize(tree);
		System.out.println(alg.serialize(root2));

	}

}
