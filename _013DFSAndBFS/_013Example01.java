package _013DFSAndBFS;

// 题型 1、二位矩阵搜索或遍历
// 剑指 Offer 13. 机器人的运动范围

public class _013Example01 {

    public static void main(String[] args) {
        System.out.println(movingCount(2,3,1));
        System.out.println(movingCount(3,1,0));
    }

    private static boolean[][] visited;
    private static int count;

    public static int movingCount(int m, int n, int k) {
        count = 0;
        visited = new boolean[m][n];
        dfs(0, 0, m, n, k);
        return count;
    }

    private static void dfs(int i, int j, int m, int n, int k) {
        visited[i][j] = true;
        count++;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int di = 0; di < 4; di++) {
            int newi = i + directions[di][0];
            int newj = j + directions[di][1];
            if (newi >= m || newi < 0 || newj >= n || newj < 0
            || visited[newi][newj] == true
            || check(newi, newj, k) == false) {
                continue;
            }
            dfs(newi, newj, m, n, k);
        }
    }

    private static boolean check(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += (i%10);
            i /= 10;
        }
        while (j != 0) {
            sum += (j%10);
            j /= 10;
        }
        return sum <= k;
    }
}
