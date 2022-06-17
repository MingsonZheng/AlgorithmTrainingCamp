package _008HashTable;

// 哈希表的由来

public class _008OriginOfHashTable {

    // 假设学号的范围很大，是一串很长的数字，但也有规律，比如 201802013；或者无规律，比如 3615821
    private int n = 100;
    private Student3 s3[] = new Student3[n];
    public void insert3(Student3 student) {
        int hashValue = hashFunction(student.id);
        s3[hashValue] = student;
    }

    public Student3 find3(String id) {
        int hashValue = hashFunction(id);
        return s3[hashValue];
    }

    private int hashFunction(String id) {// ID 先处理，再转化成数组下标
        int idNum = Integer.parseInt(id);
        int hashValue = idNum % n;
        return hashValue;
    }

    public static class Student3 {
        public String id;
        public String name;
        public int score;
        // ...
    }

    // 假设学号的范围很大，是一串很长的数字，比如 201802013
    private int maxId2 = 100000000;
    private Student s2[] = new Student[maxId2+1];

    public void insert2(Student student) {
        s2[student.id] = student;// 存：把 ID 为 x 的学生存储到数组中下标为 x 的位置
    }

    public Student find2(int id) {
        return s2[id];// 取：取 ID 为 x 的学生就是取数组中小标为 x 的元素
    }

    // 下标与 ID -- 映射的存储方式
    private int maxId1 = 1000;
    private Student s1[] = new Student[maxId1+1];

    public void insert1(Student student) {
        s1[student.id] = student;// 存：把 ID 为 x 的学生存储到数组中下标为 x 的位置
    }

    public Student find1(int id) {
        return s1[id];// 取：取 ID 为 x 的学生就是取数组中小标为 x 的元素
    }

    // 杂乱无章的存数组
    public Student find0(int id) {
        // TODO:...
        return null;
    }

    public static class Student {
        public int id;
        public String name;
        public int score;
        // ...
    }
}
