package 大数问题;

public class 大数相乘
{
	public String bigNumProduct(String str1, String str2)
	{
		if(str1 == null || str1.length()==0 || str2 == null || str2.length()==0)
			return "";
		int[] nums1 = new int[str1.length()];
		int[] nums2 = new int[str2.length()];
		int[] result = new int[str1.length()+str2.length()+5];
		for(int i = 0; i < str1.length(); i++)
			nums1[i] = str1.charAt(str1.length()-1-i) - '0';
		for(int i = 0; i < str2.length(); i++)
			nums2[i] = str2.charAt(str2.length()-1-i) - '0';
		
		//第二个数乘第一个，先不进位
		for(int i = 0; i < str1.length(); i++)
		{
			for(int j = 0; j <str2.length(); j++)
			{
				result[i+j] += nums1[i]*nums2[j];
			}
		}
		
		//统一进位
		for(int i = 0; i < result.length; i++)
		{
			if(result[i] >= 10)
			{	
				result[i+1] += result[i]/10;
				result[i]%=10;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		boolean isZeroBegin = true;
		for(int i = result.length-1; i >=0; i--)
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
		String num1 = "";
		String num2 = "5";
		String bigNumProduct = new 大数相乘().bigNumProduct(num1, num2);
		System.out.println(bigNumProduct);
	}
}
