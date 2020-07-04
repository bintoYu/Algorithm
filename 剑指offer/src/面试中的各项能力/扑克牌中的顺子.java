/**
 * 
 */
package 面试中的各项能力;

import java.util.Arrays;

public class 扑克牌中的顺子
{
	public boolean isContinuousSequence(int[] nums)
	{
		if(nums == null || nums.length == 0) return false;
		
		Arrays.sort(nums);
		
		int zeroNum = 0;
		for(int i = 0; i < nums.length && nums[i] == 0; i++)
			zeroNum++;
		
		int numberOfGap = 0;
		for(int i = zeroNum+1; i < nums.length; i++)
		{
			//对子
			if(nums[i-1] == nums[i])
				return false;
			
			numberOfGap += nums[i]-nums[i-1]-1;
		}
		
		return numberOfGap > zeroNum? false:true;
	}
}
