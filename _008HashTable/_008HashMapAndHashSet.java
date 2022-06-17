package _008HashTable;

import java.util.HashMap;
import java.util.HashSet;

public class _008HashMapAndHashSet {

    // java.util.HashMap 和 java.util.HashSet 对哈希表进行了封装
    public static void main(String[] args) {
        // HashMap<Key, Value> 理解为可以通过 Key 快速地获取 Value
        HashMap<Integer, Student> hashMap = new HashMap<>();
        hashMap.put(123, new Student(123, "Peter"));
        hashMap.put(225, new Student(225, "Leo"));
        Student stu = hashMap.get(255);

        HashSet<Integer> set = new HashSet<>();
        set.add(123);// 只存 key，不存 value，有点像拉图
        set.add(225);
        boolean isExisted = set.contains(123);
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
