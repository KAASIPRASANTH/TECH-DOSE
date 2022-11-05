package Recursion.LC;

import java.util.*;

public class WordBreakII140 {
    static TrieNode root;
    static int len;
    static List<String> res;

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

    public static void solve(String str) {
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[] { "", "0" });
        outter: while (!q.isEmpty()) {
            String[] s = q.poll();
            int start = Integer.parseInt(s[1]);
            TrieNode temp = root;
            for (int i = start; i < len; i++) {
                char ch = str.charAt(i);
                temp = temp.hash[ch - 'a'];
                if (temp == null)
                    continue outter;
                if (temp.End && i < len - 1) {
                    q.add(new String[] { s[0] + " " + (str.substring(start, i + 1)), (i + 1) + "" });

                }
            }
            if (temp.End == true) {
                String t = s[0] + " " + (str.substring(start));
                res.add(t.substring(1));
            }
        }
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        len = s.length();
        res = new ArrayList<>();
        for (int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }
        solve(s);
        return res;
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");
        System.out.println(wordBreak(s, wordDict));
    }
}
