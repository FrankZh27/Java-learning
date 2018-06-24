class WordDictionary {
    
    class TriNode {
        
        private TriNode[] links;
        final int R = 26;
        private boolean isEnd;
        
        public TriNode() {
            links = new TriNode[R];
            isEnd = false;
        }
        
        public void put(TriNode node, char c) {
            if (node.links[c-'a'] == null) {
                node.links[c-'a'] = new TriNode();
            }
            return;
        }
        
        public boolean isEnd(TriNode node) {
            return node.isEnd;
        }
        
        public void setEnd(TriNode node) {
            node.isEnd = true;
            return;
        }
        
        public boolean containsKey(char c, TriNode node) {
            if (node.links[c-'a'] == null) {
                return false;
            }
            return true;
        }
        
        public TriNode getKey(char c) {
            return links[c-'a'];
        }
        
    }
    
    TriNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TriNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TriNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            curr.put(curr, word.charAt(i));
            curr = curr.links[word.charAt(i)-'a'];
        }
        curr.setEnd(curr);
        return;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TriNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != '.') {
                if (!curr.containsKey(word.charAt(i), curr)) {
                     return false;
                }
                curr = curr.links[word.charAt(i)-'a'];
            }
            else {
                boolean hasOne = false;
                for (int j = 0; j < 26; j++) {
                    char c = (char) ('a'+j);
                    String s = word.substring(0,i) + c + word.substring(i+1, word.length());
                    hasOne = search(s);
                    if (hasOne) {
                        return true;
                    }
                }
                return false;
            }
        }
        if (curr.isEnd) {
            return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
