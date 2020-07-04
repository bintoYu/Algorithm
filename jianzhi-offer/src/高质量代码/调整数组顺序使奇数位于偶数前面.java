/**
 * 
 */
package 高质量代码;

public class 调整数组顺序使奇数位于偶数前面
{
	public void reorderOddAndEven(int[] array)
	{
		if(array == null || array.length == 0)
			return ;
		int left = 0,right = array.length-1;
		while(left < right)
		{
			while(array[left]%2 == 1 && left < right)
				left++;
			while(array[right]%2 == 0 && right > left)
				right--;
			
			if(left < right)
			{
				//交换
				int tmp = array[right];
				array[right] = array[left];
				array[left] = tmp;
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] array = {1,2,3,4,5,6,7};
		new 调整数组顺序使奇数位于偶数前面().reorderOddAndEven(array);
		System.out.println(1);
	}
}
