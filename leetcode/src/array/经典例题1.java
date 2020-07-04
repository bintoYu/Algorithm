package array;

import java.util.Arrays;

public class 经典例题1
{
	
	public boolean canSum(int[] nums, int target)
	{
		//初始化有点像背包问题
		boolean[] dp = new boolean[target+1];
    	Arrays.fill(dp, false);
    	dp[0] = true;
    	//循环方式也有点像背包问题
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
		boolean a = new 经典例题1().canSum(nums, 14);
		System.out.println(a);
	}
}
