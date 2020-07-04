/**
 * 
 */
package 高质量代码;

public class 打印从1到最大的n位数
{
	public void printFrom1ToNDigits(int n)
	{
		if(n<=0) return ;
		
		char[] nums = new char[n];
		
		printFrom1ToNDigits(n, nums, 0);
	}
	
	public void printFrom1ToNDigits(int n,char[]nums,int index)
	{
		//成功条件
		if(index == n)
		{
			print(nums);
			return ;
		}
		//因为是排列，不需要移除选择过的东西
		for(int i = 0; i < 10; i++)
		{
			nums[index] = (char) (i + '0');
			printFrom1ToNDigits(n, nums, index+1);
		}
	}
	
	public void print(char[] nums)
	{
		boolean isZeroBegin = true;
		for(int i = 0; i < nums.length; i++)
		{
			if(isZeroBegin && nums[i]!='0')
				isZeroBegin = false;
			if(!isZeroBegin)
				System.out.print(nums[i]);
		}
		if(!isZeroBegin)
			System.out.print("\t");
	}
	
	public static void main(String[] args)
	{
		new 打印从1到最大的n位数().printFrom1ToNDigits(2);
	}
}
