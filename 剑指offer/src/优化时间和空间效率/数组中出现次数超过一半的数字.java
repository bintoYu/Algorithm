package 优化时间和空间效率;

public class 数组中出现次数超过一半的数字
{
	public int MoreThanHalfNum(int[] array)
	{
		if(array == null || array.length == 0) return 0;
		
		int result = array[0];
		int count = 1;
		
		for(int i = 1; i < array.length; i++)
		{
			if(result != array[i])
            {
                count--;
                if(count == 0)
                    result = array[i];
            }
            count++;
		}
		
		if(!checkMoreThanHalf(array,result))
			return 0;
		else
			return result;
	}
	
	private boolean checkMoreThanHalf(int[] array, int result)
	{
		int count = 0;
		for(int i = 0; i < array.length; i++)
		{
			if(result == array[i])
				count++;
		}
		if(count*2 > array.length)
			return true;
		else
			return false;
	}

	public static void main(String[] args)
	{
		int[] nums = {1,0,1,0,1,0,1};
		int res = new 数组中出现次数超过一半的数字().MoreThanHalfNum(nums);
		System.out.println(res);
	}
}
