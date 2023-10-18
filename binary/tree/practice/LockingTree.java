package com.binary.tree.practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LockingTree {
	Map<Integer, List<Integer>> child;
	Map<Integer, Integer> locked;
	int[] parent;

	public LockingTree(int[] parent) {
		child = new HashMap<>();
		locked = new HashMap<>();
		this.parent = parent;
		for (int i = 0; i < parent.length; i++) {
			child.put(i, new ArrayList<>());
		}
		for (int i = 1; i < parent.length; ++i) {
			child.get(parent[i]).add(i);
		}
	}

	public boolean lock(int num, int user) {
		if (locked.containsKey(num)) {
			return false;
		}
		locked.put(num, user);
		return true;
	}

	public boolean unlock(int num, int user) {
		if (!locked.containsKey(num) || locked.get(num) != user) {
			return false;
		}
		locked.remove(num);
		return true;
	}

	public boolean upgrade(int num, int user) {
		int curr = num;
		while (curr != -1) {
			curr = parent[curr];
			if (locked.containsKey(curr)) {
				return false;
			}
		}
		int lokedCount = 0;
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 1; i < parent.length; ++i) {
			deque.offerLast(parent[i]);
		}
		while (!deque.isEmpty()) {
			int n = deque.pollFirst();
			if (locked.containsKey(n)) {
				locked.remove(n);
				lokedCount++;
			}
			deque.addAll(child.get(n));
		}
		if (lokedCount > 0) {
			locked.put(num, user);
		}
		return lokedCount > 0;
	}

	private boolean lockedDescendant(int node) {
		if (locked.containsKey(node)) {
			return true;
		}
		for (int i : child.get(node)) {
			if (lockedDescendant(i))
				return true;
		}
		return false;
	}

	private void massUnlocker(int node) {
		if (locked.containsKey(node)) {
			locked.remove(node);
		}
		for (int i : child.get(node)) {
			massUnlocker(i);
		}
	}
}
