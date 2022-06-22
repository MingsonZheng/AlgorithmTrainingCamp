package _009BinaryTrees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class _009BinaryTrees_TreeMapTreeSet {
    public static void main(String[] args) {
        // 哈希表 -> HashMap, HashSet
        HashMap<Integer, Student> hashMap = new HashMap<>();
        hashMap.put(123, new Student(123, "Peter"));
        hashMap.put(225, new Student(225, "Leo"));
        Student stu = hashMap.get(225);

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(123);
        hashSet.add(225);
        boolean isExisted = hashSet.contains(123);

        // 红黑树 -> TreeMap, TreeSet
        TreeMap<Integer, Student> treeMap = new TreeMap<>();
        treeMap.put(123, new Student(123, "Peter"));
        treeMap.put(225, new Student(225, "Leo"));
        stu = treeMap.get(225);

        HashSet<Integer> treeSet = new HashSet<>();
        treeSet.add(123);
        treeSet.add(225);
        isExisted = treeSet.contains(123);
    }
    public static class Student {
        public int id;
        public String name;
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
