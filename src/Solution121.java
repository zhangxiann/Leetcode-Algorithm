public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<2)
            return 0;
        int minPrice=prices[0];
        int maxProfit=0;
        for (int price: prices){
            int profit = price-minPrice;
            if (profit > maxProfit)
                maxProfit = profit;
            if (price < minPrice)
                minPrice=price;
        }
        return maxProfit;
    }
}
