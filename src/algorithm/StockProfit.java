package algorithm;

public class StockProfit {

    public int maxProfit1(int[] prices) {
        if (prices.length == 0)
            return 0;
        int[] dp0 = new int[prices.length];
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        dp0[0] = 0;
        dp1[0] = -prices[0];
        dp2[0] = 0;
        int maxRes = 0;
        for (int i = 1; i < prices.length; i++) {
            dp0[i] = dp0[i-1];
            dp1[i] = Math.max(dp1[i-1], dp0[i-1] - prices[i]);
            dp2[i] = dp1[i-1] + prices[i];
            int tmpMax = Math.max(dp0[i], dp2[i]);
            maxRes = Math.max(tmpMax, maxRes);
        }

        return Math.max(0, maxRes);
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0)
            return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += (prices[i] - prices[i-1]);
            }
        }
        return profit;
    }

    public int maxProfit3(int[] prices) {
        if (prices.length == 0)
            return 0;
        int selled1 = 0;
        int selled2 = 0;
        int hold1 = -prices[0];
        int hold2 = Integer.MIN_VALUE;
        for (int price : prices) {
            selled2 = Math.max(selled2, hold2 + price);
            hold2 = Math.max(hold2, selled1 - price);
            selled1 = Math.max(selled1, hold1 + price);
            hold1 = Math.max(hold1, - price);
        }
        return selled2;
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        if (k == 0)
            return 0;
        if (k >= prices.length/2) {
            return maxProfit2(prices);
        }
        int[] selled = new int[k];
        int[] hold = new int[k];
        for (int i = 0; i < hold.length; i++) {
            hold[i] = Integer.MIN_VALUE;
        }
        for (int price : prices) {
            hold[0] = Math.max(hold[0], -price);
            selled[0] = Math.max(selled[0], hold[0] + price);
            for (int i = 1; i < k; i++) {
                selled[i] = Math.max(selled[i], hold[i] + price);
                hold[i] = Math.max(hold[i], selled[i-1] - price);
            }
        }
//        int maxProfit = 0;
//        for (int p : selled) {
//            if (p > maxProfit) {
//                maxProfit = p;
//            }
//        }
        return selled[k-1];
    }

    public int maxProfitV2(int k, int[] prices) {
        if (prices.length == 0)
            return 0;
        if (k == 0)
            return 0;
        if (k >= prices.length/2) {
            return maxProfit2(prices);
        }
        int[][] none = new int[prices.length][k];
        int[][] hold = new int[prices.length][k];
        none[0][0] = 0;
        hold[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    none[i][j] = Math.max(none[i-1][j], Integer.MIN_VALUE);
                    hold[i][j] = Math.max(hold[i-1][j], none[i-1][j] - prices[i]);
                }else {
                    none[i][j] = Math.max(none[i-1][j], hold[i-1][j-1] + prices[i]);
                    hold[i][j] = Math.max(hold[i-1][j], none[i-1][j] - prices[i]);
                }

            }
        }
        int maxProfit = 0;
        for (int p : none[prices.length-1]) {
            if (p > maxProfit) {
                maxProfit = p;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};
        int[] prices4 = {3,3,5,0,0,3,1,4};
        int[] prices5 = {3,2,6,5,0,3};
        int[] prices6 = {2,4,1};
        int[] prices7 = {6,1,3,2,4,7};
        int[] prices8 = {3,2,6,5,0,3};
        StockProfit stockProfit = new StockProfit();
        int maxProfit = stockProfit.maxProfit1(prices);
//        maxProfit = stockProfit.maxProfit(prices);
        maxProfit = stockProfit.maxProfit(2, prices8);

        System.out.println(maxProfit);
    }
}
