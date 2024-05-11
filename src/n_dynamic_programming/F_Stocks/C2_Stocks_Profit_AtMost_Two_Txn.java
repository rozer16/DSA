package n_dynamic_programming.F_Stocks;

public class C2_Stocks_Profit_AtMost_Two_Txn {

    public static void main(String[] args) {
        int prices [] =  {3,3,5,0,0,3,1,4};
        C2_Stocks_Profit_AtMost_Two_Txn solution = new C2_Stocks_Profit_AtMost_Two_Txn();
        System.out.println(solution.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        // return maxProfitRecursion(0,0,2,prices);


        /*
        int n = prices.length;
        // Creating a 3D dp array of size [n][2][3]
        int[][][] dp = new int[n][2][3];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfitMemoization(0,0,2,prices,dp);
        */

        return maxProfitSpaceOptimization(prices,2);
    }


    /*
            TC : 2^n : Buy/NotBuy OR sell/notSell
            SC : Stack Auxiliary space
     */
    public int maxProfitRecursion(int index, int canBuy, int cap, int[] prices) {
        if(index == prices.length)
            return 0;
        if(cap == 0)
            return 0;

        int profit = 0;
        if(canBuy == 0)
            profit =  Math.max(
                    -prices[index]+ maxProfitRecursion(index+1,1,cap,prices),
                    maxProfitRecursion(index+1, 0, cap, prices)
            );
        else
            profit = Math.max(
                    prices[index] + maxProfitRecursion(index+1,0,cap-1, prices),
                    maxProfitRecursion(index+1,1,cap, prices)
            );

        return profit;
    }

    /*
    Time Complexity: O(N*2*3)

    Reason: There are N*2*3 states therefore at max ‘N*2*3’ new problems will be solved.

    Space Complexity: O(N*2*3) + O(N)

    Reason: We are using a recursion stack space(O(N)) and a 3D array ( O(N*2*3)).

     */
    public int maxProfitMemoization(int index, int canBuy, int cap, int[] prices, int[][][] dp) {
        if(index == prices.length)
            return 0;
        if(cap == 0)
            return 0;

        if(dp[index][canBuy][cap] != -1)
            return dp[index][canBuy][cap];

        int profit = 0;
        if(canBuy == 0)
            profit =  Math.max(
                    -prices[index]+ maxProfitMemoization(index+1,1,cap,prices,dp),
                    maxProfitMemoization(index+1, 0, cap, prices,dp)
            );
        else
            profit = Math.max(
                    prices[index] + maxProfitMemoization(index+1,0,cap-1, prices,dp),
                    maxProfitMemoization(index+1,1,cap, prices,dp)
            );

        dp[index][canBuy][cap] = profit;
        return profit;
    }

    public int maxProfitTabulation(int[] prices, int cap1) {

        int n = prices.length;

        int[][][] dp = new int[n+1][2][cap1+1];

        // Base condition from recursion, not required to write , just for understanding written here
        for(int i=0; i<= cap1 ; i++)
            dp[0][0][i] = 0;

        for(int index = n-1; index >= 0; index--){
            for(int canBuy = 0; canBuy < 2; canBuy++){
                for(int cap = 1; cap <= cap1; cap++){
                    int profit = 0;
                    if(canBuy == 0)
                        profit =  Math.max(
                                -prices[index]+ dp[index+1][1][cap],
                                dp[index+1][0][cap]
                        );
                    else
                        profit = Math.max(
                                prices[index] + dp[index+1][0][cap-1],
                                dp[index+1][1][cap]
                        );

                    dp[index][canBuy][cap] = profit;
                }
            }
        }

        // The maximum profit with 2 transactions is stored in dp[0][0][2]
        return dp[0][0][2];
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
        return ahead[0][2];
    }
}
