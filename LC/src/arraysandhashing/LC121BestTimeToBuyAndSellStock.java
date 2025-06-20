package arraysandhashing;

public class LC121BestTimeToBuyAndSellStock {

    public int maxProfit (int[] prices) {
        int maxProfit = 0;
        int buyingPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - buyingPrice);
            buyingPrice = Math.min(buyingPrice, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        LC121BestTimeToBuyAndSellStock lc121 = new LC121BestTimeToBuyAndSellStock();
        System.out.println(lc121.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(lc121.maxProfit(new int[]{7,6,4,3,1}));
    }
}
