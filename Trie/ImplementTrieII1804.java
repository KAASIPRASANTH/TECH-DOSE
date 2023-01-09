class Trie {
    class TrieNode {
        char data;
        int charCount;
        int wordCount;
        TrieNode[] hash;

        TrieNode(char data) {
            this.data = data;
            charCount = 0;
            wordCount = 0;
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
            temp.charCount++;
        }
        temp.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.hash[ch - 'a'] == null) {
                return 0;
            }
            temp = temp.hash[ch - 'a'];
        }
        return temp.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode temp = root;
        for (char ch : prefix.toCharArray()) {
            if (temp.hash[ch - 'a'] == null) {
                return 0;
            }
            temp = temp.hash[ch - 'a'];
        }
        return temp.charCount;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            if (temp.hash[ch - 'a'] == null) {
                return false;
            }
            temp = temp.hash[ch - 'a'];
        }
        return temp.wordCount > 0;
    }

    public void erase(String word) {
        if (!search(word)) {
            return;
        }
        TrieNode temp = root;
        for (char ch : word.toCharArray()) {
            temp = temp.hash[ch - 'a'];
            temp.charCount--;
        }
        temp.wordCount--;
    }
}