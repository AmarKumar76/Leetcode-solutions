class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        solve(n,dp);
        return dp[n];
    }
    public static int solve(int n,int dp[]){
        if(n<=2){
            dp[n]=n;
            return dp[n];
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=solve(n-1,dp)+solve(n-2,dp);
    }
}