/**
 * 
 */
package 面试中的各项能力;

import java.util.LinkedList;

public class 圆圈中最后剩下的数字
{
	public int getLastNumFromCircle(int n,int m)
	{
		if(n < 0 || m < 1) return -1;
		if(n == 0) return 0;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 0; i < n; i++)
			list.add(i);
		
		int index = 0;
		int res = 0;
		while(!list.isEmpty())
		{
			index = (index + m -1)%list.size();
			res = list.remove(index);
		}
		
		return res;
	}
}
