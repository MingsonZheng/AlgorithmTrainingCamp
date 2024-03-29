package _011StringMatching;

import java.util.ArrayList;
import java.util.List;

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

        // 3）前缀匹配
        prefixMatch("he".toCharArray());

        // 2）多模式匹配
        match("heroheram".toCharArray());

        // 1）字符串查找（完全匹配，就是普通的查找）
        System.out.println(find("here".toCharArray()));
        System.out.println(find("there".toCharArray()));
    }

    // 3）前缀匹配
    public static void prefixMatch(char[] prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length; i++) {
            int index = prefix[i] - 'a';
            if (p.children[index] == null) {
                return; // 没有前缀匹配的字符串
            }
            p = p.children[index];
        }
        List<Character> path = new ArrayList<>();
        travelTree(p, prefix, path);
    }

    private static void travelTree(TrieNode p, char[] prefix, List<Character> path) {
        if (p.isEndingChar) {
            StringBuilder resultString = new StringBuilder();
            resultString.append(prefix);// he
//            resultString.append(path);// ell
            var tmpPath = path;// ell
            tmpPath.remove(0); // ll
            tmpPath.add(p.data);// llo
            resultString.append(tmpPath);// llo
            System.out.println(resultString);// hello
        }
        path.add(p.data);// e
        for (int i = 0; i < p.children.length; i++) {
            if (p.children[i] != null) {
                travelTree(p.children[i], prefix, path);
            }
        }
        path.remove(path.size()-1);
    }

    // 2）多模式匹配
    public static void match(char[] mainstr) {
        for (int i = 0; i < mainstr.length; i++) {
            TrieNode p = root;
            for (int j = i; j < mainstr.length; j++) {
                int index = mainstr[j] - 'a';
                if (p.children[index] == null) {
                    break;
                }
                p = p.children[index];
                if (p.isEndingChar) {
                    System.out.println("matched, mainstr index [" + i + "," + j + "].");
                }
            }
        }
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
