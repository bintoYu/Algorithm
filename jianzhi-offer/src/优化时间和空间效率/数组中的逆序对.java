/**
 * 
 */
package 优化时间和空间效率;

public class 数组中的逆序对
{
	private int[] temp;
	private int count;
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0) return -1;
        temp = new int[array.length];
        sort(array,0,array.length-1);
        return count;
    }
    
    private void sort(int[] array,int begin,int end)
    {
    	if(begin < end)
    	{
    		int mid = (begin+end)/2;
    		sort(array, begin, mid);
    		sort(array, mid+1, end);
    		merge(array, begin, mid ,end);
    	}
    }
    
    private void merge(int[] array,int begin,int mid,int end)
    {
    	int i = mid, j = end;
    	for(int index = begin; index <= end; index++)
    	{
    		temp[index] = array[index];
    	}
    	int index = end;
    	
    	while(i>=begin && j>=mid+1)
    	{
    		//左边i大于右边j，证明右边的j-mid个数都小于左边的i
    		//要记得把array更新一下
    		if(temp[i] > temp[j])
    		{
    			count += j-mid;
    			count %= 1000000007;
    			array[index--] = temp[i--];
    		}
    		else
    		{
    			array[index--] = temp[j--];
    		}
    	}
    	
    	while(i>=begin)
    		array[index--] = temp[i--];
    	while(j>=mid+1)
    		array[index--] = temp[j--];
    }
    
    public static void main(String[] args)
	{
		int[] nums = {7,6,5,4};
		int res = new 数组中的逆序对().InversePairs(nums);
		System.out.println(res);
	}
}
