package TOP_450.TRIE;

/*
    Problem:208: https://leetcode.com/problems/implement-trie-prefix-tree/description/
    A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

    Implement the Trie class:

    Trie() Initializes the trie object.

    void insert(String word) Inserts the string word into the trie.

    boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.

    boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix `prefix`, and false otherwise.
 */
public class Trie {
    private static final int R = 26;
    private int endsHere;

    private Trie[] links;

    public Trie() {
        this.endsHere = 0;
        // R links to node children
        this.links = new Trie[R];
    }

    // Time Complexity: O(m): length of word
    // Space Complexity: O(m)
    public void insert(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (root.links[index] == null) {
                root.links[index] = new Trie();
            }
            root = root.links[index];
        }
        root.endsHere++;
    }

    // Time Complexity: O(m): length of word
    // Space Complexity: O(1)
    public boolean search(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 97;
            if (root.links[index] == null) return false;
            root = root.links[index];
        }
        return root.endsHere > 0;
    }

    public boolean startsWith(String prefix) {
        Trie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 97;
            if (root.links[index] == null) return false;
            root = root.links[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}
