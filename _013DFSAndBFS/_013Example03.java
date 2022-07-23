package _013DFSAndBFS;

// 题型 3、连通分量/连通性
// 200. 岛屿数量

public class _013Example03 {

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }

    private static boolean[][] visited;
    private static int h;
    private static int w;

    public static int numIslands(char[][] grid) {
        h = grid.length;
        w = grid[0].length;
        visited = new boolean[h][w];
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (visited[i][j] != true && grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int i, int j) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newi = i + directions[k][0];
            int newj = j + directions[k][1];
            if (newi >= 0 && newi < h && newj >= 0 && newj < w
            && visited[newi][newj] == false
            && grid[newi][newj] == '1') {
                dfs(grid, newi, newj);
            }
        }
    }
}
