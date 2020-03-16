package dynamicprogramming;

public class maxProfitSolution {
    public int maxProfit(int[] prices) {
        int minPrices = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0 ; i < prices.length; i++){
            if (prices[i] < minPrices)
                minPrices = prices[i];
            else if (prices[i] - minPrices > maxProfit)
                maxProfit = prices[i] - minPrices;
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int [] price = {7,0,5,3,6,4};
        maxProfitSolution maxProfit = new maxProfitSolution();
        System.out.println(maxProfit.maxProfit(price));
    }

}
