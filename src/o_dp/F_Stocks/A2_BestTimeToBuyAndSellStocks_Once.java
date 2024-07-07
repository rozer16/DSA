package o_dp.F_Stocks;

public class A2_BestTimeToBuyAndSellStocks_Once {

    public static void main(String[] args) {

        int [] prices = {7,1,5,3,6,4};
        A2_BestTimeToBuyAndSellStocks_Once solution = new A2_BestTimeToBuyAndSellStocks_Once();
        System.out.println("Maximum profit : "+solution.maxProfit(prices));
    }

    /*
    Time Complexity: O(N)

    Reason: We are performing a single iteration

    Space Complexity: O(1)

    Reason: No extra space is used.

    * */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int min = prices[0];

        for(int day = 1; day < prices.length; day++){
            int tempProfit = prices[day] - min;
            maxProfit = Math.max(maxProfit, tempProfit);
            min = Math.min(min, prices[day]);
        }

        return maxProfit;
    }
}
