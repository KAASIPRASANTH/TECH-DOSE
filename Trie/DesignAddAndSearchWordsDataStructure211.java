class WordDictionary {
    class TrieNode{
        char data;
        boolean isEnd;
        TrieNode[] hash;
        TrieNode(char data){
            this.data = data;
            isEnd=  false;
            hash = new TrieNode[26];
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode('*');
    }
    
    public void addWord(String word) {
        TrieNode temp = root;
        for(char ch:word.toCharArray()){
            if(temp.hash[ch-'a'] == null){
                temp.hash[ch-'a'] = new TrieNode(ch);
            }
            temp = temp.hash[ch-'a'];
        }
        temp.isEnd = true;
    }
    public boolean isPresent(String word,int index,TrieNode temp){
        if(index==word.length()){
            return temp.isEnd;
        }
        char ch = word.charAt(index);
        if(ch == '.'){
            for(int i=0;i<26;i++){
                if(temp.hash[i] != null && isPresent(word,index+1,temp.hash[i])){
                    return true;
                }
            }
        }else if(temp.hash[ch-'a'] != null){
            return isPresent(word,index+1,temp.hash[ch-'a']);
        }
        return false;
    }
    public boolean search(String word) {
        return isPresent(word,0,root);
    }
}
