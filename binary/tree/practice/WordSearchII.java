package com.binary.tree.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearchII {
	public static class TrieNode {
		Map<Character, TrieNode> children = new HashMap<>();
		boolean endOfWord = false;

		public void addWord(String word) {
			TrieNode curr = this;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (!curr.children.containsKey(ch)) {
					curr.children.put(ch, new TrieNode());
				}
				curr = curr.children.get(ch);
			}
			curr.endOfWord = true;
		}
	}

	public static List<String> findWords(char[][] board, String[] words) {
		TrieNode root = new TrieNode();
		for (String word : words) {
			root.addWord(word);
		}
		Set<String> set = new HashSet<String>();
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				boolean[][] visited = new boolean[board.length][board[0].length];
				StringBuilder word = new StringBuilder();
				dfs(r, c, visited, root, board, word, set);
			}
		}
//		List<String> list = new ArrayList<>(set.size());
//		for (String word : words) {
//			if (set.contains(word)) {
//				list.add(word);
//			}
//		}
		return new ArrayList<>(set);
	}

	public static void dfs(int r, int c, boolean[][] visited, TrieNode node, char[][] board, StringBuilder word,
			Set<String> set) {

		if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
			return;
		}
		if (!node.children.containsKey(board[r][c])) {
			return;
		}
		if (visited[r][c]) {
			return;
		}
		visited[r][c] = true;
		node = node.children.get(board[r][c]);
		word.append(board[r][c]);
		if (node.endOfWord) {
			set.add(word.toString());
		}
		dfs(r + 1, c, visited, node, board, word, set);
		dfs(r - 1, c, visited, node, board, word, set);
		dfs(r, c + 1, visited, node, board, word, set);
		dfs(r, c - 1, visited, node, board, word, set);
		visited[r][c] = false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain", "hklf", "hf" };
		List<String> list = findWords(board, words);

	}

}
