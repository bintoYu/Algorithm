/**
 * 
 */
package 面试中的各项能力;

import java.util.ArrayList;
import java.util.LinkedList;

public class 滑动窗口的最大值
{
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
    	ArrayList<Integer> list = new ArrayList<>();
        if(num == null || num.length == 0 || size <= 0 || size > num.length) return list;
        LinkedList<Integer> queue = new LinkedList<>();
        
        //先初始化：进索引
        for(int i = 0; i < size; i++)
        {
        	while(!queue.isEmpty() && num[queue.getLast()] < num[i])
        		queue.pollLast();
        	queue.offer(i);
        }
        
        list.add(num[queue.getFirst()]);
        
        //窗口右移=判断+进索引
        for(int i = size; i < num.length; i++)
        {
        	if(queue.getFirst() < i-size+1)
        		queue.pollFirst();
        	
        	while(!queue.isEmpty() && num[queue.getLast()] < num[i])
        		queue.pollLast();
        	queue.offer(i);
        	list.add(num[queue.getFirst()]);
        }
        return list;
        
    }
    
    public static void main(String[] args)
	{
    	int[] num = {2,3,4,2,6,2,5,1};
		ArrayList<Integer> maxInWindows = new 滑动窗口的最大值().maxInWindows(num, 3);
		System.out.println(maxInWindows);
	}
}
