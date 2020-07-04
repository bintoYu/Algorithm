/**
 * 
 */
package 解决面试题的思路;

import java.util.ArrayList;
import java.util.HashSet;

//通过测试
public class 字符串的排列
{
	ArrayList<String> result = new ArrayList<>();
	HashSet<String> set = new HashSet<String>();
	
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0) return result;
        
        permutation(str.toCharArray(),0);
        //记得去重
        result.addAll(set);
        return result;
    }
    
    private void permutation(char[] charArray,int index)
    {
    	//成功条件
    	if(index == charArray.length)
    		set.add(new String(charArray));
    	
    	for(int i = index; i < charArray.length; i++)
    	{
    		swap(charArray,index,i);
    		permutation(charArray, index+1);
    		swap(charArray,index,i);
    	}
    }
    
    private void swap(char[] str,int i, int j)
    {
    	char tmp = str[i];
    	str[i] = str[j];
    	str[j] = tmp;
    }
    
    public static void main(String[] args)
	{
    	ArrayList<String> result = new 字符串的排列().Permutation("aa");
		System.out.println(result.toArray());
	}
}
