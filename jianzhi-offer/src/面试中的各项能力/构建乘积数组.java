package 面试中的各项能力;

public class 构建乘积数组
{
	private int[] getMultiplySequence(int[] nums)
	{
		if(nums == null || nums.length == 0) return nums;
		int[] numsB = new int[nums.length];
		int[] numsC = new int[nums.length];
		int[] numsD = new int[nums.length];
		
		numsC[0] = 1;
		
		for(int i = 1; i < nums.length; i++)
		{
			numsC[i] = numsC[i-1] * nums[i-1];
		}
		
		numsD[nums.length-1] = 1;
		for(int i = nums.length-2; i >= 0; i--)
		{
			numsD[i] = numsD[i+1] * nums[i+1];
		}
		
		for(int i = 0; i < nums.length; i++)
		{
			numsB[i] = numsC[i]*numsD[i];
		}
		
		return numsB;
	}
}
