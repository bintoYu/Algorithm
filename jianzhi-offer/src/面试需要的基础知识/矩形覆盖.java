package 面试需要的基础知识;

public class 矩形覆盖
{
    public int RectCover(int target) {
    	if(target == 0) return 0;
    	if(target == 1) return 1;
    	int[] dp = new int[target+1];
    	dp[0] = 0;
    	dp[1] = 1;
    	dp[2] = 2;
    	if(target > 2)
    	{
    		for(int i = 3; i <= target; i++)
    			dp[i] = dp[i-1] + dp[i-2];
    	}
    	
    	return dp[target];
    }
    
    public static void main(String[] args)
	{
		int rectCover = new 矩形覆盖().RectCover(1);
	}
}
