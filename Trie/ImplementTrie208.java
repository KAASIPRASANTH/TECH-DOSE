class Trie {
    class TrieNode {
        char data;
        boolean isEnd;
        TrieNode[] hash;

        TrieNode(char data) {
            data = data;
            isEnd = false;
            hash = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode('*');
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.hash[ch - 'a'] == null) {
                temp.hash[ch - 'a'] = new TrieNode(ch);
            }
            temp = temp.hash[ch - 'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.hash[ch - 'a'] == null) {
                return false;
            }
            temp = temp.hash[ch - 'a'];
        }
        return temp.isEnd == true;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (char ch : prefix.toCharArray()) {
            if (temp.hash[ch - 'a'] == null) {
                return false;
            }
            temp = temp.hash[ch - 'a'];
        }
        return true;
    }
}