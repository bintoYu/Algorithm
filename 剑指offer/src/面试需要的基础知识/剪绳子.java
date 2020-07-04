package 面试需要的基础知识;

public class 剪绳子
{
	/**
	 * 关键点：
	 * 1、对于1，2，3的返回值与dp值不同。原因如下：
	 * 因为题目要求绳子本身大于1，因此小于2返回0
	 * 且至少剪成两根，因此长度为2返回1，长度为3返回2.
	 * 但对于长绳子来说，剪成长度为1的绳子其值就为1.
	 * @param length
	 * @return
	 */
	public int getMax(int length)
	{
		if(length < 2) return 0;
		else if(length == 2) return 1;
		else if(length == 3) return 2;
		int[] dp = new int[length+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		
		for(int i = 4; i <= length; i++)
		{
			for(int j = 1; j <= i/2; j++)
			{
				dp[i] = Math.max(dp[i], dp[i-j]*dp[j]);
			}
		}
		
		return dp[length];
	}
}
