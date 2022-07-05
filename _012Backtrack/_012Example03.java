package _012Backtrack;

// 回溯例题3、0-1背包

public class _012Example03 {

    public int maxW = Integer.MIN_VALUE;// 存储背包中物品总重量的最大值

    public int bage(int[] items, int w) {
        backtrack(items, 0, 0, w);
        return maxW;
    }

    // k：阶段
    // cw：路径，记录已经选择的物品的总重量
    // items[k]：选择列表，选或不选
    // w：剪枝的条件
    private void backtrack(int[] items, int k, int cw, int w) {
        // cw==w 表示装满了；i==n 表示已经考察完所有物品
        if (cw == w || k == items.length) {
            if (cw > maxW) {
                maxW = cw;
                return;
            }
        }
        // 做选择
        backtrack(items, k+1, cw, w);// 不装
        if (cw + items[k] <= w) {// 剪枝
            backtrack(items, k+1, cw+items[k], w);// 装
        }
        // 都是局部变量，自动撤销选择
    }
}
