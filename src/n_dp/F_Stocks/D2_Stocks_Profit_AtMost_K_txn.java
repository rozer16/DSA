package n_dp.F_Stocks;

public class D2_Stocks_Profit_AtMost_K_txn {

    public static void main(String[] args) {
        int prices [] =  {3,3,5,0,0,3,1,4};
        D2_Stocks_Profit_AtMost_K_txn solution = new D2_Stocks_Profit_AtMost_K_txn();
        System.out.println(solution.maxProfit(3,prices));
    }
    public int maxProfit(int k, int[] prices) {
        return  maxProfitSpaceOptimization(prices, k);
    }

    public int maxProfitSpaceOptimization(int[] prices, int cap1) {

        int n = prices.length;

        int[][] ahead = new int[2][cap1+1];
        int[][] curr = new int[2][cap1+1];

        for(int index = n-1; index >= 0; index--){
            for(int canBuy = 0; canBuy < 2; canBuy++){
                for(int cap = 1; cap <= cap1; cap++){
                    int profit = 0;
                    if(canBuy == 0)
                        profit =  Math.max(
                                -prices[index]+ ahead[1][cap],
                                ahead[0][cap]
                        );
                    else
                        profit = Math.max(
                                prices[index] + ahead[0][cap-1],
                                ahead[1][cap]
                        );

                    curr[canBuy][cap] = profit;
                }
            }
            ahead = curr;
        }

        // The maximum profit with 2 transactions is stored in dp[0][0][2]
        return ahead[0][cap1];
    }
}
