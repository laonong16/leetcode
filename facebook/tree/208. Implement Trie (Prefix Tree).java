class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode= root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curNode.children[index] == null) {
                TrieNode node = new TrieNode();
                curNode.children[index] = node;
            }
            curNode = curNode.children[index];
        }
        curNode.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = findNode(word);
        if(curNode == null) {
            return false;
        }
        return curNode.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = findNode(prefix);
        return curNode != null;
    }

    private TrieNode findNode (String word) {
        TrieNode curNode = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curNode.children[index] != null) {
                curNode = curNode.children[index];
            } else {
                return  null;
            }
        }
        return curNode;
    }
    class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            this.isWord = false;
            children = new TrieNode[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */