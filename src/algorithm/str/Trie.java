package algorithm.str;

// Leetcode 208 ʵ�� Trie��
// �������е����붼����Сд��ĸ a-z ���ɵ�
// ���������Ϊ�ǿ��ַ���
public class Trie {
    /** Initialize your data structure here. */
    private TrieNode root;
    private Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    private void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (p.childs[idx] == null)
                p.childs[idx] = new TrieNode();
            p = p.childs[idx];
        }
        p.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    private boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (p.childs[idx] == null) return false;
            p = p.childs[idx];
        }
        return p.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    private boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if (p.childs[idx] == null) return false;
            p = p.childs[idx];
        }
        return true;
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // ���� true
        System.out.println(trie.search("app"));     // ���� false
        System.out.println(trie.startsWith("app")); // ���� true
        trie.insert("app");
        System.out.println(trie.search("app"));     // ���� true
    }
}

class TrieNode{
    TrieNode () {}
    TrieNode[] childs = new TrieNode[26]; //����ֻ��Сд��ĸ
    boolean isEnd = false;
}