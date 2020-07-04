/**
 * 
 */
package 优化时间和空间效率;

public class 数字序列中某一位的数字
{
	public int getNum(int index)
	{
		if(index < 0) return -1;
		if(index < 10) return index;
		int digit = 1;
		while(index > 0)
		{
			//获取某一位在序列中占据的位数
			int num = countNumber(digit);
			if(index > num)
				index -= num;
			else
			{
				return getNum(index,digit);
			}
			digit++;
		}
		
		return -1;
	}
	
	public int countNumber(int digit)
	{
		return digit*9*((int)Math.pow(10, digit-1));
	}
	
	public int getNum(int index,int digit)
	{
		// 100+811/3 = 370
		int num = ((int)Math.pow(10, digit-1)) + index/digit;
		//811%3=1
		int tmp = index % digit;
		//370 从0开始数 结果为7
		for(int i = 0; i < digit-tmp; i++)
			num/=10;
		return num % 10;
	}
}
