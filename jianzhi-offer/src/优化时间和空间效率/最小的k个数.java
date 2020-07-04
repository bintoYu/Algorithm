/**
 * 
 */
package 优化时间和空间效率;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的k个数
{
	
	//方法二：使用PriorityQueue来存储k个数，时间效率为O(nlogk),优先使用该方法！
	public ArrayList<Integer> theLeastKNumber1(int[] nums,int k)
	{
		ArrayList<Integer> list = new ArrayList<>();
		if(nums == null || nums.length == 0) return list;
		
//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
//			  
//	        @Override
//	        public int compare(Integer o1, Integer o2) {
//	            return o2.compareTo(o1);
//	        }
//	    });

		//使用lamda表达式
		PriorityQueue<Integer> queue = new PriorityQueue<>(k,(o1,o2) -> o2.compareTo(o1));
		
		for(int i = 0; i < nums.length; i++)
		{
			if(queue.size() < k)
				queue.offer(nums[i]);
			else if(queue.peek() > nums[i])
			{
				queue.poll();
				queue.offer(nums[i]);
			}
		}
		
		for(Integer num : queue)
			list.add(num);
		return list;
	}
	
	
	//方法一：使用partition方法，O(n)，但是会改变数组
	public ArrayList<Integer> theLeastKNumber(int[] nums,int k)
	{
		ArrayList<Integer> list = new ArrayList<>();
		if(nums == null || nums.length == 0) return list;
		
		int begin = 0,end = nums.length-1;
		int index = partition(nums,begin,end);
		while(index != k-1)
		{
			if(index < k-1)
			{
				begin = index+1;	
			}
			else
			{
				end = index-1;
			}
			index = partition(nums,begin,end);
		}
		
		for(int i = 0; i < k; i++)
			list.add(nums[i]);
		
		return list;
	}
	
	public int partition(int[] nums,int begin,int end)
	{
		int key = nums[begin];
		while(begin<end)
		{
			//从后往前，将比key小的移至低端
			while(end > begin && nums[end]>=key)
				end--;
			nums[begin] = nums[end];
			//从前往后，将比key大的移至高端
			while(end > begin && nums[begin]<key)
				begin++;
			nums[end] = nums[begin];
		}
		nums[end] = key;
		return end;
	}
	
	public static void main(String[] args)
	{
		int[] nums = {11,1,101,2,6,8,3,54,21,12,9,4};
		ArrayList<Integer> theLeastKNumber1 = new 最小的k个数().theLeastKNumber1(nums, 4);
		for (Integer integer : theLeastKNumber1)
		{
			System.out.println(integer);
		}
	}
}
