import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 生产者消费者
{
	ReentrantLock lock = new ReentrantLock();
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();
	
	LinkedList<Integer> queue;
	int limit;
	
	public 生产者消费者(int limit) {
		queue = new LinkedList<>();
		this.limit = limit;
	}
	
	public void produce(int i) {
		lock.lock();
		try{
			if(queue.size() == limit) {
				notFull.await();
			}
			queue.offer(i);
			notEmpty.signal();
		}catch (InterruptedException e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void mergeSort(int[] nums) {
		int[] tmp = new int[nums.length];
		mergeSort(nums, 0, nums.length-1,tmp);
	}
	
	private void mergeSort(int[] nums, int begin, int end, int[] tmp) {
		int mid = (begin + end)/2;
		mergeSort(nums,begin,mid,tmp);
		mergeSort(nums,mid+1,end,tmp);
		merge(nums,begin,mid,end,tmp);
	}

	private void merge(int[] nums, int begin, int mid, int end, int[] tmp){
		int i = begin,j=mid+1;
		int k = 0;
		while(i <= mid && j <= end) {
			tmp[k++] = nums[i]<nums[j]? nums[i++]:nums[j++];
		}
		while(i <= mid){
			tmp[k++] = nums[i++];
		}
		while(j <= mid){
			tmp[k++] = nums[j++];
		}
		for(int index = 0; index <= k; index++) {
			nums[begin++] = tmp[index++];
		}
	}
	
}
