package 面试需要的基础知识;

public class 二进制中1的个数
{
	public int numberOf1(int n)
	{
		int count = 0;
		while(n!=0)
		{
			count++;
			n = n&(n-1);
		}
		return count;
	}
	
	public int numberOfOne(int n)
	{
		int count = 0;
		int flag = 1;
		while(flag != 0)
		{
			if((n & flag)!=0)
				count++;
			flag = flag << 1;
		}
		
		return count;
	}
}
