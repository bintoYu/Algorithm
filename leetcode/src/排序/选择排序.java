package 排序;

import java.util.Arrays;

public class 选择排序
{
	public void selectSort(int[] nums)
	{
		if(nums == null || nums.length == 0)
			return ;

		for(int i = 0; i < nums.length; i++)	//注意从前往后
		{
			int minIndex = i;
			for(int j = i+1; j < nums.length; j++)
			{
				if(nums[j] < nums[minIndex])
					minIndex = j;
			}
			
			int tmp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = tmp;
		}
	}
	
	
	public static void main(String[] args)
	{
		int[] nums = {6,7,2,3,4,5};
		new 选择排序().selectSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
