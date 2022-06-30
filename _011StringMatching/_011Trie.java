package _011StringMatching;

public class _011Trie {
    public static void main(String[] args) {
        // 模式串：am hello hi how here her
        // 把模式串构建成 Trie 树
        insert("am".toCharArray());
        insert("hello".toCharArray());
        insert("hi".toCharArray());
        insert("how".toCharArray());
        insert("here".toCharArray());
        insert("her".toCharArray());

        // 1）字符串查找（完全匹配，就是普通的查找）
        System.out.println(find("here".toCharArray()));
        System.out.println(find("there".toCharArray()));
    }

    // 1）字符串查找（完全匹配，就是普通的查找）
    public static boolean find(char[] target) {
        TrieNode p = root;
        for (int i = 0; i < target.length; i++) {
            int index = target[i] - 'a';
            if (p.children[index] == null) {
                return false;// 不存在 target
            }
            p = p.children[index];
        }
        if (p.isEndingChar == false) {
            return false;// 不能完全匹配，只是前缀
        } else {
            return true;// 找到 target
        }
    }

    // 构建 Trie 树
    private static TrieNode root = new TrieNode('/');

    // 往 Trie 树中插入一个字符串
    public static void insert(char[] text) {
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

    public static class TrieNode {
        public char data;// a~z 26 个字母；一个字节最多有 26 个子节点，所以是 26 叉树
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }
}
