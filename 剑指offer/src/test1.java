import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 */

public class test1
{
	   public ArrayList<Integer> maxInWindows(int [] num, int size){
	        ArrayList<Integer> res=new ArrayList<>();
	        //如果数组为空或长度为0，滑动窗口长度为0或滑动窗口长度大于数组长度
	        if(num==null || num.length==0 || size==0 || size>num.length)
	            return res;
	        //定义一个双向队列用来保存滑动窗口中的最大值
	        LinkedList<Integer> deque=new LinkedList<>();
	        //初始化滑动窗口
	        for(int i=0;i<size;i++){
	            //如果队列非空且窗口元素依次与队尾元素比较，若大于队尾元素，则删除队尾元素
	            while(!deque.isEmpty() && num[i]>num[deque.getLast()])
	                deque.pollLast();
	            //将最大值的下标从队尾开始存储到双向队列中,保证队列首元素为当前窗口最大值下标
	            deque.offerLast(i);
	        }
	        res.add(num[deque.peekFirst()]);
	        //右移滑动窗口
	        for(int i=size;i<num.length;i++){
	            //判断最大值是否已经滑出滑动窗口
	            if(!deque.isEmpty() && deque.peekFirst()<=i-size)
	                deque.pollFirst();
	            while(!deque.isEmpty() && num[i]>num[deque.peekLast()])
	                deque.pollLast();
	            deque.offerLast(i);
	            res.add(num[deque.peekFirst()]);
	        }
	        return res;
	    }
	   
	   public static void main(String[] args)
	{
		int[] nums = {4,3,2,2,6,2,5,1};
		ArrayList<Integer> maxInWindows = new test1().maxInWindows(nums, 3);
		for (Integer integer : maxInWindows)
		{
			System.out.println(integer);
		}
	}
}
