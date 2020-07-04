/**
 * 
 */
package 解决面试题的思路;

import java.util.Stack;

//通过测试
public class 栈的压入弹出序列
{
	public boolean isPopOrder(int[] pushOrder,int[] popOrder)
	{
		if(pushOrder == null || popOrder == null || pushOrder.length == 0 || popOrder.length == 0)
			return false;
		int pushIndex = 0;
		int popIndex = 0;
		Stack<Integer> stack = new Stack<>();
		while(popIndex < popOrder.length)
		{
			while(stack.isEmpty() || stack.peek() != popOrder[popIndex])
			{
				//假如push完了
				if(pushIndex >= pushOrder.length)
					break;
				stack.push(pushOrder[pushIndex]);
				pushIndex++;
			}
			
			//验证是false时直接return
			if(stack.peek() != popOrder[popIndex])
				return false;
			
			//验证过的pop掉
			stack.pop();
			popIndex++;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		int[] pushOrder = {1,2,3,4,5};
		int[] popOrder = {4,3,5,1,2};
		
		boolean result = new 栈的压入弹出序列().isPopOrder(pushOrder, popOrder);
		System.out.println(result);
	}
}
