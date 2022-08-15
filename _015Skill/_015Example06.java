package _015Skill;

// 121. 买卖股票的最佳时机（前缀后缀统计）

public class _015Example06 {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[] max = new int[n];
        int curMax = 0;
        for (int i = n-1; i >= 0; i--) {
            max[i] = curMax;
            if (prices[i] > curMax) curMax = prices[i];
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (result < max[i] - prices[i]) {
                result = max[i] - prices[i];
            }
        }
        return result;
    }
}
