class Solution {
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length, buy = 0, sell = -prices[0];
        for (int i = 1; i < N; i++) {
            buy = Math.max(buy, sell + prices[i] - fee);
            sell = Math.max(sell, buy - prices[i]);
        }
        return buy;
    }
}