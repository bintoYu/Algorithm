/**
 * 
 */
package 面试中的各项能力;

public class 左旋转字符串
{
	public char[] leftRotateString(char[] str,int n)
	{
		if(str == null || str.length == 0) return null;
		if(n <= 0 || n >= str.length) return str;
		reverseString(str, 0, n-1);
		reverseString(str, n, str.length-1);
		reverseString(str, 0, str.length-1);
		return str;
	}
	
	public void reverseString(char[] str,int begin,int end)
	{
		while(begin < end)
		{
			char tmp = str[begin];
			str[begin] = str[end];
			str[end] = tmp;
			
			begin++;
			end--;
		}
	}
	
	public static void main(String[] args)
	{
		char[] str = "abcdefg".toCharArray();
		char[] leftRotateString = new 左旋转字符串().leftRotateString(str,0);
		System.out.println(String.valueOf(str));
	}
}
