package Recursion.LC;

import java.util.*;

public class WordSearchII212 {
    static int row, col;
    static TrieNode root;
    static List<String> res;

    public static class TrieNode {
        TrieNode[] hash;
        String word = null;

        TrieNode() {
            hash = new TrieNode[26];
        }
    }

    public static void insert(String str) {
        TrieNode temp = root;
        for (char ch : str.toCharArray()) {
            int pos = ch - 'a';
            if (temp.hash[pos] == null) {
                temp.hash[pos] = new TrieNode();
            }
            temp = temp.hash[pos];
        }
        temp.word = str;
    }

    public static void dfs(char[][] board, int x, int y, TrieNode temp) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        char ch = board[x][y];
        if (ch == '$' || temp.hash[ch - 'a'] == null) {
            return;
        }
        board[x][y] = '$';
        temp = temp.hash[ch - 'a'];
        if (temp.word != null) {
            res.add(temp.word);
            temp.word = null;
        }
        dfs(board, x + 1, y, temp);
        dfs(board, x - 1, y, temp);
        dfs(board, x, y - 1, temp);
        dfs(board, x, y + 1, temp);
        board[x][y] = ch;
        return;
    }

    public static List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        row = board.length;
        col = board[0].length;
        res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char ch = board[i][j];
                if (root.hash[ch - 'a'] != null) {
                    TrieNode temp = root;
                    dfs(board, i, j, temp);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                { 'i', 'f', 'l', 'v' } };
        String[] words = { "oath", "pea", "eat", "rain" };
        System.out.println(findWords(board, words));
    }
}
