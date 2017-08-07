public class WordDictionary {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] array = word.toCharArray();
        TrieNode node = root;
        for (char c : array) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), root, 0);
    }
    
    public boolean match(char[] letters, TrieNode node, int index) {
        if (index == letters.length) {
            return node.item.equals("") ? false : true;
        }
        if (letters[index] != '.') {
            return node.children[letters[index] - 'a'] != null && match(letters, node.children[letters[index] - 'a'], index + 1);
        } else {
            for (int i = 0; i < node.children.length; ++i) {
                if (node.children[i] != null) {
                    if (match(letters, node.children[i], index + 1)) {
                        return true;
                    }
                }
            }
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