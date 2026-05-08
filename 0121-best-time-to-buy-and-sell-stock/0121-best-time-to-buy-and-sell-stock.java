class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxProfit=0;
        int bp=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(bp>prices[i]){
                bp=prices[i];
            }else{
                int sell=prices[i]-bp;
                maxProfit=Math.max(maxProfit,sell);
            }
        }
        return maxProfit;
    }
}