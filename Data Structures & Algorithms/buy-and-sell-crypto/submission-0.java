class Solution {
    public int maxProfit(int[] prices) {
        int max =0;
        int minPrice = Integer.MAX_VALUE;
        for( int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            max = Math.max( max, profit);
        }
        return max;
    }
}
