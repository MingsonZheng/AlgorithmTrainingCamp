package _002ProgrammingAndRegularities;

public class _002Programming {
    public static void main(String[] args) {
        // 纯编程题例题2 1108. IP 地址无效化
        //    示例 1：
        //    输入：address = "1.1.1.1"
        //    输出："1[.]1[.]1[.]1"
        //    示例 2：
        //    输入：address = "255.100.50.0"
        //    输出："255[.]100[.]50[.]0"
        System.out.println("例题2 1108. IP 地址无效化");
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr2("1.1.1.1"));
        System.out.println(defangIPaddr3("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
        System.out.println(defangIPaddr2("255.100.50.0"));
        System.out.println(defangIPaddr3("255.100.50.0"));

        // 纯编程题例题1：IP 地址解析（拼多多面试题）
        System.out.println("例题1：IP 地址解析（拼多多面试题）");
        checkIp("123.9.2.0");
        checkIp(" 223. 33. 13 . 33");
        checkIp(" 232. 22 1. 223. 1");
        checkIp(" 222. 319. 2. 4");
        checkIp("2ba. 23. 34.11");
        checkIp("232. 232. 11");
        checkIp("233. . 33.2");
        checkIp("");
        checkIp(null);
    }

    // 纯编程题例题2 1108. IP 地址无效化
    public static String defangIPaddr3(String address){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char c = address.charAt(i);
            if (c != '.') {
                sb.append(c);
            } else {
                sb.append("[.]");
            }
        }
        return sb.toString();
    }

    // 纯编程题例题2 1108. IP 地址无效化
    public static String defangIPaddr2(String address) {
        char[] origin = address.toCharArray();
        int n = origin.length;
        int newN = n + 2 * 3;
        char[] newString = new char[newN];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (origin[i] != '.') {
                newString[k] = origin[i];
                k++;
            } else {
                newString[k++] = '[';
                newString[k++] = '.';
                newString[k++] = ']';
            }
        }
        return new String(newString);
    }

    // 纯编程题例题2 1108. IP 地址无效化
    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    // 纯编程题例题1：IP 地址解析（拼多多面试题）
    public static void checkIp(String ip){
        System.out.println(ip + " is " + check(ip));
    }

    // 1. "123.9.2.0" 合法
    // 2. " 223. 33. 13 . 33" 合法
    // 3. " 232. 22 1. 223. 1" 非法
    // 4. " 222. 319. 2. 4" 非法，319超过范围
    // 5. "2ba. 23. 34.11" 非法
    // 6. "232. 232. 11" 非法
    // 7. "233. . 33.2" 非法
    // 8. "" or null 非法
    public static boolean check(String ip){
        if (ip == null) return false;
        // 将 ip 分割为子段：123.2.31.11
        String[] ipSegments = ip.split("\\.");
        // 验证是否满足子段个数为 4
        if (ipSegments.length != 4){
            return false;
        }
        // 验证每段是否合法
        for (int i = 0; i < 4; i++) {
            boolean valid  = checkSegment(ipSegments[i]);
            if (!valid) return false;
        }
        return true;
    }

    // "123", " 123 ”， “ 12 3”， “288”， “2db”， “  ”
    private static boolean checkSegment(String ipSegment){
        int n = ipSegment.length();
        int i = 0;
        // 跳过前导空格，例如：“  123”
        // charAt(i) 相当于 ipSegment[i]
        while (i < n && ipSegment.charAt(i) == ' '){
            i++;
        }
        if (i == n) { // 字符串全是空格
            return false;
        }
        // 处理数字（将字符串转化成数字），例如：“123  ”
        int digit = 0;
        while (i < n && ipSegment.charAt(i) != ' ') {
            char c = ipSegment.charAt(i);
            if (c < '0' || c > '9') { // 非数字字符
                return false;
            }
            // c = '1'->1
            digit = digit * 10 + (c - '0');
            // "1234 " digit =1, 12, 123, 1234
            if (digit > 255) { // 数字超过255
                return false;
            }
            i++;
        }
        // 处理后置空格，例如：“123 ” or “12 3”
        while (i < n){
            char c = ipSegment.charAt(i);
            if (c != ' ') { // 后面居然又有非空转字符
                return false;
            }
            i++;
        }
        return true;
    }
}
