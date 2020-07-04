package array;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum_416
{
    public boolean canPartition(int[] nums) {
    	int sum = 0;
    	for(int num : nums)
        	sum += num;        
        if(sum%2 == 1)
        	return false;
        else
        {
        	int half = sum/2;
        	return canSum(nums, half);
        }
    }
    
	public boolean canSum(int[] nums, int target)
	{
		boolean[] dp = new boolean[target+1];
    	Arrays.fill(dp, false);
    	dp[0] = true;
    	for(int num : nums)
    	{
    		for(int j = target; j >= num; j--)
    		{
    			dp[j] = dp[j] || dp[j-num];
    		}
    	}
    	
    	return dp[target];
	}
    
    public static void main(String[] args)
	{
    	int[] nums = {1,2,3,4,5,6,7};
    	boolean canPartition = new Partition_Equal_Subset_Sum_416().canPartition(nums);
    	System.out.println(canPartition);
	}
}
