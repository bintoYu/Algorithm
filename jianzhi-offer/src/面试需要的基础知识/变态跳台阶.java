package 面试需要的基础知识;

public class 变态跳台阶
{
    public int JumpFloorII(int target) {
    	if(target == 0)	return 0;
    	int[] dp = new int[target+1];
    	dp[0] = 1;
    	dp[1] = 1;
    	if(target >= 2)
    	{
    		for(int i = 2; i <= target; i++)
    		{
    			dp[i] = 0;
    			for(int j = 0; j < i; j++)
    			{
    				dp[i] += dp[j];
    			}
    		}
    	}
    	return dp[target];
    }
    
    public static void main(String[] args)
	{
		int jumpFloorII = new 变态跳台阶().JumpFloorII(4);
		System.out.println(jumpFloorII);
	}
}
