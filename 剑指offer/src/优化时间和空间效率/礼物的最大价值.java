/**
 * 
 */
package 优化时间和空间效率;

public class 礼物的最大价值
{
	public int getValue(int[][] nums)
	{
		if(nums == null || nums.length == 0 || nums[0].length == 0)
			return -1;
		int[][] dp = new int[nums.length][nums[0].length];
		for(int i = 0; i < nums.length; i++)
		{
			for(int j = 0; j < nums[0].length; j++)
			{
				int up = 0;
				int left = 0;
				if(i > 0)
					up = dp[i-1][j];
				if(j > 0)
					left = dp[i][j-1];
				dp[i][j] = Math.max(up, left) + nums[i][j];
			}
		}
		
		return dp[nums.length-1][nums[0].length-1];
	}
	
	
}
