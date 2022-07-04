package _012Backtrack;

// 回溯例题2、八皇后

import java.util.ArrayList;
import java.util.List;

public class _012Example02 {

    List<char[][]> result = new ArrayList<>();
    public List<char[][]> eightQueue() {
        char[][] board = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = '*';
            }
        }
        backtrack(0, board);
        return result;
    }

    // row：阶段
    // board：路径，记录已经做出的决策
    // 可选列表：通过 board 推导出来，没有显示记录
    public void backtrack(int row, char[][] board) {
        // 结束条件，得到可行解
        if (row == 8) {
            char[][] snapshot = new char[8][8];
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    snapshot[i][j] = board[i][j];
                }
            }
            result.add(snapshot);
            return;
        }

        for (int col = 0; col < 8; col++) {// 每一行都有 8 种放法
            if (isOk(board, row, col)) { // 可选列表
                board[row][col] = 'Q';// 做选择，第 row 行的棋子放到了 col 列
                backtrack(row+1, board);// 考察下一行
                board[row][col] = '*';// 恢复选择
            }
        }
    }

    // 判断 row 行 column 列放置是否合适
    private boolean isOk(char[][] board, int row, int col) {
        int n = 8;
        // 检查列是否有冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // 检查右上对角线是否有冲突
        int i = row - 1;
        int j = col + 1;
        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }
        // 检查左上对角线是否有冲突
        i = row - 1;
        j = col - 1;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
