/**
 * 
 */
package 面试中的各项能力;

public class 股票的最大利润
{
	public int maxProfitOfStock(int[] nums)
	{
		if(nums == null || nums.length == 0) return 0;
		int[] dp = new int[nums.length];
		dp[0] = 0;
		int min = nums[0];
		for(int i = 1; i < nums.length; i++)
		{
			min = Math.min(min, nums[i]);
			dp[i] = Math.max(dp[i-1], nums[i]-min);
		}
		
		return dp[nums.length-1];
	}
	
	public static void main(String[] args)
	{
		int[] nums = {9,8,7,6,5,4,3,2,1};
		int maxProfitOfStock = new 股票的最大利润().maxProfitOfStock(nums);
		System.out.println(maxProfitOfStock);
	}
}
