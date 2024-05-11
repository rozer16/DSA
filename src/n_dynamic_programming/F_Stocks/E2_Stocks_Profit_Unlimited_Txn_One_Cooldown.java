package n_dynamic_programming.F_Stocks;

public class E2_Stocks_Profit_Unlimited_Txn_One_Cooldown {

    public static void main(String[] args) {
        int prices [] =  {3,3,5,0,0,3,1,4};
        E2_Stocks_Profit_Unlimited_Txn_One_Cooldown solution = new E2_Stocks_Profit_Unlimited_Txn_One_Cooldown();
        System.out.println(solution.maxProfitSpaceOptimization(3,prices));
    }
    public int maxProfit(int[] prices) {
        //return maxProfitRecursion(0,0,1, prices);

        /*int [][] dp = new int[prices.length][2];
        for(int [] row:dp)
            Arrays.fill(row, -1);

        return maxProfitMemoization(0,0,1, prices,dp);*/

        //return maxProfitTabulation(1,prices);

        return maxProfitSpaceOptimization(1, prices);
    }


    /*

    Time Complexity: 2^n Exponential
    SC : Auxiliary stack space
    * */
    public int maxProfitRecursion(int index, int canBuy, int coolDown, int[] prices) {
        if(index >= prices.length)
            return 0;

        int profit = 0;
        if(canBuy == 0){
            profit =  Math.max(
                    -prices[index] + maxProfitRecursion(index+1, 1,coolDown,prices),
                    maxProfitRecursion(index+1, 0,coolDown,prices)
            );
        }else{
            profit =  Math.max(
                    prices[index] + maxProfitRecursion(index+1+coolDown, 0,coolDown,prices),
                    maxProfitRecursion(index+1, 1,coolDown,prices)
            );
        }
        return profit;
    }



    /*
    Time Complexity: O(N*2)

    Reason: There are N*2 states therefore at max ‘N*2’ new problems will be solved and we are running a for loop for ‘N’ times to calculate the total sum

    Space Complexity: O(N*2) + O(N)

    Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*2)).
    * */
    public int maxProfitMemoization(int index, int canBuy, int coolDown, int[] prices, int [][] dp) {
        if(index >= prices.length)
            return 0;


        if(dp[index][canBuy] != -1)
            return dp[index][canBuy];


        int profit = 0;


        if(canBuy == 0){
            profit =  Math.max(
                    -prices[index] + maxProfitRecursion(index+1, 1,coolDown,prices),
                    maxProfitRecursion(index+1, 0,coolDown,prices)
            );
        }else{
            profit =  Math.max(
                    prices[index] + maxProfitRecursion(index+1+coolDown, 0,coolDown,prices),
                    maxProfitRecursion(index+1, 1,coolDown,prices)
            );
        }
        dp[index][canBuy] = profit;
        return profit;
    }


    /*
    Time Complexity: O(N*2)

    Reason: There are two nested loops that account for O(N*2) complexity.

    Space Complexity: O(N*2)

    Reason: We are using an external array of size ‘N*2’. Stack Space is eliminated.
    * */
    public int maxProfitTabulation(int coolDown, int[] prices) {

        int n = prices.length;
        int [][] dp = new int[n+1+coolDown][2];

        for(int index = n-1; index >= 0; index--){
            for(int canBuy = 0; canBuy < 2; canBuy++){
                int profit = 0;
                if(canBuy == 0){
                    profit =  Math.max(
                            -prices[index] + dp[index+1] [1],
                            dp[index+1] [0]
                    );
                }else{
                    profit =  Math.max(
                            prices[index] + dp[index+1+coolDown][0],
                            dp[index+1][1]
                    );
                }
                dp[index][canBuy] = profit;
            }
        }

        return dp[0][0];
    }


    /*
    Time Complexity: O(N*2)

    Reason: There are two nested loops that account for O(N*2) complexity

    Space Complexity: O(1)

    Reason: We are using three external arrays of size ‘2’.
    * */

    //This method wont work for variable no of days cooldown since we need to declare cooldown+1 next
    public int maxProfitSpaceOptimization(int coolDown, int[] prices) {

        int n = prices.length;
        int [] next1 = new int[2];
        int [] next2 = new int[2];
        int [] curr = new int[2];

        for(int index = n-1; index >= 0; index--){
            for(int canBuy = 0; canBuy < 2; canBuy++){
                int profit = 0;
                if(canBuy == 0){
                    profit =  Math.max(
                            -prices[index] + next1[1],
                            next1[0]
                    );
                }else{
                    profit =  Math.max(
                            prices[index] + next2[0],
                            next1[1]
                    );
                }
                curr[canBuy] = profit;
            }
            System.arraycopy(next1, 0, next2, 0, 2);
            System.arraycopy(curr, 0, next1, 0, 2);

        }

        return next1[0];
    }
}
