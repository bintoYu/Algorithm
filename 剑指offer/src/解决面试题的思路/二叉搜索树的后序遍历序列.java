/**
 * 
 */
package 解决面试题的思路;

public class 二叉搜索树的后序遍历序列
{
	public boolean isPostOrderSequence(int[] sequence)
	{
		if(sequence == null || sequence.length == 0) return false; 
		return isPostOrderSequence(sequence, 0, sequence.length-1);
	}
	
	public boolean isPostOrderSequence(int[] nums,int begin,int end)
	{
		if(begin == end) return true;
		
		int root = nums[end];
		int i = begin;
		//搜索小于根的部分
		for(; i < end; i++)
		{
			if(nums[i] > root)
				break;
		}
		int mid = i;
		//搜索大于根的部分
		for(;i < end; i++)
		{
			if(nums[i] < root)
				return false;
		}
		
		return isPostOrderSequence(nums, begin, mid-1) && isPostOrderSequence(nums, mid, end-1);
	}
	
	public static void main(String[] args)
	{
		int[] nums ={5,7,6,9,11,10,8};
		boolean postOrderSequence = new 二叉搜索树的后序遍历序列().isPostOrderSequence(nums);
		System.out.println(postOrderSequence);
	}
}
