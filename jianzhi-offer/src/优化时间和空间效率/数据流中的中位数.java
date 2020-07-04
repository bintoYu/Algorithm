/**
 * 
 */
package 优化时间和空间效率;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 数据流中的中位数
{
	private int count = 0;
	//默认就是最小堆
	private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((o1,o2)->
	{
		return o2.compareTo(o1);
	});
	
    public void Insert(Integer num) {
        if(count%2 == 0)
        {
        	minHeap.offer(num);
        	maxHeap.offer(minHeap.poll());
        }
        else
        {
        	maxHeap.offer(num);
        	minHeap.offer(maxHeap.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2 ==0)
        	return new Double((maxHeap.peek() + minHeap.peek()))/2;
        else
        	return new Double(maxHeap.peek());
    }
}
