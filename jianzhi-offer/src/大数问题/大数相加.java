package 大数问题;

public class 大数相加
{
	
	/**
	 * 条件：num1和num2都不为负
	 * 如果带负数：两者都为负，同大数相加，
	 * 一正一负，使用大数相减
	 * 几个关键点：
	 * 1、num1和num2为String
	 * 2、将数字转化成int数组，需要倒序
	 * 3、相加
	 * 4、输出时需要将前面的0去掉。
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String addBigNumber1(String num1, String num2)
	{
		int maxLength = Math.max(num1.length(), num2.length());
		
		int[] sum = new int[maxLength+1];
		int[] numA = new int[maxLength];
		int[] numB = new int[maxLength];
		
		//将数字转化成int数组，需要倒序
		for(int i = 0; i < num1.length(); i++)
		{
			numA[i] = num1.charAt(num1.length()-i-1) - '0';
		}
		for(int i = 0; i < num2.length(); i++)
		{
			numB[i] = num2.charAt(num2.length()-i-1) - '0';
		}
		
		//相加
		for(int i = 0; i < maxLength; i++)
		{
			sum[i] += numA[i] + numB[i];
			if(sum[i]>=10)
			{
				sum[i+1]++;
				sum[i] = sum[i]%10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		//输出
		boolean isZeroBegin = true;
		for(int i = sum.length-1; i >= 0; i--)
		{
			if(isZeroBegin)
			{
				if(sum[i]==0)
				{
					continue;
				}
				isZeroBegin = false;
			}
			sb.append(sum[i]);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		String num1 = "11112";
		String num2 = "88888";
		
		String num = new 大数相加().addBigNumber1(num1, num2);
		System.out.println(num);
	}
}
