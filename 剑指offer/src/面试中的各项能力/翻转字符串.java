/**
 * 
 */
package 面试中的各项能力;

public class 翻转字符串
{
	public String reverse(char[] str)
	{
		if(str==null || str.length==0) return null;
		//先翻转整个字符串
		reverseString(str, 0, str.length-1);
		//对每个空格的单词翻转
		int begin=0,end=0;
		while(end < str.length)
		{
			while(end < str.length && str[end] != ' ')
				end++;
			reverseString(str, begin, end-1);
			end++;
			begin = end;
		}
		return String.valueOf(str);
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
		char[] str = "hahah".toCharArray();
		String reverse = new 翻转字符串().reverse(str);
		System.out.println(reverse);
	}
}
