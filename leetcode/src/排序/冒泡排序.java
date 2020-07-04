package 排序;

import java.util.Arrays;

public class 冒泡排序
{
	public void bubbleSort(int[] nums)
	{
		if(nums == null || nums.length == 0)
			return ;

		boolean isSorted;
		for(int i = nums.length-1; i >= 0; i--)
		{
			isSorted = true;
			for(int j = 0; j < i; j++)
			{
				if(nums[j] > nums[j+1])
				{
					int tmp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
					isSorted = false;
				}
			}
			if(isSorted)
				break;
		}
	}
	
	
	public static void main(String[] args)
	{
		int[] nums = {6,1,2,3,4,5};
		new 冒泡排序().bubbleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
