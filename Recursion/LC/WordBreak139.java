package Recursion.LC;

import java.util.*;

public class WordBreak139 {
    static TrieNode root;
    static int len;

    public static class TrieNode {
        TrieNode[] hash;
        boolean End = false;

        TrieNode() {
            hash = new TrieNode[26];
        }
    }

    public static void insert(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            int pos = ch - 'a';
            if (temp.hash[pos] == null) {
                temp.hash[pos] = new TrieNode();
            }
            temp = temp.hash[pos];
        }
        temp.End = true;
    }

    public static boolean solve(String str) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[len];
        q.add(0);
        outter:
        while (!q.isEmpty()) {
            int start = q.poll();
            if (visited[start])
                continue;
            visited[start] = true;
            TrieNode temp = root;
            for (int i = start; i < len; i++) {
                char ch = str.charAt(i);
                temp = temp.hash[ch - 'a'];
                if (temp == null)
                    continue outter;
                if (temp.End && i < len - 1) {
                    q.add(i + 1);
                }
            }
            if (temp.End == true) {
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        len = s.length();
        for (int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }
        return solve(s);
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        String s = "leetcode";
        System.out.println(wordBreak(s, wordDict));
    }
}
