/**
 * 
 */
package 递归;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ybt
 *
 * @date 2018年9月12日  
 * @version 1.0  
 */
public class Generate_Parentheses_22
{
	private ArrayList<String> list = new ArrayList<>();
	
    public List<String> generateParenthesis(int n) {
        
        getParentheses(n/2, "", 0, 0);
        
        return list;
    }
    
    private void getParentheses(int n,String current, int left, int right)
    {
    	if(current.length() == n * 2)
    	{
    		list.add(current);
    		return ;
    	}
    	
    	if(left < n)
    	{
    		getParentheses(n, current + "(", left + 1, right);
    	}
    	
    	if(right < left)
    	{
    		getParentheses(n, current + ")", left, right + 1);
    	}
    }
    
    public static void main(String[] args)
	{
		List<String> result = new Generate_Parentheses_22().generateParenthesis(6);
		
		System.out.println(result);
	}
}
