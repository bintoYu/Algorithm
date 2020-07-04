package 大数问题;

public class 大树相减
{
	public String minusBigNumber(String num1,String num2)
	{
		//num1 > num2 --> 直接减
		//num1 < num2 : 1位数小于2 或 位数相同但数值小  --> 留符号，然后1和2交换
		boolean isPositive = true;
		if(num1.length() < num2.length())
		{
			isPositive = false;
			String tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		else if(num1.length() == num2.length())
		{
			for(int i = 0; i < num1.length(); i++)
			{
				if(num1.charAt(i) < num2.charAt(i))
				{
					isPositive = false;
					String tmp = num1;
					num1 = num2;
					num2 = tmp;
					break;
				}
				else if(num1.charAt(i) == num2.charAt(i))
					continue;
				else
					break;
			}
		}
		
		//两数相减（与加法流程极为相似）
		//初始化，注意逆序
		int maxLength = Math.max(num1.length(), num2.length());
		int[] numA = new int[maxLength];
		int[] numB = new int[maxLength];
		int[] result = new int[maxLength];
		for(int i = 0; i < num1.length(); i++)
		{
			numA[i] = num1.charAt(num1.length()-i-1) - '0';
		}
		for(int i = 0; i < num2.length(); i++)
		{
			numB[i] = num2.charAt(num2.length()-i-1) - '0';
		}		
		//减法
		for(int i = 0; i < result.length; i++)
		{
			result[i] += numA[i] - numB[i];
			if(result[i] < 0)
			{
				result[i+1]--;
				result[i] += 10;
			}
		}
		
		//输出
		StringBuffer sb = new StringBuffer();
		if(!isPositive) sb.append("-");
		boolean isZeroBegin = true;
		for(int i = result.length-1; i >= 0; i--)
		{
			if(isZeroBegin)
			{
				if(result[i]==0)
					continue;
				isZeroBegin = false;
			}
			sb.append(result[i]);
		}
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		String num1 = "1111111";
		String num2 = "1119991";
		String minusBigNumber = new 大树相减().minusBigNumber(num1, num2);
		System.out.println(minusBigNumber);
	}
}
