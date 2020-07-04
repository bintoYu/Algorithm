/**
 * 
 */
package 数据结构;

/**
 * 和leetcode旋转数组中查找数字还有一些不同
 * 不同之处在于：
 * 1、循环的条件不同：以往的是start<end，现在要比较的是值
 * 2、还需要考虑三个位置值相同的情况，此时需要顺序查找
 * 3、break的条件不一样了
 */
public class 旋转数组的最小数字
{
    public int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0)
        	return 0;
        int start = 0,end = array.length-1;
        int res = 0;
        while(array[start] >= array[end])
        {
        	int mid = (start + end)/2;
        	if(end - start == 1)
        	{
        		res = end;
        		break;
        	}
        	
        	if(array[start] == array[mid] && array[mid] == array[end])
        	{
        		//循环查找
        	}
        	
        	if(array[mid] > array[start])
        		start = mid;
        	else
        		end = mid;
        }
        return array[res];
    }
    
    
    public static void main(String[] args)
	{
		int array[] = {3,4,5,1,2};
		
		System.out.println(new 旋转数组的最小数字().minNumberInRotateArray(array));
	}
}
