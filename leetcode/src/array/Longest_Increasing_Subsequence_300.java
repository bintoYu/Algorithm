package array;

import java.util.Arrays;

public class Longest_Increasing_Subsequence_300
{
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int max = 1;
        
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i]>nums[j])
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args)
	{
		int[] nums = {10,9,2,5,3,4};
		
		int lengthOfLIS = new Longest_Increasing_Subsequence_300().lengthOfLIS(nums);
		System.out.println(lengthOfLIS);
	}
}
