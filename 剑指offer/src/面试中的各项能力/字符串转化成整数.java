package 面试中的各项能力;

//测试通过
public class 字符串转化成整数
{
	private boolean isValidInput = false;
	
	public int strToInteger(String num)
	{
		if(num == null || num.length() == 0)
			return -1;
		
		char[] numChars = num.toCharArray();
		int index = 0;
		boolean isMinus = false;
		
		if(numChars[0] == '+')
			index++;
		if(numChars[0] == '-')
		{
			index++;
			isMinus = true;
		}
		
		return strToInteger(numChars, index, isMinus);
		
	}
	
	public int strToInteger(char[] nums,int index,boolean isMinus)
	{
		long num = 0;
		int flag = isMinus? -1:1;
		while(index < nums.length && nums[index] >= '0' && nums[index] <= '9')
		{
			num = num*10 + flag*(nums[index++] - '0');
			
			if((!isMinus && num > Integer.MAX_VALUE) || (isMinus && num < Integer.MIN_VALUE))
			{
				isValidInput = false;
				return 0;
			}
		}
		
		if(index < nums.length)
			isValidInput = false;
		
		return (int)num;
	}
	
	public static void main(String[] args)
	{
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
