/**
 * 
 */
package 面试中的各项能力;

public class 零到n减1中缺失的数字
{
	public int getNum(int[] nums)
	{
		if(nums == null || nums.length == 0) return -1;
		int begin = 0,end = nums.length-1;

		while(begin<=end)
		{
			int middle = (begin+end)/2;
			if(nums[middle] != middle)
			{
				if(middle == 0)
					return 0;
				if(nums[middle-1] == middle-1)
					return middle;
				end = middle-1;
			}else
				begin = middle+1;
		}
		
		if(begin == nums.length-1)
			return nums.length;
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		int[] nums1 = {0,1,2,3,4};
		int[] nums2 = {1,2,3,4,5};
		int[] nums3 = {0,1,2,4,5};
		System.out.println(new 零到n减1中缺失的数字().getNum(nums1));
		System.out.println(new 零到n减1中缺失的数字().getNum(nums2));
		System.out.println(new 零到n减1中缺失的数字().getNum(nums3));
	}
}
