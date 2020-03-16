package dynamicprogramming;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int minIndex = getMinIndex(prices);
        int max = 0;
        for (int i = minIndex + 1; i < prices.length; i++){
            if (max < prices[i] - prices[minIndex])
                max = prices[i] - prices[minIndex];
        }
        return max;
    }

    private Integer getMinIndex(int[] prices) {
        int min = prices[0];
        int minIndex = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
                minIndex = i;
            }

        }
        return minIndex;
    }

    public static void main(String[] args) {
        int [] price = {7,1,5,3,6,4};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit(price));
    }

}
