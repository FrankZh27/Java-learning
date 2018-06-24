public class Trie {
    class TrieNode {
        private boolean isEnd;
        private TrieNode[] links;
        final int R = 26;
        
        public TrieNode() {
            this.links = new TrieNode[R];
        }
        
        public void put(char c, TrieNode node) {
            links[c-'a'] = node;
            return;
        }
        
        public void setEnd(boolean val) {
            isEnd = val;
            return;
        }
        
        public boolean isEnd() {
            return isEnd;
        }
        
        public boolean containsKey(char c) {
            if (links[c - 'a'] == null) {
                return false;
            }
            return true;
        }
        
        public TrieNode getKey(char c) {
            return links[c - 'a'];
        }
        
    }
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int sz = word.length();
        TrieNode node = root;
        if (sz == 0) return;
        for (int i = 0; i < sz; i++) {
            if (!node.containsKey(word.charAt(i))) {
                TrieNode newNode = new TrieNode();
                node.put(word.charAt(i), newNode);     
            }
            node = node.getKey(word.charAt(i));
        }
        node.setEnd(true);
        return;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int sz = word.length();
        TrieNode node = root;
        if (sz == 0) return true;
        for (int i = 0; i < sz; i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.getKey(word.charAt(i));
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int sz = prefix.length();
        TrieNode node = root;
        if (sz == 0) return true;
        for (int i = 0; i < sz; i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.getKey(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
