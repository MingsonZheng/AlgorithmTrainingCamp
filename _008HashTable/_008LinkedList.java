package _008HashTable;

import java.util.LinkedList;

public class _008LinkedList {

    // 哈希冲突解决方法：链表法
    public class HashTable {
        private int n = 1000;
        private LinkedList<Student> students[] = new LinkedList[n];

        public HashTable() {
            for (int i = 0; i < n; i++) {
                students[i] = new LinkedList<>();
            }
        }

        public void put(String id, Student student) {
            int hashValue = hashFunction(id);
            LinkedList<Student> linkedList = students[hashValue];
            linkedList.addFirst(student);
        }

        public Student get(String id) {
            int hashValue = hashFunction(id);
            LinkedList<Student> linkedList = students[hashValue];
            for (Student student: linkedList) {
                if (student.id.equals(id)) return student;
            }
            return null;
        }

        private int hashFunction(String id) {
            int idNum = Integer.parseInt(id);
            int hashValue = idNum % n;
            return hashValue;
        }
    }

    public static class Student {
        public String id;
        public String name;
        public int score;
        // ...
    }
}
