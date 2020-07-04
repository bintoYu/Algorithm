package string;

public class Longest_Palindromic_Substring_5
{
    public String longestPalindrome(String s) {
    	if(s == null || s.equals(""))
    		return s;

    	char[] chars = s.toCharArray();
    	
    	int maxLength = 1,start=0;
    	
    	//奇数:aba,abcba
    	for(int i = 0; i < chars.length; i++)
    	{
    		int left = i-1,right = i+1;
    		while(left>=0 && right < chars.length && chars[left]==chars[right])
    		{
    			if(right-left+1 > maxLength)
    			{
    				maxLength = right-left+1;
    				start = left;
    			}
    			left--;
    			right++;
    		}
    	}
    	
    	//偶数:abba
    	for(int i = 0; i < chars.length; i++)
    	{
    		int left = i,right = i+1;
    		while(left>=0 && right < chars.length && chars[left]==chars[right])
    		{
    			if(right-left+1 > maxLength)
    			{
    				maxLength = right-left+1;
    				start = left;
    			}
    			left--;
    			right++;
    		}
    	}
    	
    	return s.substring(start, start+maxLength);
    }
	

	
	public static void main(String[] args)
	{
		String str = new Longest_Palindromic_Substring_5().longestPalindrome("bcaBBacdf");
		System.out.println(str);
	}
}
