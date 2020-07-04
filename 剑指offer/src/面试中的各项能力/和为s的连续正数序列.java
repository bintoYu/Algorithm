/**
 * 
 */
package 面试中的各项能力;

import java.util.ArrayList;

public class 和为s的连续正数序列
{
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if(sum < 3) return res;
        int small = 1,big = 2;
        int middle = (1+sum)/2;
        int curSum = 3;
        while(small < middle)
        {
        	while(curSum < sum)
        	{
        		big++;
        		curSum += big;
        	}
        	while(curSum > sum)
        	{
        		curSum -= small;
        		small++;
        	}
        	if(curSum == sum)
        	{
        		addList(small,big);
        		big++;
        		curSum += big;
        	}
        }
        
        return res;
    }
    
    public void addList(int small,int big)
    {
    	ArrayList<Integer> list = new ArrayList<>();
    	for(int i = small; i <= big; i++)
    		list.add(i);
    	res.add(list);
    }
    
    public static void main(String[] args)
	{
		ArrayList<ArrayList<Integer>> findContinuousSequence = new 和为s的连续正数序列().FindContinuousSequence(15);
		System.out.println(findContinuousSequence);
	}
}
