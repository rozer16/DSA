package n_dynamic_programming.F_Stocks;

public class B2_Stocks_Unlimited_Buy_Sell {

    public static void main(String[] args) {


    }


    public int maxProfit(int[] prices) {
        //return maxProfitRecursion(0, false,prices);

        /*int [][] dp = new int[prices.length][2];
        for(int[] rows : dp)
            Arrays.fill(rows, -1);

         return   maxProfitMemoization(0, 0,prices, dp); */
        return maxProfitSpaceOptimization(prices);
    }

    /*
        TC : 2^n(Exponential) since you have two option buy/not Buy or sell/not sell
        SC : O(n) recursive stack space


    */
    public int maxProfitRecursion(int index, boolean isBought, int[] prices){

        if(index == prices.length)
            return 0;

        //If previous not bought then buy
        if(!isBought){
            int maxi = 0 ;
            //Buy
            maxi = Math.max(maxi, -1*prices[index] + maxProfitRecursion(index+1, true, prices));
            //Not buy
            return Math.max(maxi, maxProfitRecursion(index+1, false, prices));
        }else{
            int maxi = 0 ;
            //Sell
            maxi = Math.max(maxi, prices[index] + maxProfitRecursion(index+1, false, prices));
            //Not sell
            return Math.max(maxi, maxProfitRecursion(index+1, true, prices));
        }
    }


    public int maxProfitMemoization(int index, int isBought, int[] prices, int [][] dp ){

        if(index == prices.length)
            return 0;

        if(dp[index][isBought] != -1)
            return dp[index][isBought];

        //If previous not bought then buy
        if(isBought == 0){
            int maxi = 0 ;
            //Buy
            maxi = Math.max(maxi, -1*prices[index] + maxProfitMemoization(index+1, 1, prices,dp));
            //Not buy
            dp[index][isBought] = Math.max(maxi, maxProfitMemoization(index+1, 0, prices,dp));
            return dp[index][isBought];
        }else{
            int maxi = 0 ;
            //Sell
            maxi = Math.max(maxi, prices[index] + maxProfitMemoization(index+1, 0, prices,dp));
            //Not sell
            dp[index][isBought] = Math.max(maxi, maxProfitMemoization(index+1, 1, prices,dp));
            return dp[index][isBought];
        }
    }

    public int maxProfitTabulation(int[] prices){

        int n = prices.length;
        int [][] dp  = new int[n+1][2];


        // Base condition from recursion, not required to write , just for understanding written here
        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int index = n-1; index >= 0 ; index--){
            for(int isBought = 0; isBought < 2; isBought ++){
                if(isBought == 0){
                    int maxi = 0 ;
                    //Buy
                    maxi = Math.max(maxi, -1*prices[index] + dp[index+1][1]);
                    //Not buy
                    dp[index][isBought] = Math.max(maxi, dp[index+1][0]);

                }else{
                    int maxi = 0 ;
                    //Sell
                    maxi = Math.max(maxi, prices[index] + dp[index+1][0]);
                    //Not sell
                    dp[index][isBought] = Math.max(maxi, dp[index+1] [1]);

                }
            }
        }

        return dp[0][0]  ;
    }

    public int maxProfitSpaceOptimization(int[] prices){

        int n = prices.length;
        int []ahead  = new int[2];



        for(int index = n-1; index >= 0 ; index--){
            int []curr  = new int[2];
            for(int isBought = 0; isBought < 2; isBought ++){
                if(isBought == 0){
                    int maxi = 0 ;
                    //Buy
                    maxi = Math.max(maxi, -1*prices[index] + ahead[1]);
                    //Not buy
                    curr[isBought] = Math.max(maxi, ahead[0]);

                }else{
                    int maxi = 0 ;
                    //Sell
                    maxi = Math.max(maxi, prices[index] + ahead[0]);
                    //Not sell
                    curr[isBought] = Math.max(maxi, ahead[1]);

                }
            }
            ahead = curr;
        }

        return ahead[0]  ;
    }
}
