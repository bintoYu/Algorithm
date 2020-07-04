package 递归;

public class Min_Cost_Climbing_Stairs_746
{
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2;i < cost.length; i++)
        {
            dp[i] = Math.min(dp[i-2],dp[i-1])+cost[i];
        }
        
        return Math.min(dp[cost.length-2],dp[cost.length-1]);
    }
}
