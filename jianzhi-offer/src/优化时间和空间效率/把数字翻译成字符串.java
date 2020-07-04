/**
 * 
 */
package 优化时间和空间效率;

//通过
public class 把数字翻译成字符串
{
	public int theCountFromNumToString(int num)
	{
		if(num < 0) return -1;
		String str = num + "";
		return theCountFromNumToString(str.toCharArray());
	}
	
	public int theCountFromNumToString(char[] num)
	{
		if(num.length == 1)
			return 1;
		int dp[] = new int[num.length];
		dp[num.length - 1] = 1;
		int number = (num[num.length-2] - '0')*10 + num[num.length-1] - '0';
		if(number >= 10 && number <= 25)
			dp[num.length - 2] = 2;
		else
			dp[num.length - 2] = 1;
		
		int g = 0;
		for(int i = num.length-3; i >= 0; i--)
		{
			number = (num[i] - '0')*10 + num[i+1] - '0';
			g = (number >= 10 && number <= 25)?1:0;
			dp[i] = dp[i+1] + g*dp[i+2];
		}
		
		return dp[0];
	}
	
//	public int theCountFromNumToString(char[] num)
//	{
//		if(num.length == 1)
//			return 1;
//		int dp[] = new int[num.length];
//		dp[0] = 1;
//		int number = (num[0] - '0')*10 + num[1] - '0';
//		if(number >= 10 && number <= 25)
//			dp[1] = 2;
//		else
//			dp[1] = 1;
//		
//		int g = 0;
//		for(int i = 2; i < dp.length; i++)
//		{
//			number = (num[i-1] - '0')*10 + num[i] - '0';
//			g = (number >= 10 && number <= 25)?1:0;
//			dp[i] = dp[i-1] + g*dp[i-2];
//		}
//		
//		return dp[dp.length-1];
//	}
	
	public static void main(String[] args)
	{
		int res = new 把数字翻译成字符串().theCountFromNumToString(12258);
		System.out.println(res);
	}
}
