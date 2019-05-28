class WordDictionary {
    TrieNode  root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            int index = ch -'a';
            if(node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfsSearch(word,root, 0);
    }
    public boolean dfsSearch(String word, TrieNode node, int index) {
        if(word.length() == index) {
            return node.isWord;
        }
        char ch = word.charAt(index);

        if(ch == '.') {
            for(TrieNode tmp : node.children) {
                if(tmp != null && dfsSearch(word,tmp,index+1)) {
                    return true;
                }
            }
            return false;
        } else {
            TrieNode tmp = node.children[ch-'a'];
            return tmp != null && dfsSearch(word,tmp,index+1);
        }
    }
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */