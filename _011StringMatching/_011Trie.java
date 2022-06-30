package _011StringMatching;

public class _011Trie {

    // 构建 Trie 树
    public class Trie {
        public class TrieNode {
            public char data;// a~z 26 个字母；一个字节最多有 26 个子节点，所以是 26 叉树
            public TrieNode[] children = new TrieNode[26];
            public boolean isEndingChar = false;
            public TrieNode(char data) {
                this.data = data;
            }
        }
        private TrieNode root = new TrieNode('/');

        // 往 Trie 树中插入一个字符串
        public void insert(char[] text) {
            TrieNode p = root;
            for (int i = 0; i < text.length; i++) {
                int index = text[i] - 'a';
                if (p.children[index] == null) {
                    TrieNode newNode = new TrieNode(text[i]);
                    p.children[index] = newNode;
                }
                p = p.children[index];
            }
            p.isEndingChar = true;
        }
    }
}
