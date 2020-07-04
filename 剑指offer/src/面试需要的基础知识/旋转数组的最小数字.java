package 面试需要的基础知识;

public class 旋转数组的最小数字
{
	/**
	 * 例子1:{5,6,1,2,3,4} 特点：第一个中间值middle=(0+5)/2=2 刚好指向最小值1.
	 * 例子2:{1,0,1,1,1} 需要我们考虑三者值相同的情况下，得改成顺序查找
	 * 例子3:{},为空值
	 * 例子4:{1},只有一个值
	 * @param nums
	 * @return
	 */
	public int getMin(int[] nums)
	{
		if(nums == null || nums.length == 0)
			return Integer.MIN_VALUE;
		else if(nums.length == 1)
			return nums[0];
		
		int begin = 0,end = nums.length-1;
		while(begin+1!=end && begin < end)
		{
			int middle = (begin+end)/2;
			if(nums[begin] == nums[end] && nums[begin] == nums[middle]) return getMinByOrder(nums, begin, end);
			
			if(nums[begin] <= nums[middle]) begin = middle;
			else if(nums[end] >= nums[middle]) end = middle;
		}
		
		return nums[begin+1];
	}
	
	public int getMinByOrder(int nums[],int begin,int end)
	{
		int min = nums[begin];
		for(int i = begin+1; i < end; i++)
		{
			min = Math.min(min, nums[i]);
		}
		return min;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {4,5,1,2,3};
		int min = new 旋转数组的最小数字().getMin(nums);
		System.out.println(min);
	}
}
