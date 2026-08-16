class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        double mini = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int n = prices.length;
        int m = discounts.length;
       int i=n-1;
        int j=m-1;
        while(j>=0 && i>=0){
            mini +=prices[i]*(100-discounts[j])/100.0;
            j--;
            i--;
        }
        while(i>=0){
            mini+=prices[i];
            i--;
        }
        return mini;
    }
}